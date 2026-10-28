CXX ?= g++
CXXFLAGS ?= -std=c++20 -O2 -Wall -Wextra -Wshadow -pedantic
BUILD_DIR := build
EXAMPLE := $(BUILD_DIR)/example
TEST := $(BUILD_DIR)/tree_test

.PHONY: all build example run test clean

all: build

build: $(EXAMPLE)

example: $(EXAMPLE)

$(EXAMPLE): tree.cpp tree.h example.cpp
	mkdir -p $(BUILD_DIR)
	$(CXX) $(CXXFLAGS) tree.cpp example.cpp -o $(EXAMPLE)

$(TEST): tree.cpp tree.h tree_test.cpp
	mkdir -p $(BUILD_DIR)
	$(CXX) $(CXXFLAGS) tree.cpp tree_test.cpp -o $(TEST)

run: $(EXAMPLE)
	./$(EXAMPLE)

test: $(TEST)
	./$(TEST)

clean:
	rm -rf $(BUILD_DIR)
