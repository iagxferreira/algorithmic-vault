package structures

import (
	"errors"
	"testing"
)

func TestDynamicArrayZeroValueAndAppend(t *testing.T) {
	var values DynamicArray[string]
	if values.Len() != 0 || !values.Empty() {
		t.Fatal("zero-value array should be empty")
	}
	for i := 0; i < 100; i++ {
		values.Append("value")
	}
	if values.Len() != 100 || values.Empty() {
		t.Fatalf("got Len()=%d, Empty()=%v", values.Len(), values.Empty())
	}
	if got, err := values.At(99); err != nil || got != "value" {
		t.Fatalf("At(99) = %q, %v; want value, nil", got, err)
	}
}

func TestDynamicArrayInsertWhenFullGrowsAndShifts(t *testing.T) {
	var values DynamicArray[int]
	for i := 0; i < initialDynamicArrayCapacity; i++ {
		values.Append(i)
	}
	if err := values.Insert(3, 99); err != nil {
		t.Fatal(err)
	}
	want := []int{0, 1, 2, 99, 3, 4, 5, 6, 7}
	for i, expected := range want {
		got, err := values.At(i)
		if err != nil || got != expected {
			t.Fatalf("At(%d) = %d, %v; want %d, nil", i, got, err, expected)
		}
	}
}

func TestDynamicArrayInsertSetRemoveAndIndexOf(t *testing.T) {
	values := DynamicArray[int]{}
	values.Append(1)
	values.Append(3)
	if err := values.Insert(1, 2); err != nil {
		t.Fatal(err)
	}
	if previous, err := values.Set(1, 20); err != nil || previous != 2 {
		t.Fatalf("Set(1, 20) = %d, %v; want 2, nil", previous, err)
	}
	if got := values.IndexOf(20); got != 1 {
		t.Fatalf("IndexOf(20) = %d; want 1", got)
	}
	if removed, err := values.RemoveAt(1); err != nil || removed != 20 {
		t.Fatalf("RemoveAt(1) = %d, %v; want 20, nil", removed, err)
	}
	if got, _ := values.At(1); got != 3 {
		t.Fatalf("At(1) = %d; want shifted value 3", got)
	}
	if got := values.IndexOf(99); got != -1 {
		t.Fatalf("IndexOf(99) = %d; want -1", got)
	}
}

func TestDynamicArrayRejectsInvalidIndices(t *testing.T) {
	var values DynamicArray[int]
	for _, operation := range []struct {
		name string
		call func() error
	}{
		{"insert", func() error { return values.Insert(-1, 1) }},
		{"at", func() error { _, err := values.At(0); return err }},
		{"set", func() error { _, err := values.Set(0, 1); return err }},
		{"remove", func() error { _, err := values.RemoveAt(0); return err }},
	} {
		t.Run(operation.name, func(t *testing.T) {
			if err := operation.call(); !errors.Is(err, ErrIndexOutOfRange) {
				t.Fatalf("got error %v; want ErrIndexOutOfRange", err)
			}
		})
	}
	if err := values.Insert(1, 1); !errors.Is(err, ErrIndexOutOfRange) {
		t.Fatalf("Insert at Len() + 1 returned %v; want ErrIndexOutOfRange", err)
	}
}
