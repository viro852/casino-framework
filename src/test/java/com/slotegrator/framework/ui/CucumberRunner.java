package com.slotegrator.framework.ui;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/scenario",
        glue = "com.slotegrator.framework.ui.cucumber_steps",
        tags = "@sort"
)
public class CucumberRunner {

}
