package com.slotegrator.framework.managers;

import com.slotegrator.framework.ui.BasePage;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class PageManager {
    private static PageManager pageManager = null;
    private HashMap<String, BasePage> pageContainer = new HashMap<>();

    private PageManager() {

    }

    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    public <T extends BasePage> T getPage(Class<T> page) {
        if (pageContainer.isEmpty() || pageContainer.get(page.getName()) == null) {
            try {
                pageContainer.put(page.getName(), page.getDeclaredConstructor().newInstance());
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        return (T) pageContainer.get(page.getName());
    }

    public void clearPageContainer() {
        if (pageContainer != null) {
            pageContainer.clear();
        }
    }
}
