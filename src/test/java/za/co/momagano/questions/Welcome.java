package za.co.momagano.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import za.co.momagano.ui.LandingPage;

public class Welcome implements Question<String> {

    public static Question<String> message() {
        return new Welcome();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(LandingPage.WELCOME_MESSAGE)
                .viewedBy(actor)
                .asString();
    }
}
