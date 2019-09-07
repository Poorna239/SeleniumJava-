package googlesearch_page;

import org.testng.annotations.Test;

/**
 * 
 * @author poorna.komarasetti
 * TestNG dependencies
 * tests depending on groups will have more priority then the tests depends on methods
 */
public class Dependencies {

	@Test(dependsOnGroups = {"ss1"})
	public void test1() {
		System.out.println("This is test1");
	}
	
	@Test(groups = {"ss1"})
	public void test2() {
		System.out.println("This is test2");
	}
	
	@Test(dependsOnMethods = {"test4"})
	public void test3() {
		System.out.println("This is test3");
	}
	
	@Test()
	public void test4() {
		System.out.println("This is test4");
	}
	
	
}
