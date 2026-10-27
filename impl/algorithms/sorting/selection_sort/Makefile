CXX ?= g++
CXXFLAGS ?= -std=c++20 -O2 -Wall -Wextra -Wshadow -pedantic
BUILD_DIR := build
EXAMPLE := $(BUILD_DIR)/example
TEST := $(BUILD_DIR)/selection_sort_test

.PHONY: all build example run test clean

all: build

build: $(EXAMPLE)

example: $(EXAMPLE)

$(EXAMPLE): selection_sort.cpp selection_sort.h example.cpp ../../../utils/print_vector.h
	mkdir -p $(BUILD_DIR)
	$(CXX) $(CXXFLAGS) selection_sort.cpp example.cpp -o $(EXAMPLE)

$(TEST): selection_sort.cpp selection_sort.h selection_sort_test.cpp
	mkdir -p $(BUILD_DIR)
	$(CXX) $(CXXFLAGS) selection_sort.cpp selection_sort_test.cpp -o $(TEST)

run: $(EXAMPLE)
	./$(EXAMPLE)

test: $(TEST)
	./$(TEST)

clean:
	rm -rf $(BUILD_DIR)
