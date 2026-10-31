CXX ?= g++
CXXFLAGS ?= -std=c++20 -O2 -Wall -Wextra -Wshadow -pedantic
BUILD_DIR := build
TEST := $(BUILD_DIR)/matrix_test

.PHONY: all build test clean

all: build

build: $(TEST)

$(TEST): matrix.cpp matrix.h matrix_test.cpp
	mkdir -p $(BUILD_DIR)
	$(CXX) $(CXXFLAGS) matrix.cpp matrix_test.cpp -o $(TEST)

test: $(TEST)
	./$(TEST)

clean:
	rm -rf $(BUILD_DIR)
