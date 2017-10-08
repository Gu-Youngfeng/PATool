package sklse.yongfeng.jslicer;

import java.util.List;

/***
 * <p><b>Javaslicer</b> is a code slice tool, it can output the dynamic backward slices of certain line or variable in the program. 
 * It's developed by Clemens Hammacher at Saarland University, German. 
 * It can be obtain at <a href="#">https://github.com/hammacher/javaslicer</a>.</p>
 * <p>We need JDK 1.6 or 1.7(BUT NOT 1.8), besides the limitations declared on github site, it can perform well when 
 * dealing with small-scale Java program. The main steps of Javaslicer is as follows,</p>
 * 
 * <h3>#STEP 1. Generating the binary trace file.</h3>
 * <li>java -javaagent:libs/tracer.jar=tracefile:test.trace -cp bin/classes:resources my.package.ClassName</li>
 * <li>java -javaagent:libs/tracer.jar=tracefile:test.trace -cp bin/classes:resources org.junit.runner.JUnitCore &lt;test class name&gt;</li>
 * <p>Note: <b>test.trace</b> is the trace file path, <b>-cp</b> means the dependencies jar of .class files path, which separated by <b>:</b></p>
 * 
 * <h3>#STEP 2. Slicing the program based on the trace file.</h3>
 * <li>java -Xmx2g -jar libs/slicer.jar -p test.trace CLASS.METHOD:LINE</li>
 * <p>Note: <b>CLASS.METHOD:LINE</b> denotes the whole method name and line number.</p>
 * 
 * <h3>#Output. The output of Javaslicer is the Java byte code instructions(NOT Java code). You can do any additional operations on the results.</h3>
 * <pre>sklse.yongfeng.juint.CalculatorTest.testDivide3:76 NEW sklse/yongfeng/juint/Calculator
 *sklse.yongfeng.juint.CalculatorTest.testDivide3:76 DUP
 *sklse.yongfeng.juint.CalculatorTest.testDivide3:76 ICONST_3
 *sklse.yongfeng.juint.CalculatorTest.testDivide3:76 ICONST_2
 *sklse.yongfeng.juint.CalculatorTest.testDivide3:76 INVOKESPECIAL sklse/yongfeng/juint/Calculator.<init>(II)V
 *sklse.yongfeng.juint.CalculatorTest.testDivide3:76 ASTORE 1
 *sklse.yongfeng.juint.CalculatorTest.testDivide3:77 LDC 1.5
 *sklse.yongfeng.juint.CalculatorTest.testDivide3:77 ALOAD 1
 *sklse.yongfeng.juint.CalculatorTest.testDivide3:77 INVOKEVIRTUAL sklse/yongfeng/juint/Calculator.Divide()I
 *sklse.yongfeng.juint.CalculatorTest.testDivide3:77 I2D
 *sklse.yongfeng.juint.CalculatorTest.testDivide3:77 LDC 0.1
 *sklse.yongfeng.juint.CalculatorTest.testDivide3:77 INVOKESTATIC org/junit/Assert.assertEquals(DDD)V</pre>
 *
 * @author yongfeng
 *
 */
public class Usage {

	public static void main(String[] args) {
		
		/** slicing on source code*/
//		Jslicer js1 = new Jslicer("/home/yongfeng/workspace/PATools4J/", "sklse.yongfeng.jslicer.Hello","MaximumDivisor",30);
//		showList(js1.getMethodResults("sklse.yongfeng.jslicer.Hello"));
		
		/** slicing on test case*/
		Jslicer js2 = new Jslicer("/home/yongfeng/workspace/PATools4J/", "sklse.yongfeng.juint.CalculatorTest", "testDivide3", 77);
		showList(js2.getTestResults("sklse.yongfeng.juint.CalculatorTest"));
		
	}
	
	/***
	 * To show array list line by line
	 * @param ls list
	 */
	public static void showList(List<?> ls){
		for(Object ols:ls){
			System.out.println(ols.toString());
		}
	}

}
