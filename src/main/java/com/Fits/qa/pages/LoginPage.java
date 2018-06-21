package com.Fits.qa.pages;

import com.Fits.qa.base.TestBase;
import org.eclipse.jetty.util.annotation.Name;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends TestBase{

    //Page Factory - OR object repository

    @FindBy(name ="username")
    WebElement username;

    @FindBy(name="password")
    WebElement password;


}
