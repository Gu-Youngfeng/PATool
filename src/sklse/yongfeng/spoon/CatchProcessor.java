package sklse.yongfeng.spoon;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtCatch;

public class CatchProcessor extends AbstractProcessor<CtCatch> {

	@Override
	public void process(CtCatch elem) {
		if(elem.getBody().getStatements().size() == 0){
			System.out.println(elem.toString());
			System.out.println("No Empty!");
		}
		
	}

}
