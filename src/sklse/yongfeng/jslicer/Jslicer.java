package sklse.yongfeng.jslicer;

import java.util.List;

/***
 * <p>This class <b>Jslicer</b> implement the function of JavaSlicer, which input are class name, method name, and line number. 
 * and the output is the slices list array. Here is one example, </p>
 * <pre>
 * Jslicer js = new Jslicer(Pat, Cla, Met, Lin);  //input 4 arguments
 * js.getMethodResults(Cla);  //return the slices of method.
 * js.getTestResults(Cla);  //return the slices of test case.</pre>
 * <p>Note that the 4 parameters must be correct, more specifically,
 * <br><b>Pat</b> denotes the absolute path of project you want to slice.
 * <br><b>Cla</b> denotes the full class name with corresponding package.
 * <br><b>Met</b> denotes the method name.
 * <br><b>Lin</b> denotes the line number.</p>
 * @author yongfeng
 *
 */
public class Jslicer {
	
	private String rootpath;
	private String className;
	private String methodName;
	private int LINE;
	private String libraryName;
	
	/***
	 * To construct the constructor with 4 parameters.
	 * @param path project path
	 * @param cla class name
	 * @param met method name
	 * @param lin line number
	 */
	Jslicer(String path, String cla, String met, int lin){
		this.rootpath = path;
		this.className = cla;
		this.methodName = met;
		this.LINE = lin;
		this.libraryName = null;
	}
	
	/***
	 * To construct the constructor with 5 parameters.
	 * @param path project path
	 * @param cla class name
	 * @param met method name
	 * @param lin line number
	 * @param lib dependencies jar and .class file path
	 */
	Jslicer(String path, String cla, String met, int lin, String lib){
		this.rootpath = path;
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
			strCMD1 = "java -javaagent:libs/tracer.jar=tracefile:temp.trace -cp bin " + this.className;
		}else{
			strCMD1 = "java -javaagent:libs/tracer.jar=tracefile:temp.trace -cp bin:" + this.libraryName + " " + this.className;
		}
		
		String strCMD2 = "java -Xmx2g -jar libs/slicer.jar -p temp.trace " + this.className + "." + this.methodName + ":" + this.LINE + ":*";
		
		/**STEP 1. generating trace*/
//		CmdRunner cmd1 = new CmdRunner(new String[]{strCMD1});
		
		/**STEP 2. slicing program*/
//		CmdRunner cmd2 = new CmdRunner(new String[]{strCMD2});
		
		/**Execute 2 steps together with cd command*/
		CmdRunner cmd0 = new CmdRunner(new String[]{"/bin/bash", "-c", "cd " + this.rootpath + ";" + strCMD1 + ";" + strCMD2});
		
		return cmd0.getResults(filter);
	}
	
	/***
	 * To get slices from test case.
	 * @param filter the string the slices must contain
	 * @return
	 */
	public List<String> getTestResults(String filter){
		
		String strCMD1;
		
		if(this.libraryName == null){
			strCMD1 = "java -javaagent:libs/tracer.jar=tracefile:temp.trace -cp bin:libs/hamcrest-all-1.3.jar:libs/junit-4.12.jar org.junit.runner.JUnitCore " + this.className;
		}else{
			strCMD1 = "java -javaagent:libs/tracer.jar=tracefile:temp.trace -cp bin:libs/hamcrest-all-1.3.jar:libs/junit-4.12.jar:" + this.libraryName + " org.junit.runner.JUnitCore " + this.className;
		}
		
		String strCMD2 = "java -Xmx2g -jar libs/slicer.jar -p temp.trace " + this.className + "." + this.methodName + ":" + this.LINE + ":*";
		
		/**STEP 1. generating trace*/
//		CmdRunner cmd1 = new CmdRunner(strCMD1);
//		
		/**STEP 2. slicing program*/
//		CmdRunner cmd2 = new CmdRunner(strCMD2);
		
		/**Execute 2 steps together with cd command*/
		CmdRunner cmd0 = new CmdRunner(new String[]{"/bin/bash", "-c", "cd " + this.rootpath + ";" + strCMD1 + ";" + strCMD2});
		
		return cmd0.getResults(filter);
		
	}

}
