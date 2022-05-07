/*package dtu.employees.project;

import dtu.Helper.ErrorMessageHolder;
import dtu.dto.developerInfo;
import dtu.employees.Developer;
import dtu.project.Project;
import dtu.softwarehus.SoftwareHuset;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.hu.De;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class assignPmTest {

    private ErrorMessageHolder errorMessage;;
    SoftwareHuset softwareHuset;
    HashMap<String, Developer> developers;
    Developer developer,manager;

    Project project;


    public assignPmTest(SoftwareHuset softwareHuset, HashMap<String, Developer> developers){
            this.softwareHuset = softwareHuset;
            this.developers = developers;

        }
    @Given("that there is a developer with initials {string}")
    public void that_there_is_a_developer_with_initials(String name) throws Exception {
       developer = new Developer(name);
        assertThat(developer.getInitials(), is(equalTo(name)));
    }

    /*@And("there is a project named {string}")
    public void thereIsAProjectNamed(String name) {
        project = new Project(1,1,1);
        assertThat(project.name,is(equalTo((name))));
    }*/
/*
    @When("the developer assigns the project manager with initials {string}")
    public void theDeveloperAssignsTheProjectManagerWithInitials(String arg0) {

    }

    @Then("the project manager {string} is assigned to the project")
    public void theProjectManagerIsAssignedToTheProject(String name) {
        manager = new Developer(name);
        manager.setToProjectManager();

    }

    @Given("that there isn't a developer with initials {string}")
    public void thatThereIsnTADeveloperWithInitials(String anotherName) {

    }

    @And("there is a project manager with initials {string}")
    public void thereIsAProjectManagerWithInitials(String arg0) {

    }



}
*/