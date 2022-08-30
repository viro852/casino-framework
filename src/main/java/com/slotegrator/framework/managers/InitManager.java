package com.slotegrator.framework.managers;

import com.slotegrator.framework.utils.PropConsts;

import java.util.concurrent.TimeUnit;

public class InitManager {

    private static InitManager initManager =null;
    private static DriverManager driverManager = DriverManager.getDriverManager();

    private static PageManager pageManager = PageManager.getPageManager();

    private static PropertyManager propertyManager = PropertyManager.getPropertyManager();
    private InitManager(){

    }

    public static InitManager getInitManager(){
        if(initManager==null){
            initManager=new InitManager();
        }
        return initManager;
    }

    public static void startFramework(){
        driverManager.getSeleniumWD().manage().window().maximize();
        driverManager.getSeleniumWD().manage().timeouts().implicitlyWait((Integer.parseInt(propertyManager.getProperty(PropConsts.IMPLICITLY_WAIT))), TimeUnit.SECONDS);
        driverManager.getSeleniumWD().manage().timeouts().pageLoadTimeout((Integer.parseInt(propertyManager.getProperty(PropConsts.PAGE_LOAD_TIMEOUT))),TimeUnit.SECONDS);
    }

    public static void quitFramework() {
        driverManager.quitSeleniumWD();
        pageManager.clearPageContainer();
    }
}
