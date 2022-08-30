package com.slotegrator.framework.ui.cucumber_steps;

import com.slotegrator.framework.managers.PageManager;
import com.slotegrator.framework.ui.pages.LoginPage;
import io.cucumber.java.en.And;

public class LoginPageStep {

    private PageManager pageManager = PageManager.getPageManager();

    @And("Мы на странице Login page")
    public void checkOpenLoginPage() {
        pageManager.getPage(LoginPage.class).checkOpenPage();
    }
    @And("Проходим аутентификацию для доступа в панель администратора")
    public void fillAuthForm() {
        pageManager.getPage(LoginPage.class).fillAuthForm();
    }

    @And("Кликаем по кнопке Sign in")
    public void clickSignInButton() {
        pageManager.getPage(LoginPage.class).clickSignInButton();
    }
}
