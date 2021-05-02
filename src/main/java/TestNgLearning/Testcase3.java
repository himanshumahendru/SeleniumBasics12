package TestNgLearning;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase3 {

	@Test(groups ="high")
	public void doUserReg() {
		System.out.println("Executing User reg test");
		//Assert.fail("Failing user reg test");
	}
	
	@Test(groups = "low", dependsOnMethods= {"doUserReg"})
	public void Dologin() {
		System.out.println("Executing Login test");
	}

}
