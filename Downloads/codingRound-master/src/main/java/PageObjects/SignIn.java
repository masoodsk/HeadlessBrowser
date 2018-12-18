package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.testBase;

public class SignIn {

	
	public WebDriver driver;
	
	@FindBy(xpath="//*[@id='userAccountLink']/span[2]")
	private WebElement yourTrips;
	
	@FindBy(xpath="//*[@id='SignIn']")
	private WebElement signinbutton;
	
	@FindBy(tagName="iframe")
	private  List<WebElement> objFrames;	
	
	@FindBy(xpath="//*[@id='close']")
	private WebElement ButtonClose;
	
	
	@FindBy(xpath="//*[@id='Home']/div/div/ul/li/div/div[2]/aside[1]/nav/ul[1]/li[1]/a[1]")
	private WebElement flightsClick;
	
	public void fn_ClickonYourTrips() {
		yourTrips.click();
	}
	
	
	
	public void fn_signbutton() {
		
		signinbutton.click();
	}
	
	public void fn_Close() {
		ButtonClose.click();
	}
	
	public void fn_flighClick() {
		flightsClick.click();
	}
	
		
	public SignIn(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	//	testBase objtestBase=new testBase();
	}
	
}
