package eagle;

import org.apache.hc.core5.reactor.Command.Priority;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class mav {
 
@BeforeTest
public void bt() {
	System.out.println("beforetest");
}
@Test(priority=2)
public void login() {
	System.out.println("login successfull");
}
	@Test(priority=1)
	public void homepage() {
		System.out.println("homepage successful");
	}
	@Test(priority=0)
	public void search() {
		System.out.println("search successful");
}
}