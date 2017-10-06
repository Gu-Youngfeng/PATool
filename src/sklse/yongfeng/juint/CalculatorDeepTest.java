package sklse.yongfeng.juint;

import org.junit.*;

public class CalculatorDeepTest {
	
	@Test
	public void testMax1(){
		Calculator ca = new Calculator(1, 1);
		Assert.assertEquals(2, ca.Max());		
	}
	
	@Test
	public void testMax2(){
		Calculator ca = new Calculator(1, 3);
		Assert.assertEquals(3, ca.Max());		
	}
	
	@Test
	public void testMax3(){
		Calculator ca = new Calculator(2, 1);
		Assert.assertEquals(2, ca.Max());		
	}

}
