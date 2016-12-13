#!/bin/bash

echo "Download IRIS dataset" 
wget https://archive.ics.uci.edu/ml/machine-learning-databases/iris/iris.data

echo "Cleanup"
rm -v iris.data
