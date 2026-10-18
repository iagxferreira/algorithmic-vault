# Chapter 2: Selection Sort

## Exercise 2.1: Choosing a data structure for expense tracking

**Question.** You are building an app to track your finances. Each day, you
record what you spent and where. At the end of the month, you review the
expenses and summarize the total. Since the app performs many insertions and
few reads, should you use an array or a linked list?

**Textbook answer.** Choose a linked list when insertions are frequent and
reads are rare. Inserting at a known position in a linked list takes $O(1)$,
while inserting into the middle of an array may require shifting elements and
take $O(n)$.

**Practical mental model.** First ask *where* records are inserted. This app
adds each new expense at the end. A dynamic array (such as `std::vector`) can
append in $O(1)$ amortized time: when its capacity fills, it occasionally
allocates a larger block and copies the existing entries, an $O(n)$ operation.
Because capacity grows geometrically, those occasional copies average out over
many appends. If the approximate number of monthly records is known, reserve
capacity up front to reduce reallocations.

Both structures take $O(n)$ to visit all $n$ expenses for the monthly summary,
but a dynamic array usually provides faster sequential traversal and lower
per-record memory overhead. A linked list is more compelling when frequent
insertions or removals happen at positions already known; finding an arbitrary
position still takes $O(n)$.

So, the linked list is the exercise's intended answer under its simplified
assumptions. For an append-only expense log that is later scanned in order, a
dynamic array is also a strong practical choice.

## Exercise 2.2: Managing restaurant orders

**Question.** A restaurant app keeps a list of orders. Servers add orders to
the end, and chefs take the oldest order from the beginning to prepare it.
Which data structure should the app use?

**Answer.** Use a **queue**, which follows the FIFO (*first in, first out*)
rule: the first order added is the first one removed. A linked-list
implementation with pointers to both its head and tail supports adding at the
end and removing from the beginning in $O(1)$ time. A plain array may need to
shift all remaining orders when removing the first item; a circular buffer is
another efficient queue implementation. Among the exercise's array-versus-list
choices, a linked list is the intended answer.

## Exercise 2.3: Choosing storage for binary search

**Question.** A service keeps a list of usernames and frequently uses binary
search to look up users. Binary search needs random access to the middle of
the list. Should the usernames be stored in an array or a linked list?

**Answer.** Store them in an **array**. Arrays provide constant-time random
access, so binary search can inspect the middle element in $O(1)$ and complete
the lookup in $O(\log n)$ time. A linked list has no constant-time access to
its middle: reaching that node requires traversing the list, making the search
$O(n)$ overall.

A balanced search tree could be a reasonable alternative if the requirements
called for a different search structure, especially with frequent updates.
However, it is not one of the two choices in this exercise; for binary search,
the array's random access is the key requirement.

## Exercise 2.4: Frequent logins and user sign-ups

**Question.** People sign up for Facebook frequently too. Suppose you choose
an array to store the user list. What is the disadvantage of an array for
insertions? In particular, if binary search is used to look up logins, what
happens when a new user is added?

**Answer.** Binary search requires the array to stay sorted by login name. To
add a new user, find the correct position and shift later entries to make room.
In the worst case, this takes $O(n)$ time. A dynamic array may also occasionally
need to allocate a larger block and copy its entries. The benefit is that
logins remain fast at $O(\log n)$; if logins are much more frequent than
sign-ups, paying more for occasional insertions may be a reasonable trade-off.

A balanced search tree is an alternative when both lookup and insertion need
$O(\log n)$ time while preserving order. A hash map keyed by email can provide
$O(1)$ average-time lookup and insertion, but does not keep entries ordered.
For authentication, use the email to find the account and verify the submitted
password against a secure password hash; never store passwords in plaintext.
