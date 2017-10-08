package sklse.yongfeng.jslicer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/***
 * <p>This class <b>CmdRunner</b> is used to simulate the execution in terminate.</p>
 * <p>We provide {@link#CmdRunner(String)} to initialize the cmd, and use {@link#show()} or {@link#show(String)} to display the results. 
 * Beside, {@link#getResults()} or {@link#getResults(String)} is used to collect the output lines.</p>
 * <p>Note
 * <li>The parameter of constructor is a string array, if you want to execute one more commands, you'd better use ; to separate them.</li>
 * <pre>CmdRunner(new String[]{"java -version;javac -version"});</pre>
 * <li>If you want to use 'cd' command in CmdRunner, we must initialize the string array in this way 
 * <pre>CmdRunner(new String[]{"/bin/bash", "-c", "cd XXX"});</pre></li>
 * </p>
 * @author yongfeng
 *
 */
public class CmdRunner {
	
	private String[] cmd;
	
	private List<String> output = new ArrayList<String>();
	
	public CmdRunner(String[] cmd){
		this.cmd = cmd;
		runCMD();
	}
	
	private void runCMD(){
		Process proc = null;
		BufferedReader br = null;
		String outputStr = "";
		
		try {
			proc = Runtime.getRuntime().exec(cmd);
		} catch (Exception e) {
			System.out.println("Process generated error! <" + this.cmd + ">");
			e.printStackTrace();
		}
		
		br = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		try {
			while((outputStr=br.readLine())!=null){
				this.output.add(outputStr);
			}
		} catch (Exception e) {
			System.out.println("Reading output error! <" + this.cmd + ">");
			e.printStackTrace();
		}
		
		br = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
		try {
			while((outputStr=br.readLine())!=null){
				this.output.add(outputStr);
			}
		} catch (Exception e) {
			System.out.println("Reading output error! <" + this.cmd + ">");
			e.printStackTrace();
		}
	}
	
	public void show(){
		System.out.println("command name: <" + this.cmd + ">");
		for(String strline: this.output){
			System.out.println(strline);
		}
	}
	
	public void show(String filter){
		System.out.println("command name: <" + this.cmd + ">");
		for(String strline: this.output){
			if(strline.contains(filter)){
				System.out.println(strline);
			}
		}
	}
	
	/**
	 * To get all output on the terminal
	 * @return
	 */
	public List<String> getResults(){
		return this.output;
	}
	
	/**
	 * To get output ,which starts with <b>filter</b>, on the terminal
	 * @param filter
	 * @return
	 */
	public List<String> getResults(String filter){
		List<String> foutput = new ArrayList<>();
		for(String line: this.output){
			if(line.startsWith(filter)){
				foutput.add(line);
			}
		}
		return foutput;
		
	}

}
