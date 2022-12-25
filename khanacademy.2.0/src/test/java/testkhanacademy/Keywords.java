package testkhanacademy;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Keywords{
	

	
		
		@BeforeClass
		public void beforeclass() {
			System.out.println("beforeclass is running");
		    }

		@BeforeMethod
		public void beforemethod() {
			System.out.println("beforemethod is running");
		  }
		
		@Test(priority=-3, dependsOnMethods= {"ctest2","btest3"},enabled=false)
		public void dtest1() {
			System.out.println("test1 is running");
	}
		@Test(priority=-2,timeOut=3000)
		public void ctest2() throws InterruptedException {
			System.out.println("test2 is running");
			Thread.sleep(4000);
			System.out.println("passed");
	 	}
		
		@Test(priority=3,enabled=false)
		public void btest3() {
			System.out.println("test3 is running");
			Assert.fail();
		}
		
		@Test(priority=4)
		public void atest4() {
			System.out.println("test4 is running");
		}
		
		@AfterMethod
		public void aftermethod() {
			System.out.println("aftermethod is running");
		}
		
		@AfterClass
		public void afterclass() {
			System.out.println("afterclass is running");
		}
	}



