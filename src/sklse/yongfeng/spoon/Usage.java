package sklse.yongfeng.spoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import spoon.Launcher;
import spoon.reflect.CtModel;
import spoon.reflect.code.CtCatch;
import spoon.reflect.visitor.filter.TypeFilter;

/***
 * <p><b>Spoon</b> is an open-source library that enables you to transform and analyze Java source code in your own propose. 
 * It's proposed by <b>Pawlak et al.</b>see paper in [SPE 2015],
 * <pre>Spoon:A Library for Implementing Analyses and Transformations of Java Source Code.</pre>
 * Actually, we just only regard the spoon as a static analysis tool and utilize it in the following 2 ways:</p>
 *  <li>By running scripts on cmd (Windows) or terminate (Linux). see {@link#usingCMD()}.</li>
 *  <li>By initializing spoon.Launcher in Java code, see {@link#usingLauncher()}</li>
 *
 */
public class Usage {

	public static void main(String[] args) {
		
//		usingCMD();
		
		usingLauncher();
		
	}
	
	//////////////////////////////////////////////////////////////////////////
	// USING SCRIPTS ON CMD OR TERMINATE 
	public static void usingCMD(){
		/** STEP 1: We first have a AST gui-view of Person.java*/
		/// NOTE: -cp and -i denote the path of spoon and the Person.java, respectively.
		String cmd = "java -cp E:/workspaceee/PATool/libs/spoon-core-6.0.0-jar-with-dependencies.jar "
				+ "spoon.Launcher -i E:/workspaceee/PATool/src/sklse/yongfeng/spoon/Person.java "
				+ "--gui --noclasspath";
		try {
			Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/** STEP 2: We catch each catch-block in Person.java*/
		/// NOTE: -i can be a file or a folder
		String cmd2 = "java -cp E:/workspaceee/PATool/bin;E:/workspaceee/PATool/libs/junit-4.12.jar;"
				+ "E:/workspaceee/PATool/libs/hamcrest-all-1.3.jar;E:/workspaceee/PATool/libs/spoon-core-6.0.0-jar-with-dependencies.jar "
				+ "spoon.Launcher -i E:/workspaceee/PATool/src/sklse/yongfeng/spoon/Person.java "
				+ "-p sklse.yongfeng.spoon.CatchProcessor";
		
		try {
			Process process = Runtime.getRuntime().exec(cmd2);
			InputStreamReader rd = new InputStreamReader(process.getInputStream());
			BufferedReader bf = new BufferedReader(rd);
			String str = "";
			while(bf.readLine()!=null){
				str = bf.readLine();
				System.out.println(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//////////////////////////////////////////////////////////////////////////
	//INITIALIZING spoon.Launcher
	public static void usingLauncher(){

		/**STEP 1: initialize a spoon launcher*/
		Launcher launcher = new Launcher();
		launcher.addInputResource("E:/workspaceee/PATool/src/sklse/yongfeng/spoon/Person.java");
		
		/**STEP 2: create AST model*/
		launcher.buildModel();
		CtModel ASTModel = launcher.getModel();
		
		/**STEP 3: access the program elements*/
		List<CtCatch> lsCatchs = ASTModel.getElements(new TypeFilter(CtCatch.class));
		for(CtCatch catchs: lsCatchs){
			if(catchs.getBody().getStatements().size() == 0){
				System.out.println("EMPTY CATCH!");
				System.out.println("meta model  : " + catchs.getClass().toString());
				System.out.println("parent model: " + catchs.getParent().getClass().toString());
			}
		}
	}
	

}
