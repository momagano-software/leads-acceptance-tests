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
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.util.EnvironmentVariables;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.WebDriver;
import za.co.momagano.model.CustomerProfile;
import za.co.momagano.model.DB;
import za.co.momagano.questions.CustomerProfileError;
import za.co.momagano.questions.ProfileError;
import za.co.momagano.tasks.EnterCompanyProfile;
import za.co.momagano.tasks.EnterCustomerProfile;
import za.co.momagano.ui.CompanyProfileUi;
import za.co.momagano.ui.CustomerProfileUi;
import za.co.momagano.ui.LandingPage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotEnabled;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.stateOf;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class CustomerRegistrationSteps {
    Actor peter = Actor.named("Peter")
            .describedAs("the Interested Customer");

    @Managed
    private WebDriver hisBrowser;
    private za.co.momagano.ui.ApplicationHomePage ApplicationHomePage;
    private LandingPage LandingPage;
    private CustomerProfile customerProfile;
    private EnvironmentVariables environmentVariables;

    @Before
    public void setup() {
        peter.can(BrowseTheWeb.with(hisBrowser));
    }

    @Given("Customer {string} has the following details:")
    public void customer_has_the_following_details(String string, CustomerProfile customerProfile) {
        this.customerProfile = customerProfile;
        System.out.println("CustomerProfile:" + customerProfile);
        peter.attemptsTo(
                Open.browserOn(ApplicationHomePage),
                Click.on(CustomerProfileUi.CUSTOMER_PROFILE_LINK),
                EnterCustomerProfile.customer(customerProfile)
        );
    }

    @Given("he submits")
    public void he_submits() {
        peter.attemptsTo(
                Click.on(CustomerProfileUi.SUBMIT_BUTTON)
        );
    }

    @Then("his customer profile should be created on the system")
    public void his_customer_profile_should_be_created_on_the_system() {
        String webserviceEndpoint = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("webdriver.base.url") + "customer/profile";
        Response response = DB.queryByCustomerEmail(webserviceEndpoint, customerProfile.getEmail());
        assertThat(response.statusCode(), is(200));
        assertThat(response.body(), is(CoreMatchers.not("{}")));
        Serenity.recordReportData().withTitle("CALLBACK DATABASE RECORD").andContents(response.body().prettyPrint());
    }
    @Then("Peter should see error {string}")
    public void peter_should_see_error(String message) {
        peter.should(
                seeThat(CustomerProfileError.messages(), hasItems(message.split(", ")))
        );
    }

    @Then("Peter shouldn't be able to submit")
    public void peter_shouldn_t_be_able_to_submit() {
        peter.should(
                seeThat(stateOf(CompanyProfileUi.SUBMIT_BUTTON), isNotEnabled())
        );
    }


}
