## PATool
This project will give some examples of usage of some Program Analysis Tools, which are briefly introduced as follows,

### 1. JUnit 4

 ![junit](imgs/junit.png)

JUnit is the most widely used <code>Java testing framework</code>, it provide the differeny strategies of testing. Here we focus on the JUnit 4 version.

Note: 

a. The latest junit-4.12.jar should be used combining with hamcrest-all-1.3.jar, so please add them all to the classpath of the project. 

b. We can simply use some specific notations to guide the execution of test suite, for example, we use <b>@test</b> to declare a test case, we use <b>@RunWith</b> to add test cases to one suite, we use <b>@FixMethodOrder</b> to set the execution order of test cases.

Website: <a href="http://junit.org/junit4/">http://junit.org/junit4/</a>.

### 2. Javaslicer
Javaslicer is a <code>dynamic backward slicing tool</code> for Java code, it can give the slices(relavent statements) of specific lines or variables. Note that Javaslicer only support JDK 1.6 and 1.7(but NOT JDK1.8). Additionally, we'd better use this tool on Linux platform.

Note: 

a. The limitation of Javaslicer is its ability of dealing with large-scale progjects, because even a small Java class can generate a big trace file. So it might throw a exception of "too large".

b. Two step to use Javaslicer: <b>(i)</b> generate the trace file, <b>(ii)</b> read the trace file and slice the program.

Website: <a href="https://github.com/hammacher/javaslicer">https://github.com/hammacher/javaslicer</a>.

### 3. Spoon

![spoon](imgs/spoon.jpg)

Spoon is an open-source Java <code>analysis and transform tool</code>, which is widely used in program analysis, feature extraction, program mutation etc.

Website: <a href="http://spoon.gforge.inria.fr/">http://spoon.gforge.inria.fr/</a>.
