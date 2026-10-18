# Chapter 3: Recursion and the Call Stack

## Exercise 5.1: Reading a call stack

**Question.** Suppose you are shown a call stack containing `greet` and
`greet2`, with `name = Maggie` in both frames. What can you infer from the
stack alone? Consider the same stack while a recursive function is executing.

**Answer.** Both calls are active, and each has its own local `name` value,
which is `Maggie`. The `greet2` frame is on top, so it is the call currently
executing; it was called by `greet`. When `greet2` returns, execution resumes
in `greet` where that call was made.

If both function bodies print `hello, Maggie`, then each call prints that
message, for two greetings total. The stack itself shows the active calls and
their local values, but the function code is needed to determine exactly what
they print and when.
