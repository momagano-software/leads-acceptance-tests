package za.co.momagano.ui;

import net.serenitybdd.screenplay.targets.Target;

public class LandingPage {
    public static final Target WELCOME_MESSAGE = Target.the("welcome text")
            .locatedBy("(//div/span)[1]");
}
