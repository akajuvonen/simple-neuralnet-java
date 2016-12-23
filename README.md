#simple-neuralnet-java
A simple MLP neural network using Java. Now uses Maven build system (which means it has to be installed).

## Instructions using Makefile

There is a makefile to simplify usage. `make` or `make init` creates the package and downloads Iris dataset to it's own subfolder. `make run` runs the network with a simple binary test data. `make iris` runs the Iris flower data test (TODO). `make clean` cleans up the project packages and data files.

If you want to run the tests separately, you can do it with `make test` (they are already run with in init).
