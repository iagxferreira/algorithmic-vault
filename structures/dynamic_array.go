package structures

import "errors"

// ErrIndexOutOfRange is returned when an index is outside the valid range.
var ErrIndexOutOfRange = errors.New("dynamic array index out of range")

const initialDynamicArrayCapacity = 8

// DynamicArray is a growable array. Its zero value is ready to use.
//
// T must be comparable so IndexOf can compare stored elements.
type DynamicArray[T comparable] struct {
	items []T
	size  int
}

// Len returns the number of elements stored in the array.
func (a *DynamicArray[T]) Len() int { return a.size }

// Empty reports whether the array contains no elements.
func (a *DynamicArray[T]) Empty() bool { return a.size == 0 }

// Append adds value to the end, doubling capacity when the array is full.
func (a *DynamicArray[T]) Append(value T) {
	if a.size == cap(a.items) {
		capacity := initialDynamicArrayCapacity
		if cap(a.items) > 0 {
			capacity = cap(a.items) * 2
		}
		grown := make([]T, capacity)
		copy(grown, a.items[:a.size])
		a.items = grown
	}
	a.items[a.size] = value
	a.size++
}

// Insert places value at index, shifting subsequent elements to the right.
// Index may equal Len to append.
func (a *DynamicArray[T]) Insert(index int, value T) error {
	if index < 0 || index > a.size {
		return ErrIndexOutOfRange
	}
	if a.size == cap(a.items) {
		a.Append(value)
		copy(a.items[index+1:a.size], a.items[index:a.size-1])
		a.items[index] = value
		return nil
	}
	var zero T
	a.items = a.items[:a.size+1]
	a.items[a.size] = zero
	copy(a.items[index+1:], a.items[index:a.size])
	a.items[index] = value
	a.size++
	return nil
}

// At returns the value at index.
func (a *DynamicArray[T]) At(index int) (T, error) {
	if index < 0 || index >= a.size {
		var zero T
		return zero, ErrIndexOutOfRange
	}
	return a.items[index], nil
}

// Set replaces the value at index and returns the previous value.
func (a *DynamicArray[T]) Set(index int, value T) (T, error) {
	if index < 0 || index >= a.size {
		var zero T
		return zero, ErrIndexOutOfRange
	}
	previous := a.items[index]
	a.items[index] = value
	return previous, nil
}

// RemoveAt removes and returns the value at index, shifting later elements left.
func (a *DynamicArray[T]) RemoveAt(index int) (T, error) {
	if index < 0 || index >= a.size {
		var zero T
		return zero, ErrIndexOutOfRange
	}
	removed := a.items[index]
	copy(a.items[index:], a.items[index+1:a.size])
	a.size--
	var zero T
	a.items[a.size] = zero
	return removed, nil
}

// IndexOf returns the index of the first matching value, or -1 if absent.
func (a *DynamicArray[T]) IndexOf(value T) int {
	for i := 0; i < a.size; i++ {
		if a.items[i] == value {
			return i
		}
	}
	return -1
}
