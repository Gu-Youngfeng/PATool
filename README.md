## PATool
This project will give some examples of usage of some Program Analysis Tools, which are briefly introduced as follows,

### 1. JUnit 4
JUnit is the most widely used <code>Java testing framework</code>, it provide the differeny strategies of testing. Here we focus on the JUnit 4 version.

Note: the lasetest junit-4.12.jar should be used combining with hamcrest-all-1.3.jar, so please add them all to the classpath. 

Website: <a href="http://junit.org/junit4/">http://junit.org/junit4/</a>.

### 2. Javaslicer
Javaslicer is a <code>dynamic backward slicing tool</code> for Java code, it can give the slices(relavent statements) of specific lines or variables. Note that Javaslicer only support JDK 1.6 and 1.7(but NOT JDK1.8). Additionally, we'd better use this tool on Linux platform.

Note: the limitation of Javaslicer is its ability of dealing with large-scale progjects, because even a small Java class can generate a big trace file. So it might throw a exception of "too large".

Website: <a href="https://github.com/hammacher/javaslicer">https://github.com/hammacher/javaslicer</a>.

### 3. Spoon
Spoon is an open-source Java analysis and transform tool, which is widely used in program analysis, feature extraction, program mutation etc.

Website: <a href="http://spoon.gforge.inria.fr/">http://spoon.gforge.inria.fr/</a>.
