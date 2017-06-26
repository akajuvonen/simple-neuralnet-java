#simple-neuralnet-java
A simple MLP neural network using Java. Now uses Maven build system (which means it has to be installed).

## Initialization

There is a makefile to simplify usage. `make` or `make init` creates the package using Maven and downloads Iris dataset to it's own subfolder.

## Running the network

Executing `make run` runs the network with a simple binary test data (found in the main function).

## Iris flower data test

`make iris` runs the Iris flower data test. It then prints the actual and expected classification results. `make clean` cleans up the project packages and data files.

## Testing

If you want to run the tests separately, you can do it with `make test` (they are already run with in init). NOTE: If Iris data tests fail, run tests again. There is a small random element to the network initialization, which causes the iris test to fail sometimes.

## Notes

The main function in neural net class shows an example on how to use the network. The Iris data test uses the well-known Iris flower data set to test the net on practical data. For now it uses 100 observations for training and the rest (50) for testing. If the accuracy is good enough, the test is passed.
