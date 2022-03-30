package za.co.momagano.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import za.co.momagano.ui.CompanyProfileUi;

import java.util.List;

public class ProfileError implements Question<List<String>> {
    public static Question<List<String>> messages() {
        return new ProfileError();
    }

    @Override
    public List<String> answeredBy(Actor actor) {
        return Text.of(CompanyProfileUi.ERROR_MESSAGES)
                .viewedBy(actor)
                .asList();
    }
}
