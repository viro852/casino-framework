package com.slotegrator.framework.ui.cucumber_steps;

import com.slotegrator.framework.managers.PageManager;
import com.slotegrator.framework.ui.pages.AdminPanelPage;
import io.cucumber.java.bg.И;

public class AdminPanelPageStep {

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
