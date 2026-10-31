CXX ?= g++
CXXFLAGS ?= -std=c++20 -O2 -Wall -Wextra -Wshadow -pedantic
BUILD_DIR := build
TARGET := $(BUILD_DIR)/main

.PHONY: all build run clean

all: build

build: $(TARGET)

$(TARGET): main.cpp
	mkdir -p $(BUILD_DIR)
	$(CXX) $(CXXFLAGS) main.cpp -o $(TARGET)

run: $(TARGET)
	./$(TARGET) $(ARGS)

clean:
	rm -rf $(BUILD_DIR)
