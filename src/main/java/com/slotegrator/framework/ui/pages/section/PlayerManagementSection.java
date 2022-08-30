package com.slotegrator.framework.ui.pages.section;

import com.slotegrator.framework.ui.BasePage;
import com.slotegrator.framework.ui.pages.AdminPanelPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerManagementSection extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'Registration date')]")
    private WebElement registrationDateColumnHeader;

    public PlayerManagementSection clickRegistrationDateColumnHeader() {
        click(registrationDateColumnHeader);
        return this;
    }

    public PlayerManagementSection checkSortByRegistrationDate() {
        wait.until(ExpectedConditions.stalenessOf(driverManager.getSeleniumWD().findElement(By.xpath("//div[@id='payment-system-transaction-grid']//tbody/tr/td[10]"))));

        List<WebElement> registrationDatesList = driverManager.getSeleniumWD().findElements(
                By.xpath("//div[@id='payment-system-transaction-grid']//tbody/tr/td[10]")
        );

        List<LocalDateTime> inputList = registrationDatesList.stream().map(e -> getLocalDateTimeFromString(e.getText())).collect(Collectors.toList());
        List<LocalDateTime> checkingList = registrationDatesList.stream().map(e -> getLocalDateTimeFromString(e.getText())).sorted().collect(Collectors.toList());

        for (int i = 0; i < checkingList.size(); i++) {
            Assertions.assertEquals(
                    checkingList.get(i), inputList.get(i),
                    "Sorting by registration Date works incorrect");
        }
        return this;
    }

    public PlayerManagementSection checkOpenPage() {
        super.checkOpenPage(By.xpath("//a[contains(text(),'Create player')]"), AdminPanelPage.class);
        return this;
    }

    private LocalDateTime getLocalDateTimeFromString(String stringDate) {
        DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.parse(stringDate, DATEFORMATTER);
        return ldt;
    }
}
