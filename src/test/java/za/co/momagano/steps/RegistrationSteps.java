package za.co.momagano.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import za.co.momagano.model.CompanyProfile;
import za.co.momagano.tasks.EnterProfile;
import za.co.momagano.ui.LandingPage;

import java.util.Map;

public class RegistrationSteps {
    Actor john = Actor.named("Ben")
            .describedAs("the Interested Customer");

    @Managed
    private WebDriver hisBrowser;
    private za.co.momagano.ui.ApplicationHomePage ApplicationHomePage;
    private LandingPage LandingPage;

    @Before
    public void setup(){
        john.can(BrowseTheWeb.with(hisBrowser));
    }
    @Given("{string} has the following details:")
    public void has_the_following_details(String actor, CompanyProfile companyProfile) {
        john.attemptsTo(
                Open.browserOn(ApplicationHomePage),
                EnterProfile.company(companyProfile)
        );
    }

    @Given("he registers")
    public void he_registers() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("his profile should be created on the system")
    public void his_profile_should_be_created_on_the_system() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }
    @Then("he should see error {string}")
    public void he_should_see_error(String message) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("he shouldn't be able to submit")
    public void he_shouldn_t_be_able_to_submit() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

}
