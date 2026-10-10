# Dynamic array

`structures.DynamicArray[T]` — a growable array built on a Go slice backing
store.

## Why build it

Amortized append is the first practical use of amortized analysis. Go slices
already provide dynamic growth, so implementing the backing store yourself
makes capacity growth and element shifting visible instead of hiding the
lesson behind `append`.

## Understand before you write code

1. **Why geometric growth?** Growing by one causes quadratic total copying;
   doubling keeps n appends O(n) total and O(1) amortized per append. Work
   through the geometric sum.
2. **What does amortized mean?** Some appends copy every element. The claim is
   about the cost across a sequence, not a worst-case guarantee for each call.
3. **Why track size separately from capacity?** Allocated storage can contain
   unused slots. Only indices in `[0, Len())` are valid elements.
4. **Why do middle insertions and removals cost O(n)?** The elements after the
   changed index must shift.
5. **Why use a type parameter constraint?** `IndexOf` needs equality. The
   `comparable` constraint makes that requirement explicit at compile time;
   types containing slices or maps cannot be elements in this version.
6. **Why is the zero value useful?** A zero-value `DynamicArray[T]` is empty
   and ready to use, which is an important Go API design property.

## Implement

- [x] `Len`, `Empty` — expose logical size, not capacity
- [x] `Append` — manually grow by doubling and copy existing values
- [x] `At`, `Set` — return `ErrIndexOutOfRange` for invalid indices
- [x] `Insert`, `RemoveAt` — shift elements in the correct direction
- [x] `IndexOf`

## Traps

- `At(Len())` is invalid even if spare capacity exists.
- Insertion at `Len()` is valid; insertion beyond `Len()` is not.
- For overlapping shifts, insert from the end or use Go's overlap-safe `copy`.
- Clear the vacated slot after removal so references are not retained.
- Test insertion both when there is spare capacity and when growth is needed.

## Test it

```shell
go test ./structures -run DynamicArray
```

## Then use it

Compare this implementation with built-in slices and the `slices` package.
The goal is not to replace slices in ordinary Go code; it is to understand
their behaviour and API tradeoffs.
