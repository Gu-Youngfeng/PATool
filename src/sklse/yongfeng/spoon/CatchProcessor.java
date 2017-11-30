package sklse.yongfeng.spoon;

import org.junit.runner.manipulation.Filter;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtCatch;

/***
 * <p><b>CatchProcessor</b> is a simple example of spoon analyzer, 
 * which implements the function {@link #process()} interface <b>AbstractProcessor</b>. 
 * It can process each empty catch block in source code. 
 * If you want to analyze the program by other granularity, try to change the generic <b>CtCatch</b> to <b>CtXXX</b>.</p>
 */
public class CatchProcessor extends AbstractProcessor<CtCatch> {
	
	public static int count;	
	
	@Override
	/***
	 * <p>This method is up-called to initialize the processor before each processing round.</p>
	 */
	public void init(){
		super.init();
//		count = 0;
		System.out.println("init...");
	}

	@Override
	/***
	 * <p>Processing the program element (in this example we use CtCatch).</p>
	 */
	public void process(CtCatch elem) {
		System.out.println("processing...");
		if(elem.getBody().getStatements().size() == 0){
			count++;
			System.out.println("meta model  : " + elem.getClass().toString());
			System.out.println("parent model: " + elem.getParent().getClass().toString());
//			System.out.println("No Empty!");
			System.out.println("empty catch count: " + count);
		}		
	}
	
	@Override
	/***
	 * <p>This method is upcalled by the ProcessingManager when this
	 *  processor has finished a full processing round on the program's model</p>
	 */
	public void processingDone(){
		System.out.println("done...");
		System.out.println("----\ntotal empty catch: " + count);
	}

}
