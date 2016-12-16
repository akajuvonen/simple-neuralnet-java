init:
	mkdir data
	wget https://archive.ics.uci.edu/ml/machine-learning-databases/iris/iris.data -P data/

clean:
	rm -rv data/iris.data
