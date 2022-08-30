package com.slotegrator.framework.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private static DriverManager driverManager = null;
    private WebDriver seleniumWD = null;

    private DriverManager() {

    }

    public static DriverManager getDriverManager() {
        if (driverManager == null) {
            driverManager = new DriverManager();
        }
        return driverManager;
    }

    private void initSeleniumWD() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        seleniumWD = new ChromeDriver();
    }

    public WebDriver getSeleniumWD() {
        if (seleniumWD == null) {
            initSeleniumWD();
        }
        return seleniumWD;
    }

    public void quitSeleniumWD() {
        if (seleniumWD != null) {
            seleniumWD.quit();
            seleniumWD = null;
        }
    }

}
