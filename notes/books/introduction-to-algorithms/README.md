# Introduction to Algorithms (CLRS)

LaTeX notes and exercise answers for *Introduction to Algorithms* (CLRS). This
folder is organized as a book so the chapters can eventually be compiled into
an ebook.

Keep each chapter in its own LaTeX source file and include it from `book.tex`.
For example, add a future chapter as `chapter-02-getting-started.tex` and include
it from `book.tex`.

`pdflatex` turns `book.tex` and its included chapter sources into a PDF. From
the repository root, run it twice so the table of contents is updated; this
command puts generated files in `/tmp` to keep them out of the repository:

```sh
pdflatex -output-directory=/tmp notes/books/introduction-to-algorithms/book.tex
```

## Chapter template

```latex
\chapter{Chapter title}

\section{Exercise N.N-N: Exercise title}
Answer.
```
