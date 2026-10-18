CXX ?= g++
CXXFLAGS ?= -std=c++20 -O2 -Wall -Wextra -Wshadow -pedantic
BUILD_DIR := build
EXAMPLE := $(BUILD_DIR)/example
TEST := $(BUILD_DIR)/linear_search_test

.PHONY: all build example run test clean

all: build

build: $(EXAMPLE)

example: $(EXAMPLE)

$(EXAMPLE): linear_search.cpp linear_search.h example.cpp
	mkdir -p $(BUILD_DIR)
	$(CXX) $(CXXFLAGS) linear_search.cpp example.cpp -o $(EXAMPLE)

$(TEST): linear_search.cpp linear_search.h linear_search_test.cpp
	mkdir -p $(BUILD_DIR)
	$(CXX) $(CXXFLAGS) linear_search.cpp linear_search_test.cpp -o $(TEST)

run: $(EXAMPLE)
	./$(EXAMPLE)

test: $(TEST)
	./$(TEST)

clean:
	rm -rf $(BUILD_DIR)
