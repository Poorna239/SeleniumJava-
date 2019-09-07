package listeners;

import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import junit.framework.Assert;

//@Listeners(listeners.Listenersjava.class)
public class TestNGListenersDemo {

	@Test
	public void test1() {
		System.out.println("This is test1 ");
	}
	
	@Test
	public void test2() {
		System.out.println("This is test2 ");
		Assert.assertTrue(false);
	}
	
	@Test
	public void test3() {
		System.out.println("This is test3 ");
		throw new SkipException("This test has been skipped");
	}
	
}
