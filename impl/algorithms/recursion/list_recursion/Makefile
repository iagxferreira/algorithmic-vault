CXX ?= g++
CXXFLAGS ?= -std=c++20 -O2 -Wall -Wextra -Wshadow -pedantic
BUILD_DIR := build
EXAMPLE := $(BUILD_DIR)/example
TEST := $(BUILD_DIR)/list_recursion_test

.PHONY: all build example run test clean

all: build

build: $(EXAMPLE)

example: $(EXAMPLE)

$(EXAMPLE): list_recursion.cpp list_recursion.h example.cpp
	mkdir -p $(BUILD_DIR)
	$(CXX) $(CXXFLAGS) list_recursion.cpp example.cpp -o $(EXAMPLE)

$(TEST): list_recursion.cpp list_recursion.h list_recursion_test.cpp
	mkdir -p $(BUILD_DIR)
	$(CXX) $(CXXFLAGS) list_recursion.cpp list_recursion_test.cpp -o $(TEST)

run: $(EXAMPLE)
	./$(EXAMPLE)

test: $(TEST)
	./$(TEST)

clean:
	rm -rf $(BUILD_DIR)
