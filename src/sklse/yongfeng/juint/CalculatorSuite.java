package sklse.yongfeng.juint;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/***
 * <p><b>JUnit</b> is a simple framework to write repeatable tests. Its official web site is <b>http://junit.org</b>, 
 * and you can also find user guidance on <b>https://github.com/junit-team/junit4/wiki/Getting-started</b>, and download the latest 
 * library from <b>http://mvnrepository.com/artifact/junit/junit</b>.</p>
 * <p>To start the study of JUnit4 is quite easy, you should only add the junit-X.jar to your classpath and set some notations 
 * <p>1. <b>Assertions</b> is the core conception in JUnit, it can test the functionality of source by comparing the expected 
 * value and actual vale. JUnit provide many overloaded assertion methods for primitive types and objects and arrays, 
 * we can easily use it in this form,</p>
 * <pre>Assert.assertEquals(expected, actual);</pre>
 * 
 * <p>2. <b>TestRunner</b> is another core conception in JUnit, it can rule the specific test suite and then run and display 
 * the test results. When a class is annotated with @RunWith or extends a class anotated with @RunWith, JUnit will invoke the classes
 * it references to run the test.</p>
 * <pre>@Runwith(Suite.class)</pre> 
 * <pre>@SuiteClasses({ATest.class, BTest.class, CTest.class})</pre>
 * 
 * <p>3. <b>Execution Order</b> give a specific execution order of test cases, Before <b>JUnit 4.11</b>, Junit invoke each test case in
 *  more or less random order. So when we add annotation @FixMethodOrder before any test class, we can define the order as we like,</p>
 * <pre>@FixMethodOrder(MethodSorters.JVM) // the order vary from run to run</pre>
 * <pre>@FixMethodOrder(MethodSorters.NAME_ASENDING) // the order is depend by test case name</pre>
 * 
 * <p>4. <b>Expected Exceptions</b> can verify the behaviors of the test case, i.e., we can predict the exception the test case will throw. 
 * eg. we expect the test case would throw the IndexOutOfBoundsException, we can add annotation like this,</p>
 * <pre>@Test(expected = IndexOutOfBoundsException.class) 
 * // Note that if the test case throw this Exception, it will pass in testing.</pre>
 * 
 * <p>5. <b>AssertThat</b> is a new assertion mechanism, the function name is <i>assertThat()</i>, it has the so-called 
 * readability in code and results, the example is here, </p>
 * <pre>Assert.assertThat([value], [matcher statement]);
 * // Note that we should import org.hamcrest.CoreMatchers.* first.
 * </pre>
 * 
 * <p>6. <b>Timeout</b> rules the execution time of each test case, we can set time <b>t</b> for one specific test case or each test case. 
 * And if the execution time of the test over <b>t</b>, it will throw TestTimeOutException.</p>
 * <pre>@test(timeout = 2000) // for one test</pre>
 * <pre>@Rule
 *public Timeout to = Timeout.seconds(10); // for each test
 * </pre>
 */
@RunWith(Suite.class)
@SuiteClasses({CalculatorTest.class, CalculatorDeepTest.class})
public class CalculatorSuite {


}
