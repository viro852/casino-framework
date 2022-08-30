package com.slotegrator.framework.ui.cucumber_steps;

import com.slotegrator.framework.managers.PageManager;
import com.slotegrator.framework.ui.pages.section.PlayerManagementSection;
import io.cucumber.java.bg.И;

public class PlayerManagementSectionStep {

    private PageManager pageManager = PageManager.getPageManager();

    @И("Кликаем по заголовку столбца Дата регистрации")
    public void sortByRegistrationDate() {
        pageManager.getPage(PlayerManagementSection.class).clickRegistrationDateColumnHeader();
    }

    @И("Сортировка по Дате регистрации выполнена успешно")
    public void checkSortByRegistrationDate() {
        pageManager.getPage(PlayerManagementSection.class).checkSortByRegistrationDate();
    }
}
