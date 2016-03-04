#!/usr/bin/env bash
echo

rm -rf bin
mkdir bin
javac -d bin ./src/*.java
java -cp bin MusicStoreApp
echo
