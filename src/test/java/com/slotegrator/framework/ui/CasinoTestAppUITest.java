package com.slotegrator.framework.ui;

import com.slotegrator.framework.ui.pages.LoginPage;
import org.junit.jupiter.api.Test;


public class CasinoTestAppUITest extends BaseUITest {

    @Test
    void test1() {
        pageManager.getPage(LoginPage.class)
                .checkOpenPage()
                .fillAuthForm()
                .clickSignInButton()
                .clickUsersButton()
                .clickPlayersButton()
                .clickRegistrationDateColumnHeader()
                .checkSortByRegistrationDate();
    }
}
