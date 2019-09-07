package googlesearch_page;

import org.junit.Ignore;
import org.testng.annotations.Test;
/***
 * 
 * @author poorna.komarasetti
 * 
 * @Ignore testng annotation only works with importing org.testng.annotation.Ignore
 * 
 * It will not work with importing org.junit.Ignore
 * 
 * @Ignore Is similar to @Test(enabled = false) it will ignore the test case
 *
 */
public class TestNGIgnoretests {
	
	@Ignore
	@Test(enabled = true)
	public void test1() {
		System.out.println("This is test1");
	}
	
	@Test(enabled = false)
	public void test2() {
		System.out.println("This is test2");
	}

}
