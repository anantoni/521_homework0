CC     		:= g++
CFLAGS  	:= -O2 -g -Wall -Wextra -std=c++98 -pedantic
EXECUTABLE  := exe
SOURCES 	:= main.cpp

default: $(EXECUTABLE)

$(EXECUTABLE): main.o
	$(CC) $(CFLAGS) -o exe main.o

main.o: main.cpp
	$(CC) $(CFLAGS) -c main.cpp

.PHONY: clean 
clean:
	rm main.o

.PHONY: dist-clean
dist-clean:
	rm main.o $(EXECUTABLE)

.PHONY: check-syntax
	$(CC) $(CFLAGS) -fsyntax-only $(SOURCES)
