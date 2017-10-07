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
	
	Jslicer(String cla, String met, int lin){
		this.className = cla;
		this.methodName = met;
		this.LINE = lin;
		this.libraryName = null;
	}
	
	Jslicer(String cla, String met, int lin, String lib){
		this.className = cla;
		this.methodName = met;
		this.LINE = lin;
		this.libraryName = lib;
	}
	
	
	public List<String> getMethodResults(String filter){
		
		String strCMD1;
		if(this.libraryName == null){
			strCMD1 = "java -javaagent:libs/tracer.jar=tracefile:hello.trace -cp bin " + this.className;
		}else{
			strCMD1 = "java -javaagent:libs/tracer.jar=tracefile:hello.trace -cp bin:" + this.libraryName + " " + this.className;
		}
		
		String strCMD2 = "java -Xmx2g -jar libs/slicer.jar -p hello.trace " + this.className + "." + this.methodName + ":" + this.LINE + ":*";
		
		/**STEP 1. generating trace*/
		CmdRunner cmd1 = new CmdRunner(strCMD1);
		
		/**STEP 2. slicing program*/
		CmdRunner cmd2 = new CmdRunner(strCMD2);

		return cmd2.getResults("Hello");
	}

}
