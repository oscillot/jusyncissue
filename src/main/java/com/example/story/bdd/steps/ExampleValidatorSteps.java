package com.example.story.bdd.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.stereotype.Component;

@Component
public class ExampleValidatorSteps {

    @Given("Print: $printMe")
    @When("Print: $printMe")
    @Then("Print: $printMe")
    public void everything(@Named("printMe") String printMe) {
        System.out.println(printMe);
    }

    @Given("Fail: $printMe")
    @When("Fail: $printMe")
    @Then("Fail: $printMe")
    public void fail(@Named("printMe") String failMe) {
        throw new RuntimeException(failMe);
    }
}
