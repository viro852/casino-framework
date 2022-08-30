package com.slotegrator.framework.ui;

import com.slotegrator.framework.managers.DriverManager;
import com.slotegrator.framework.managers.PageManager;
import com.slotegrator.framework.managers.PropertyManager;
import com.slotegrator.framework.utils.PropConsts;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected DriverManager driverManager = DriverManager.getDriverManager();
    protected WebDriverWait wait = new WebDriverWait(
            driverManager.getSeleniumWD(),
            Duration.ofSeconds(Integer.parseInt(PropertyManager.getPropertyManager().getProperty(PropConsts.WEB_DRIVER_WAIT)))
    );

    protected PageManager pageManager = PageManager.getPageManager();

    protected PropertyManager propertyManager = PropertyManager.getPropertyManager();

    public BasePage() {
        PageFactory.initElements(driverManager.getSeleniumWD(), this);
    }

    protected void checkOpenPage(By locator, Class page) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            Assertions.fail("Страница " + page.getName() + " не загружена!");
        }
    }

    protected void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
}
