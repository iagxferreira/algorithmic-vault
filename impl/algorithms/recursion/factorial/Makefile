CXX ?= g++
CXXFLAGS ?= -std=c++20 -O2 -Wall -Wextra -Wshadow -pedantic
BUILD_DIR := build
EXAMPLE := $(BUILD_DIR)/example
TEST := $(BUILD_DIR)/factorial_test

.PHONY: all build example run test clean

all: build

build: $(EXAMPLE)

example: $(EXAMPLE)

$(EXAMPLE): factorial.cpp factorial.h factorial_example.cpp
	mkdir -p $(BUILD_DIR)
	$(CXX) $(CXXFLAGS) factorial.cpp factorial_example.cpp -o $(EXAMPLE)

$(TEST): factorial.cpp factorial.h factorial_test.cpp
	mkdir -p $(BUILD_DIR)
	$(CXX) $(CXXFLAGS) factorial.cpp factorial_test.cpp -o $(TEST)

run: $(EXAMPLE)
	./$(EXAMPLE)

test: $(TEST)
	./$(TEST)

clean:
	rm -rf $(BUILD_DIR)
