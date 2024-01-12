package com.example.produktapi;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/feature/",  plugin = {"pretty", "html:target/team2-project-report.html"})

public class RunApiTest {



}
