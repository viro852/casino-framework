package com.slotegrator.framework.ui.pages;

import com.slotegrator.framework.ui.BasePage;
import com.slotegrator.framework.utils.PropConsts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='UserLogin_username']")
    private WebElement userNameInput;

    @FindBy(xpath = "//input[@id='UserLogin_password']")
    private WebElement passwordInput;

    private @FindBy(xpath = "//input[@value='Sign in']")
    WebElement signInButton;

    public LoginPage fillAuthForm() {
        userNameInput.sendKeys(propertyManager.getProperty(PropConsts.BASE_UI_LOGIN));
        passwordInput.sendKeys(propertyManager.getProperty(PropConsts.BASE_UI_PASSWORD));
        return this;
    }

    public AdminPanelPage clickSignInButton() {
        click(signInButton);
        return pageManager.getPage(AdminPanelPage.class).checkOpenPage();
    }

    public LoginPage checkOpenPage() {
        super.checkOpenPage(By.xpath("//a[contains(text(),'Casino')]"), LoginPage.class);
        return this;
    }
}
