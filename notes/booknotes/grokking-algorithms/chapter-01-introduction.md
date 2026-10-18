# Chapter 1: Introduction to Algorithms

## Exercise 1.1: Binary search steps

**Question.** Suppose a list contains 128 names and you are using binary
search. What is the maximum number of steps needed to find the desired name?

**Answer.** The expected textbook answer is **7 steps**, since
$\log_2 128 = 7$: each step halves the remaining search range, and seven
halvings reduce 128 candidates to one.

There is a small distinction between this halving-count convention and counting
individual comparisons in a concrete binary-search implementation. For 128
items, an implementation can require **8 comparisons** in the worst case
(for example, if the desired name is at the deepest leaf of its search tree).
Thus, use 7 for the exercise's intended logarithmic calculation; if “step” means
an equality comparison, the precise worst-case count is 8. In either
convention, the running time is $O(\log n)$.

## Exercise 1.2: Doubling the list

**Question.** If the list length is doubled, how many maximum steps are needed?

**Answer.** Doubling the list adds **one step** to binary search. The
textbook's halving-count convention goes from $\log_2 128 = 7$ to
$\log_2 256 = 8$. With individual comparisons counted, the worst case likewise
increases from 8 to 9. Each additional step lets binary search distinguish
twice as many possible names, so doubling the input increases the search by a
constant amount—not by a factor of two.

## Exercise 1.3: Looking up a phone number

**Question.** Given a person's name, find their phone number in a phone book.

**Answer.** Assuming the phone book is alphabetically sorted by name, use
binary search to locate the name, then read the corresponding phone number. The
lookup takes $O(\log n)$ time for a phone book with $n$ entries. If the entries
were not sorted and there were no index, a linear scan would instead take
$O(n)$ time in the average and worst cases.

## Exercise 1.5: Reading every phone number

**Question.** Read the phone number of every person in the phone book.

**Answer.** This takes $O(n)$ time for a phone book with $n$ entries. Every
entry must be visited, so this is a full table scan; sorting the names does not
help when the goal is to read all the numbers. Since all $n$ entries must be
read, the running time is more precisely $\Theta(n)$.

## Exercise 1.6: Reading numbers for names starting with A

**Question.** Read the phone numbers only for people whose names start with
the letter A. (This is tricky: the algorithm involves concepts explored more
deeply in Chapter 4.)

**Answer.** In an alphabetically sorted phone book, use binary search to find
the first name starting with A, then scan forward and read numbers until the
names no longer start with A. If there are $k$ matching names among $n$ total
entries, this takes $O(\log n + k)$ time. In the worst case, all names could
start with A, so the worst-case running time is $O(n)$.

A balanced search tree can provide the same $O(\log n + k)$ range-query cost
if it is already built; constructing it by inserting $n$ names takes
$O(n\log n)$. A trie can also be useful for repeated prefix queries, but
reporting all matching phone numbers still takes at least $\Omega(k)$ time.
These structures can speed up finding the matching range, but cannot avoid the
cost of reading each requested number.
