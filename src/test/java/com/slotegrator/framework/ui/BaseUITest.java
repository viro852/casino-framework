package com.slotegrator.framework.ui;

import com.slotegrator.framework.managers.DriverManager;
import com.slotegrator.framework.managers.InitManager;
import com.slotegrator.framework.managers.PageManager;
import com.slotegrator.framework.managers.PropertyManager;
import com.slotegrator.framework.utils.PropConsts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseUITest {

    protected DriverManager driverManager = DriverManager.getDriverManager();

    protected PropertyManager propertyManager = PropertyManager.getPropertyManager();

    protected PageManager pageManager = PageManager.getPageManager();

    @BeforeEach
    public void setUp() {
        InitManager.startFramework();
        driverManager.getSeleniumWD().get(propertyManager.getProperty(PropConsts.BASE_URL));
    }

    @AfterEach
    public void tearDown() {
        InitManager.quitFramework();
    }
}
