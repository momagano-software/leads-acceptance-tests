package za.co.momagano.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class RegistrationSteps {
    Actor john = Actor.named("Ben")
            .describedAs("the Interested Customer");

    @Managed
    private WebDriver hisBrowser;
    private za.co.momagano.ui.ApplicationHomePage ApplicationHomePage;

    @Before
    public void setup(){
        john.can(BrowseTheWeb.with(hisBrowser));
    }
    @Given("{string} has the following details:")
    public void has_the_following_details(String actor, io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new cucumber.api.PendingException();
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
