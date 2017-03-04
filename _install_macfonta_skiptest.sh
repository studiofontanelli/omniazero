#!/bin/sh

#########################################
###### ambiente JDK 1.8+ JBOSS-EAP 6.4.0
#########################################


export JBOSS_HOME=/opt/java/jboss-eap-6.4.0
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_71.jdk/Contents/Home/


java -version

mvn -Dmaven.test.skip=true -Pmacfonta clean compile package install












