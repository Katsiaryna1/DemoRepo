package com.Fits.qa.base;

import com.Fits.qa.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    static WebDriver driver;
    static Properties prop;



   public TestBase(){

       try{
           prop = new Properties();
           FileInputStream ip = new FileInputStream("/Users/Sergey/comfitsqa/src/main/java/com/Fits"
                   + "/qa/confif/config.properties");
           prop.load(ip);
       }catch (FileNotFoundException e){
           // file not found handling

           e.printStackTrace();
       }catch (IOException e){
           e.printStackTrace();
           // generic IOException handling for any other IOException.
       }

    }

    public static void initialization(){
       String browserName = prop.getProperty("browser");
       if(browserName.equals("chrome")){
           System.setProperty("webdriver.chrome.driver","/Applications/Drivers/chromedriver" );
           WebDriver driver = new ChromeDriver();
       }

       driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
       driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
       driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

       driver.get(prop.getProperty("url"));
    }
}
