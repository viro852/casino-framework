package com.slotegrator.framework.ui.cucumber_steps;

import com.slotegrator.framework.managers.PageManager;
import com.slotegrator.framework.ui.BasePage;
import com.slotegrator.framework.ui.pages.AdminPanelPage;
import com.slotegrator.framework.ui.pages.section.PlayerManagementSection;
import io.cucumber.java.bg.И;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPanelPageStep  {

    private PageManager pageManager = PageManager.getPageManager();

    @И("Кликаем по кнопке Users")
    public void clickUsersButton() {
      pageManager.getPage(AdminPanelPage.class).clickUsersButton();
    }

    @И("Кликаем по кнопке Players")
    public void clickPlayersButton() {
       pageManager.getPage(AdminPanelPage.class).clickPlayersButton();
    }


}
