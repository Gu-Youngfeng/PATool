package sklse.yongfeng.jslicer;

import java.util.List;

/***
 * <p><b>Javaslicer</b> is a code slice tool, it can output the dynamic backward slices of certain line or variable in the program. 
 * It's developed by Clemens Hammacher at Saarland University, German. 
 * It can be obtain at <a href="#">https://github.com/hammacher/javaslicer</a>.</p>
 * <p>We need JDK 1.6 or 1.7(BUT NOT 1.8), besides the limitations declared on github site, it can perform well when 
 * dealing with small-scale Java program. The main steps of Javaslicer is as follows,</p>
 * 
 * <p>#STEP 1. Generating the binary trace file.</p>
 * <li><b>java -javaagent:libs/tracer.jar=tracefile:test.trace -cp bin/classes:resources my.package.ClassName</b></li>
 * <li><b>java -javaagent:libs/tracer.jar=tracefile:test.trace -cp bin/classes:resources org.junit.runner.JUnitCore &lt;test class name&gt;</b></li>
 * <p>Note: <b>test.trace</b> is the trace file path, <b>-cp</b> means the dependencies jar of .class files path, which separated by <b>:</b></p>
 * 
 * <p>#STEP 2. Slicing the program based on the trace file.</p>
 * <li><b>java -Xmx2g -jar libs/slicer.jar -p test.trace CLASS.METHOD:LINE</b></li>
 * <p>Note: <b>CLASS.METHOD:LINE</b> denotes the whole method name and line number.</p>
 *
 * @author yongfeng
 *
 */
public class Usage {

	public static void main(String[] args) {
		
		/** slicing on source code*/
//		Jslicer js1 = new Jslicer("sklse.yongfeng.jslicer.Hello","MaximumDivisor",30);
//		showList(js1.getMethodResults("sklse.yongfeng.jslicer.Hello"));
		
		/** slicing on test case*/
//		Jslicer js2 = new Jslicer("sklse.yongfeng.juint.CalculatorTest", "testDivide3", 78);
//		showList(js2.getTestResults("sklse.yongfeng.juint.CalculatorTest"));
		
		CmdRunner crd = new CmdRunner(new String[]{"/bin/bash", "-c", "cd /home/yongfeng/workspace/;ls;touch new.txt"});
		crd.show();
		
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
