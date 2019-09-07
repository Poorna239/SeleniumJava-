package googlesearch_page;

import org.testng.annotations.Test;

@Test(groups = {"AllTestsInClass"})
public class TestNGGroups {
	
	@Test(groups = {"sainity"})
	public void test1() {
		System.out.println("This is test1");
	}
	
	@Test(groups = {"smoke"})
	public void test2() {
		System.out.println("This is test2");
	}
	
	@Test(groups = {"regresion"})
	public void test3() {
		System.out.println("This is test3");
	}
	
	@Test(groups = {"regresion", "smoke"})
	public void test4() {
		System.out.println("This is test4");
	}
	@Test
	public void test5() {
		System.out.println("This is test5");
	}

}
