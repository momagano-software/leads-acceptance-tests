package za.co.momagano.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import za.co.momagano.model.Social;
import za.co.momagano.ui.Socials;

import java.util.List;

public class EnterSocials implements Task {
    private List<Social> socials;

    public EnterSocials(List<Social> socials) {
        this.socials = socials;
    }

    public static Performable socials(List<Social> socials) {
        return Instrumented.instanceOf(EnterSocials.class).withProperties(socials);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
      socials.forEach(social ->
              actor.attemptsTo(
                      Enter.theValue(social.getPlatform()).into(Socials.PLATFORM),
                      Enter.theValue(social.getHandle()).into(Socials.HANDLE)
              )
      );
    }
}
