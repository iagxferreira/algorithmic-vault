CXX ?= g++
CXXFLAGS ?= -std=c++20 -O2 -Wall -Wextra -Wshadow -pedantic
BUILD_DIR := build
EXAMPLE := $(BUILD_DIR)/example
TEST := $(BUILD_DIR)/insertion_sort_test

.PHONY: all build run test clean

all: build

build: $(EXAMPLE)

$(EXAMPLE): insertion_sort.cpp insertion_sort.h example.cpp
	mkdir -p $(BUILD_DIR)
	$(CXX) $(CXXFLAGS) insertion_sort.cpp example.cpp -o $(EXAMPLE)

$(TEST): insertion_sort.cpp insertion_sort.h insertion_sort_test.cpp
	mkdir -p $(BUILD_DIR)
	$(CXX) $(CXXFLAGS) insertion_sort.cpp insertion_sort_test.cpp -o $(TEST)

run: $(EXAMPLE)
	./$(EXAMPLE)

test: $(TEST)
	./$(TEST)

clean:
	rm -rf $(BUILD_DIR)
