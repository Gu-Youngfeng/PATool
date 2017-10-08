package sklse.yongfeng.juint;

import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.hamcrest.CoreMatchers.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING) // Setting execution order
public class CalculatorTest {
	
//	@Rule
//	public Timeout globalTimeout = Timeout.seconds(3000);

	@Before
	public void setUp(){
		// Here do some configuration before testing.

	}
	
	@Test
	public void testAdd1(){
		Calculator ca = new Calculator(1, 1);
		Assert.assertEquals(2, ca.Add());	
		Assert.assertThat(ca.Add(), is(2));
	}
	
	@Test(timeout = 2000)
//	@Test
	public void testAdd2(){		
		Calculator ca1 = new Calculator(1, 2);
		Assert.assertEquals(3, ca1.Add());
		for(int i=0;;i++){
			// here is the infinite for-loop
		}
//		Assert.assertThat(ca1.Add(), );
	}
	
	@Test
	public void testAdd3(){	
		Calculator ca2 = new Calculator(3, 2);
		Assert.assertEquals(5, ca2.Add());
	}
	
	@Test
	public void testMinus1(){
		Calculator ca = new Calculator(1, 1);
		Assert.assertEquals(0, ca.Minus());
	}
	
	@Test
	public void testMinus2(){	
		Calculator ca1 = new Calculator(1, 2);
		Assert.assertEquals(-1, ca1.Minus());
	}
	
	@Test
	public void testMinus3(){
		Calculator ca2 = new Calculator(3, 2);
		Assert.assertEquals(1, ca2.Minus());
	}
	
	@Test
	public void testDivide1(){
		Calculator ca2 = new Calculator(2, 2);
		Assert.assertEquals(1, ca2.Divide());
	}
	
	@Test
	public void testDivide2(){
		Calculator ca2 = new Calculator(2, 4);
		Assert.assertEquals(0, ca2.Divide());
	}
	
	@Test
	public void testDivide3(){
		Calculator ca2 = new Calculator(3, 2);
		Assert.assertEquals(1.5, ca2.Divide(), 0.1);
	}
	
	@Test
	public void testDivide4(){
		Calculator ca2 = new Calculator(0, 2);
		Assert.assertEquals(0, ca2.Divide());
	}
	
	@Test(expected = ArithmeticException.class) //This test case will pass even if Line 77 will throw Exception
	public void testDivide5(){
		Calculator ca2 = new Calculator(1, 0);
		Assert.assertEquals(0, ca2.Divide()); // It will throw ArithmeticException here
	}
	
	@After
	public void tearDown(){
		
	}

}
