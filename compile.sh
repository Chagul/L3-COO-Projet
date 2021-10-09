#!/bin/bash

find . -name "*.java" > listOfJava.txt
javac -d bin/ -cp lib/Junit-console.jar @listOfJava.txt
rm listOfJava.txt
