all:	init

init:
	mvn package
	mkdir data
	wget https://archive.ics.uci.edu/ml/machine-learning-databases/iris/iris.data -P data/

test:
	mvn test

run:
	java -cp target/neuralnet-1.0.jar com.github.akajuvonen.simple_neuralnet_java.NeuralNet

iris:
	java -cp target/neuralnet-1.0.jar com.github.akajuvonen.simple_neuralnet_java.IrisAnalysis

clean:
	mvn clean
	rm -rv data/
