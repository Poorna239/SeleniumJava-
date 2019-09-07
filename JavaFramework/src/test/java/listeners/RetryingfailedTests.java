package listeners;

import org.testng.Assert;
import org.testng.annotations.Test;

/***
 * 
 * @author poorna.komarasetti
 *
 * you might want TestNG to automatically retry a test whenever it fails. In those situations, 
 * you can use a retry analyzer. When you bind a retry analyzer to a test, 
 * TestNG automatically invokes the retry analyzer to determine if TestNG can retry a test case again 
 * in an attempt to see if the test that just fails now passes. Here is how you use a retry analyzer:
 * Build an implementation of the interface org.testng.IRetryAnalyzer
 * Bind this implementation to the @Test annotation for e.g., @Test(retryAnalyzer = LocalRetry.class)
 *
 */

public class RetryingfailedTests {

	@Test
	public void test_case1() {
		System.out.println("This is test case 1");
	}
	
	@Test(retryAnalyzer = listeners.RetryAnalyser.class)
	public void test_case2() {
		System.out.println("This is test case 2");
		Assert.assertTrue(0>1);
	}

}
