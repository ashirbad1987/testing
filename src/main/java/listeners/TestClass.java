package listeners;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass {

	@Test(retryAnalyzer=RetryAnalyzer.class)
	public void run() {
		
		Assert.assertTrue(false);
	}
	
	@Test(retryAnalyzer=RetryAnalyzer.class)
	public void run1() {
		
		Assert.assertTrue(true);
	}
	
	@Test(retryAnalyzer=RetryAnalyzer.class)
	public void run3() {
		
		Assert.assertTrue(false);
	}
}
