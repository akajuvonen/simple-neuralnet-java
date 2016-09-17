all: build

build: 
	javac src/NeuralNet.java

run:
	java -cp src/ NeuralNet

clean:
	rm -v src/*.class
	rm -v test/*.class
