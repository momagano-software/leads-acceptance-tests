package za.co.momagano.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.WebDriver;
import za.co.momagano.model.CompanyProfile;
import za.co.momagano.model.DB;
import za.co.momagano.questions.ProfileError;
import za.co.momagano.tasks.EnterProfile;
import za.co.momagano.ui.LandingPage;
import za.co.momagano.ui.Profile;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotEnabled;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.stateOf;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class ProfileRegistrationSteps {
    Actor john = Actor.named("John")
            .describedAs("the service provider");

    @Managed
    private WebDriver hisBrowser;
    private za.co.momagano.ui.ApplicationHomePage ApplicationHomePage;
    private LandingPage LandingPage;
    private CompanyProfile companyProfile;
    private EnvironmentVariables environmentVariables;

    @Before
    public void setup() {
        john.can(BrowseTheWeb.with(hisBrowser));
    }

    @Given("{string} has the following details:")
    public void has_the_following_details(String actor, CompanyProfile companyProfile) {
        this.companyProfile = companyProfile;
        System.out.println("Profile:" + companyProfile);
        john.attemptsTo(
                Open.browserOn(ApplicationHomePage),
                EnterProfile.company(companyProfile)
        );
    }

    @Given("he registers")
    public void he_registers() {
        john.attemptsTo(
                Click.on(Profile.SUBMIT_BUTTON)
        );
    }

    @Then("his profile should be created on the system")
    public void his_profile_should_be_created_on_the_system() {

        String webserviceEndpoint = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("webdriver.base.url") + "profile";
        Response response = DB.queryByCompanyRegistration(webserviceEndpoint, companyProfile.getCompanyRegistration());
        assertThat(response.statusCode(), is(200));
        assertThat(response.body(), is(notNullValue()));
        Serenity.recordReportData().withTitle("CALLBACK DATABASE RECORD").andContents(response.body().prettyPrint());
    }

    @Then("he should see error {string}")
    public void he_should_see_error(String message) {
        john.should(
                seeThat(ProfileError.messages(), hasItems(message.split(", ")))
        );
    }

    @Then("he shouldn't be able to submit")
    public void he_shouldn_t_be_able_to_submit() {
        john.should(
                seeThat(stateOf(Profile.SUBMIT_BUTTON), isNotEnabled())
        );
    }

}
