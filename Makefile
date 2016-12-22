all:	init

init:
	mvn package
	mkdir data
	wget https://archive.ics.uci.edu/ml/machine-learning-databases/iris/iris.data -P data/

iris:
	java -cp target/neuralnet-1.0.jar com.github.akajuvonen.simple_neuralnet_java.IrisAnalysis

clean:
	rm -rv data/
