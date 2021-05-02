package TestNgLearning;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Testcase2 {
	
	@Test(groups = {"high", "low"})
	public void assertTest() {
		
		String expected = "Gmail.com";
		String actual = "yahoo.com";
		
		
		/*
		 * Assert.assertEquals(actual, expected, "Titles not matching up");
		 * Assert.assertTrue(false, "Testcase returning false");
		 * Assert.fail("intentionally failed");
		 */
		
		
		SoftAssert asrt = new SoftAssert();
		asrt.assertEquals(actual, expected, "Titles not matching up");
		asrt.assertTrue(false, "Testcase returning false");
		asrt.fail("intentionally failed");
		asrt.assertAll();
		
	}

}
