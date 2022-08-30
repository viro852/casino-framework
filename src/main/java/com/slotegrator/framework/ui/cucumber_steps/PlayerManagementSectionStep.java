package com.slotegrator.framework.ui.cucumber_steps;

import com.slotegrator.framework.managers.PageManager;
import com.slotegrator.framework.ui.BasePage;
import com.slotegrator.framework.ui.pages.AdminPanelPage;
import com.slotegrator.framework.ui.pages.section.PlayerManagementSection;
import io.cucumber.java.bg.И;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerManagementSectionStep  {

    PageManager pageManager = PageManager.getPageManager();

    @И("Кликаем по заголовку столбца Дата регистрации")
    public void sortByRegistrationDate() {
        pageManager.getPage(PlayerManagementSection.class).clickRegistrationDateColumnHeader();
    }

    @И("Сортировка по Дате регистрации выполнена успешно")
    public void checkSortByRegistrationDate() {
        pageManager.getPage(PlayerManagementSection.class).checkSortByRegistrationDate();
    }
}
