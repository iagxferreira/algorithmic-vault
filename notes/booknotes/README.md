# Competitive Programming Preparation Booknotes

This is the source for the compiled
**Competitive Programming Preparation Booknotes** volume. Keep each source
book and edition in its own folder. The build discovers those folders and adds
their chapter notes to the volume automatically.

## Build

From the repository root, run:

```sh
make book
```

The generated PDF is `notes/booknotes/build/booknotes.pdf`. Add chapter files
named `chapter-*.tex` or `chapter-*.md` to a book folder to include them in the
compiled volume; Markdown headings become scoped chapters and sections.

Current sources:

- [`introduction-to-algorithms/`](introduction-to-algorithms/README.md)
- [`grokking-algorithms/`](grokking-algorithms/README.md)
