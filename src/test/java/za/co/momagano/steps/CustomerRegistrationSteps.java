package za.co.momagano.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.WebDriver;
import za.co.momagano.model.CompanyProfile;
import za.co.momagano.ui.LandingPage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.stateOf;
import static org.junit.Assert.assertThat;

public class CustomerRegistrationSteps {
    Actor peter = Actor.named("Peter")
            .describedAs("the Interested Customer");

    @Managed
    private WebDriver hisBrowser;
    private za.co.momagano.ui.ApplicationHomePage ApplicationHomePage;
    private LandingPage LandingPage;
    private CompanyProfile companyProfile;
    private EnvironmentVariables environmentVariables;

    @Before
    public void setup() {
        peter.can(BrowseTheWeb.with(hisBrowser));
    }

    @Given("Customer {string} has the following details:")
    public void customer_has_the_following_details(String string, io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new cucumber.api.PendingException();
    }


}
