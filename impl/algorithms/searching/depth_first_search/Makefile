CXX ?= g++
CXXFLAGS ?= -std=c++20 -O2 -Wall -Wextra -Wshadow -pedantic
BUILD_DIR := build
EXAMPLE := $(BUILD_DIR)/example
TEST := $(BUILD_DIR)/depth_first_search_test

.PHONY: all build example run test clean

all: build

build: $(EXAMPLE)

example: $(EXAMPLE)

$(EXAMPLE): depth_first_search.cpp depth_first_search.h depth_first_search_example.cpp
	mkdir -p $(BUILD_DIR)
	$(CXX) $(CXXFLAGS) depth_first_search.cpp depth_first_search_example.cpp -o $(EXAMPLE)

$(TEST): depth_first_search.cpp depth_first_search.h depth_first_search_test.cpp
	mkdir -p $(BUILD_DIR)
	$(CXX) $(CXXFLAGS) depth_first_search.cpp depth_first_search_test.cpp -o $(TEST)

run: $(EXAMPLE)
	./$(EXAMPLE)

test: $(TEST)
	./$(TEST)

clean:
	rm -rf $(BUILD_DIR)
