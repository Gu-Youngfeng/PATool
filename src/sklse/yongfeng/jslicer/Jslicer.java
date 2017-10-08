package sklse.yongfeng.jslicer;

import java.util.List;

/***
 * <p>This class <b>Jslicer</b> implement the function of JavaSlicer, which input are class name, method name, and line number. 
 * and the output is the slices list array. Here is one example, </p>
 * <pre>
 * Jslicer js = new Jslicer(Cla, Met, lin);  //input 3 arguments
 * js.getMethodResults(Cla);  //return the slices.</pre>
 * @author yongfeng
 *
 */
public class Jslicer {
	
	private String className;
	private String methodName;
	private int LINE;
	private String libraryName;
	
	/***
	 * To construct the constructor with 3 parameters.
	 * @param cla class name
	 * @param met method name
	 * @param lin line number
	 */
	Jslicer(String cla, String met, int lin){
		this.className = cla;
		this.methodName = met;
		this.LINE = lin;
		this.libraryName = null;
	}
	
	/***
	 * To construct the constructor with 4 parameters.
	 * @param cla class name
	 * @param met method name
	 * @param lin line number
	 * @param lib dependencies jar and .class file path
	 */
	Jslicer(String cla, String met, int lin, String lib){
		this.className = cla;
		this.methodName = met;
		this.LINE = lin;
		this.libraryName = lib;
	}
	
	/***
	 * To get slices from source code.
	 * @param filter the string the slices must contain
	 * @return
	 */
	public List<String> getMethodResults(String filter){
		
		String strCMD1;
		
		if(this.libraryName == null){
			strCMD1 = "java -javaagent:libs/tracer.jar=tracefile:hello.trace -cp bin " + this.className;
		}else{
			strCMD1 = "java -javaagent:libs/tracer.jar=tracefile:hello.trace -cp bin:" + this.libraryName + " " + this.className;
		}
		
		String strCMD2 = "java -Xmx2g -jar libs/slicer.jar -p hello.trace " + this.className + "." + this.methodName + ":" + this.LINE + ":*";
		
		/**STEP 1. generating trace*/
		CmdRunner cmd1 = new CmdRunner(new String[]{strCMD1});
		
		/**STEP 2. slicing program*/
		CmdRunner cmd2 = new CmdRunner(new String[]{strCMD2});

		return cmd2.getResults(filter);
	}
	
	/***
	 * To get slices from test case.
	 * @param filter the string the slices must contain
	 * @return
	 */
	public List<String> getTestResults(String filter){
		
		String strCMD1;
		
		if(this.libraryName == null){
			strCMD1 = "java -javaagent:libs/tracer.jar=tracefile:hello.trace -cp bin:libs/hamcrest-all-1.3.jar:libs/junit-4.12.jar org.junit.runner.JUnitCore " + this.className;
		}else{
			strCMD1 = "java -javaagent:libs/tracer.jar=tracefile:hello.trace -cp bin:libs/hamcrest-all-1.3.jar:libs/junit-4.12.jar:" + this.libraryName + " org.junit.runner.JUnitCore " + this.className;
		}
		
		String strCMD2 = "java -Xmx2g -jar libs/slicer.jar -p hello.trace " + this.className + "." + this.methodName + ":" + this.LINE + ":*";
		
		/**STEP 1. generating trace*/
		CmdRunner cmd1 = new CmdRunner(new String[]{strCMD1});
		
		/**STEP 2. slicing program*/
		CmdRunner cmd2 = new CmdRunner(new String[]{strCMD2});
		
		return cmd2.getResults(filter);
		
	}

}
