all: build

build: 
	javac NeuralNet.java

run:
	java NeuralNet

clean:
	rm *.class
