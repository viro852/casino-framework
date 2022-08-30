package com.slotegrator.framework.api;

import com.slotegrator.framework.managers.PageManager;
import com.slotegrator.framework.managers.PropertyManager;

public class BaseApiTest {

    protected PropertyManager propertyManager = PropertyManager.getPropertyManager();
    protected PageManager pageManager = PageManager.getPageManager();
}
