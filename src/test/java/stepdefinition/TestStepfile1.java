package stepdefinition;

import org.openqa.selenium.WebDriver;

import Pagefiles.Testpage1;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestStepfile1 {
	
	
	public WebDriver driver;
	
	Testpage1 test = new Testpage1 ();

@Given("^User Navigate to LogIn Page$")
public void user_Navigate_to_LogIn_Page() throws Throwable {
	test.loginpage();
	   
}

@When("^User enters UserName and Password$")
public void user_enters_UserName_and_Password() throws Throwable {
    test.EnterFromandToLocation();
    
    
}

@When("^Message displayed Login Successfully$")
public void message_displayed_Login_Successfully() throws Throwable {
    test.SelectDateandSearchBUS();
    
}


}
