package testkhanacademy;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testNGbasicCheckin {
	@BeforeClass
	public void beforeclass() {
		System.out.println("beforeclass is running");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforemethod is running");
	}
	@Test
	public void test() {
		System.out.println("Test is running");
		//Assert.fail();
		}
	
	@Test
	public void test1() {
		System.out.println("Test1 is running");}
	
	@AfterMethod
	public void aftermethod() {
		System.out.println("aftermethod is running");
	}

	@AfterClass
	public void afterclass() {
		System.out.println("afterclass is running");
	}

}
