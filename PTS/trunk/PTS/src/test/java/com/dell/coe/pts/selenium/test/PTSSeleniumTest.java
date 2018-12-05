/**
 * 
 */
package com.dell.coe.pts.selenium.test;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

/**
 * @author SNEHASISH_SHITH
 *
 */
public class PTSSeleniumTest {

    @Test
    public void verifyTest() throws InterruptedException {
        /*String xport = System.getProperty("Importal.xvfb.id", ":1");
        final File firefoxPath = new File(System.getProperty("Importal.deploy.firefox.path", "/usr/local/firefox"));
        FirefoxBinary firefoxBinary = new FirefoxBinary(firefoxPath);
        firefoxBinary.setEnvironmentProperty("DISPLAY", xport);*/

        HtmlUnitDriver unitDriver = new HtmlUnitDriver();
        unitDriver.setJavascriptEnabled(true);
        // open google.com webpage
        unitDriver.get("http://160.110.220.63:19092/PTS/web/app.html");

        System.out.println("Title of the page is -> " + unitDriver.getTitle());
        String domainName = (String) unitDriver.executeScript("return document.domain");
        System.out.println("Domain name is " + domainName);

        // Print a Log In message to the screen
        System.out.println("Successfully opened the PTS site");
        Thread.sleep(10);
        unitDriver.quit();
    }

}
