package com.entaly;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		strict = false,
				format = {"pretty","json:target/cucumber.json","html:target/cucumber-html-reports"},
				features = "src/test/resources", 
				glue ="com.entaly" ,
				plugin={"json:target/cucumber.json"},
				tags = {"@Login,@Entaly_api_launches,@Reset_password"}
		)
public class Cuckes
{


}

