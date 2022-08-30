package com.slotegrator.framework.ui.cucumber_steps;

import com.slotegrator.framework.managers.DriverManager;
import com.slotegrator.framework.managers.InitManager;
import com.slotegrator.framework.managers.PropertyManager;
import com.slotegrator.framework.utils.PropConsts;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
   private DriverManager driverManager = DriverManager.getDriverManager();

   private PropertyManager propertyManager = PropertyManager.getPropertyManager();

    @Before
    public void before() {
        InitManager.startFramework();
        driverManager.getSeleniumWD().get(propertyManager.getProperty(PropConsts.BASE_URL));
    }

    @After
    public void after() {
        InitManager.quitFramework();
    }
}
