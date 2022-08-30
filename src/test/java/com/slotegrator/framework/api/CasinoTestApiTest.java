package com.slotegrator.framework.api;

import com.slotegrator.framework.api.actions.Player;
import com.slotegrator.framework.utils.PropConsts;
import com.slotegrator.framework.utils.Utils;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

public class CasinoTestApiTest extends BaseApiTest {

    @Test
    void test1() {
        pageManager.getPage(Player.class)
                .successGuestTokenReceipt(
                        propertyManager.getProperty(PropConsts.BASE_API_LOGIN),
                        propertyManager.getProperty(PropConsts.BASE_API_PASSWORD)
                );
    }

    @Test
    void test2() {
        pageManager.getPage(Player.class)
                .successRegistration(RandomStringUtils.randomAlphabetic(5));
    }

    @Test
    void test3() {
        pageManager.getPage(Player.class)
                .successAuthorizationByCreatedPlayer(
                        propertyManager.getProperty(PropConsts.BASE_API_LOGIN),
                        propertyManager.getProperty(PropConsts.BASE_API_PASSWORD)
                );
    }

    @Test
    void test4() {
        pageManager.getPage(Player.class)
                .successPlayerProfileDataReceipt(
                        Utils.readDataFromFile("registeredPlayerId.txt"),
                        Utils.readDataFromFile("SuffixOfPlayerAttributes.txt")
                );
    }

    @Test
    void test5() {
        pageManager.getPage(Player.class)
                .unsuccessPlayerProfileDataReceipt("5");
    }
}
