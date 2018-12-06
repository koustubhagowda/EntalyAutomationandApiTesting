package com.entaly;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(strict = false, format = { "pretty", "json:target/cucumber.json",
		"html:target/cucumber-html-reports" }, features = "src/test/resources/features", glue = "com.entaly", plugin = {
				"json:target/cucumber.json" }, tags = {"@Login"},monochrome=true)
//,@Reset_password,@Entaly_api_launches,@Login,@Report_verify,@Data_cleansing
public class Cuckes {

}