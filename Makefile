CXX := g++
CXXFLAGS := -std=c++20 -O2 -Wall -Wextra -Wshadow -pedantic
SOURCE := main.cpp
TARGET := solution

.PHONY: all build run clean

all: build

build: $(SOURCE)
	$(CXX) $(CXXFLAGS) $(SOURCE) -o $(TARGET)

run: build
	./$(TARGET) $(ARGS)

clean:
	rm -f $(TARGET)
