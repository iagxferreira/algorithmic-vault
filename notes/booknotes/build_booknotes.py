#!/usr/bin/env python3
"""Build the combined booknotes PDF from all scoped book folders."""

from pathlib import Path
import re
import subprocess


ROOT = Path(__file__).resolve().parents[2]
NOTES_DIR = Path(__file__).resolve().parent
BUILD_DIR = NOTES_DIR / "build"


def latex_escape(text: str) -> str:
    replacements = {
        "\\": r"\textbackslash{}",
        "&": r"\&",
        "%": r"\%",
        "$": r"\$",
        "#": r"\#",
        "_": r"\_",
        "{": r"\{",
        "}": r"\}",
        "~": r"\textasciitilde{}",
        "^": r"\textasciicircum{}",
    }
    return "".join(replacements.get(character, character) for character in text)


def markdown_inline(text: str) -> str:
    # Preserve inline math while escaping ordinary Markdown text for LaTeX.
    pieces = re.split(r"(\$.*?\$)", text)
    converted = []
    for piece in pieces:
        if piece.startswith("$") and piece.endswith("$"):
            converted.append(piece)
            continue
        escaped = latex_escape(piece)
        escaped = re.sub(r"\*\*(.+?)\*\*", r"\\textbf{\1}", escaped)
        escaped = re.sub(r"`(.+?)`", r"\\texttt{\1}", escaped)
        converted.append(escaped)
    return "".join(converted)


def markdown_to_latex(source: Path, destination: Path) -> None:
    lines = source.read_text(encoding="utf-8").splitlines()
    output = []
    paragraph = []

    def flush_paragraph() -> None:
        if paragraph:
            output.append(markdown_inline(" ".join(paragraph)))
            output.append("")
            paragraph.clear()

    for line in lines:
        heading = re.match(r"^(#{1,3})\s+(.+)$", line)
        if heading:
            flush_paragraph()
            command = {1: "chapter", 2: "section", 3: "subsection"}[len(heading.group(1))]
            output.append(f"\\{command}{{{markdown_inline(heading.group(2))}}}")
            output.append("")
        elif line.strip():
            paragraph.append(line.strip())
        else:
            flush_paragraph()
    flush_paragraph()
    destination.parent.mkdir(parents=True, exist_ok=True)
    destination.write_text("\n".join(output), encoding="utf-8")


def book_title(book_dir: Path) -> str:
    readme = book_dir / "README.md"
    for line in readme.read_text(encoding="utf-8").splitlines():
        if line.startswith("# "):
            return line[2:].strip()
    return book_dir.name.replace("-", " ").title()


def main() -> None:
    BUILD_DIR.mkdir(parents=True, exist_ok=True)
    generated_content = []
    book_dirs = sorted(
        path for path in NOTES_DIR.iterdir()
        if path.is_dir() and (path / "README.md").is_file()
    )

    for book_dir in book_dirs:
        chapters = sorted(book_dir.glob("chapter-*.tex")) + sorted(book_dir.glob("chapter-*.md"))
        if not chapters:
            continue
        generated_content.append(f"\\part{{{latex_escape(book_title(book_dir))}}}")
        for chapter in sorted(chapters):
            if chapter.suffix == ".tex":
                relative_path = chapter.relative_to(ROOT).with_suffix("").as_posix()
            else:
                generated_path = BUILD_DIR / "markdown" / book_dir.name / chapter.with_suffix(".tex").name
                markdown_to_latex(chapter, generated_path)
                relative_path = generated_path.relative_to(ROOT).with_suffix("").as_posix()
            generated_content.append(f"\\input{{{relative_path}}}")
        generated_content.append("")

    (BUILD_DIR / "booknotes-content.tex").write_text(
        "\n".join(generated_content), encoding="utf-8"
    )
    for _ in range(2):
        subprocess.run(
            [
                "pdflatex",
                "-interaction=nonstopmode",
                "-halt-on-error",
                "-output-directory=notes/booknotes/build",
                "-jobname=booknotes",
                "notes/booknotes/book.tex",
            ],
            cwd=ROOT,
            check=True,
        )


if __name__ == "__main__":
    main()
