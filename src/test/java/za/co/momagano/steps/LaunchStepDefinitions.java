package za.co.momagano.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import za.co.momagano.questions.Welcome;
import za.co.momagano.ui.ApplicationHomePage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class LaunchStepDefinitions {

    Actor ben = Actor.named("Ben")
            .describedAs("the Interested Customer");

    @Managed
    private WebDriver hisBrowser;
    private za.co.momagano.ui.ApplicationHomePage ApplicationHomePage;

    @Before
    public void setup(){
        ben.can(BrowseTheWeb.with(hisBrowser));
    }

    @Given("Ben launches demo site")
    public void ben_launches_demo_site() {
        ben.attemptsTo(
                Open.browserOn(ApplicationHomePage)
        );
    }

    @Then("Ben should see {string}")
    public void ben_should_see(String expectedMessage) {
        ben.should(
                seeThat(Welcome.message(), is(equalTo(expectedMessage)))
        );
    }

}
