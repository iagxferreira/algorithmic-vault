# Exercise 1.3: Printing a double with printDigit

**Book.** *Data Structures and Algorithm Analysis in C++* (Weiss), Chapter 1,
Exercise 1.3.

## Task

Write a function that outputs an arbitrary double, which may be negative, using
only `printDigit` for I/O. `printDigit(n)` outputs the single decimal digit `n`
when $0 \le n \le 9$ and outputs nothing otherwise.

## Requirements

- [ ] Handle negative values.
- [ ] Output the integer part using recursion over its digits.
- [ ] Output the fractional part with a fixed number of digits.
- [ ] Handle rounding that carries into the integer part (for example,
      `0.9999` printed with three fractional digits).
- [ ] Test zero, negative values, and values with leading zeros in the fraction.

## Scaffold

- `main.cpp` - stub; add the program here.
- `Makefile` - builds `build/main`; `make run` executes it.

## Notes

Decide up front how many fractional digits to print. The sign and the decimal
point are punctuation rather than digits; document that assumption in the code.
