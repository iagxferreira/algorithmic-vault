# algorithm-studies

Learn data structures and algorithms by building them, reasoning about their
costs, and then using Go's standard library. This repository is a study
workbook: read the topic notes, implement one structure or technique, and
prove its behaviour with focused tests.

The active implementation is Go. The existing Java source and Gradle setup
are retained temporarily as migration material; they are not the target for
new work. Go implementations live in small, focused packages at the
repository root (for example, `structures`). Topics will move across from
Java as they are revisited, with their contracts and tests rewritten in Go
rather than mechanically translated.

## Start here

1. Read [`ROADMAP.md`](./ROADMAP.md) and pick the first unticked Go topic.
2. Read the topic note in `docs/` and answer its questions before coding.
3. Add a focused `_test.go` file, run it, then implement the behaviour.

```shell
go test ./structures -run DynamicArray
go test ./structures
go test ./...
```

Go 1.27 or newer is currently used for the module. No third-party test
framework is required; use `testing` and standard-library tools.

## Layout

```
structures/       data structures implemented from first principles
algorithms/       algorithm techniques (added as migrated)
usage/            idiomatic Go standard-library practice (added as migrated)
docs/
  structures/     one learning roadmap per data structure
  algorithms/     one learning roadmap per technique
  usage/          standard-library exercises
```

The Go packages are deliberately small and topic-focused. The zero value,
generic constraints, slices, maps, interfaces, and explicit errors are part
of the learning material—not details to hide behind a Java-shaped API.

## The learning sequence

1. **Build** — implement containers and understand their invariants and
   complexity.
2. **Walk** — implement algorithms that operate on those structures.
3. **Use** — compare your implementations with Go's built-in types and
   standard library.

Judge-style practice belongs in
[`competitive-programming-notebook`](../competitive-programming-notebook/).
Finish a topic here, then practice solving problems there.
