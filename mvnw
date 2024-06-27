#!/bin/sh
MAVEN_VER="3.8.6"
if [ ! -d ".mvn" ]; then
  mkdir -p .mvn/wrapper
  curl -o .mvn/wrapper/maven-wrapper.jar https://repo1.maven.org/maven2/io/takari/maven-wrapper/0.5.6/maven-wrapper-0.5.6.jar
  echo "distributionUrl=https://repo1.maven.org/maven2/org/apache/maven/apache-maven/${MAVEN_VER}/apache-maven-${MAVEN_VER}-bin.zip" > .mvn/wrapper/maven-wrapper.properties
fi
java -jar .mvn/wrapper/maven-wrapper.jar "$@"
