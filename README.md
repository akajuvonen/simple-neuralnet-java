#simple-neuralnet-java
A simple neural network using Java. Now uses Maven build system (which means it has to be installed).

##Compiling & packaging
You can check that the compile process works by typing `mvn compile`.
If you want to create a jar package for running the network, you can execute `mvn package`.

##Running
After packaging, there should be a runnable jar in the folder `target/`.
The network can be run using `java -cp target/neuralnet-VERSION.jar com.github.akajuvonen.simple_neuralnet_java.NeuralNet`
 (run this from the main folder).

##Tests
The package command already runs tests, but you can run unit tests separately with `mvn test`.

##Cleaning
`mvn clean` cleans up the target folder.
