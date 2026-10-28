CXX ?= g++
CXXFLAGS ?= -std=c++20 -O2 -Wall -Wextra -Wshadow -pedantic
BUILD_DIR := build
EXAMPLE := $(BUILD_DIR)/example
TEST := $(BUILD_DIR)/quick_sort_test

.PHONY: all build example run test clean

all: build

build: $(EXAMPLE)

example: $(EXAMPLE)

$(EXAMPLE): quick_sort.cpp quick_sort.h example.cpp
	mkdir -p $(BUILD_DIR)
	$(CXX) $(CXXFLAGS) quick_sort.cpp example.cpp -o $(EXAMPLE)

$(TEST): quick_sort.cpp quick_sort.h quick_sort_test.cpp
	mkdir -p $(BUILD_DIR)
	$(CXX) $(CXXFLAGS) quick_sort.cpp quick_sort_test.cpp -o $(TEST)

run: $(EXAMPLE)
	./$(EXAMPLE)

test: $(TEST)
	./$(TEST)

clean:
	rm -rf $(BUILD_DIR)
