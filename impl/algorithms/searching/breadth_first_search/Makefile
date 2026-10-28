CXX ?= g++
CXXFLAGS ?= -std=c++20 -O2 -Wall -Wextra -Wshadow -pedantic
BUILD_DIR := build
TREE_DIR := ../../../data-structures/tree
CPPFLAGS := -I$(TREE_DIR)
EXAMPLE := $(BUILD_DIR)/example
TEST := $(BUILD_DIR)/breadth_first_search_test
RECURSIVE_TEST := $(BUILD_DIR)/recursive_breadth_first_search_test

.PHONY: all build example run test recursive-test clean

all: build

build: $(EXAMPLE)

example: $(EXAMPLE)

$(EXAMPLE): breadth_first_search.cpp breadth_first_search.h breadth_first_search_example.cpp $(TREE_DIR)/tree.cpp $(TREE_DIR)/tree.h
	mkdir -p $(BUILD_DIR)
	$(CXX) $(CXXFLAGS) $(CPPFLAGS) breadth_first_search.cpp breadth_first_search_example.cpp $(TREE_DIR)/tree.cpp -o $(EXAMPLE)

$(TEST): breadth_first_search.cpp breadth_first_search.h breadth_first_search_test.cpp $(TREE_DIR)/tree.cpp $(TREE_DIR)/tree.h
	mkdir -p $(BUILD_DIR)
	$(CXX) $(CXXFLAGS) $(CPPFLAGS) breadth_first_search.cpp breadth_first_search_test.cpp $(TREE_DIR)/tree.cpp -o $(TEST)

$(RECURSIVE_TEST): breadth_first_search.cpp breadth_first_search.h recursive_breadth_first_search_test.cpp $(TREE_DIR)/tree.cpp $(TREE_DIR)/tree.h
	mkdir -p $(BUILD_DIR)
	$(CXX) $(CXXFLAGS) $(CPPFLAGS) breadth_first_search.cpp recursive_breadth_first_search_test.cpp $(TREE_DIR)/tree.cpp -o $(RECURSIVE_TEST)

run: $(EXAMPLE)
	./$(EXAMPLE)

test: $(TEST)
	./$(TEST)

recursive-test: $(RECURSIVE_TEST)
	./$(RECURSIVE_TEST)

clean:
	rm -rf $(BUILD_DIR)
