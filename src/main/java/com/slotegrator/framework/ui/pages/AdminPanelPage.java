package com.slotegrator.framework.ui.pages;

import com.slotegrator.framework.ui.BasePage;
import com.slotegrator.framework.ui.pages.section.PlayerManagementSection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPanelPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'Users')]")
    private WebElement usersButton;

    @FindBy(xpath = "//ul[@id='s-menu-users']//a[text()='Players']")
    private WebElement playersButton;


    public AdminPanelPage clickUsersButton() {
        click(usersButton);
        return this;
    }

    public PlayerManagementSection clickPlayersButton() {
        click(playersButton);
        return pageManager.getPage(PlayerManagementSection.class).checkOpenPage();
    }

    public AdminPanelPage checkOpenPage() {
        super.checkOpenPage(By.xpath("//span[contains(text(),'Dashboard')]"), AdminPanelPage.class);
        return this;
    }
}
