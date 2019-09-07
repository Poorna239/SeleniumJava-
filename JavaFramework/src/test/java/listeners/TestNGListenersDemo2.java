package listeners;

import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import junit.framework.Assert;

//@Listeners(listeners.Listenersjava.class)
public class TestNGListenersDemo2 {

	@Test
	public void test4() {
		System.out.println("This is test4 ");
	}
	
	@Test
	public void test5() {
		System.out.println("This is test5 ");
		Assert.assertTrue(false);
	}
	
	@Test
	public void test6() {
		System.out.println("This is test6 ");
		throw new SkipException("This test has been skipped");
	}
	
}
