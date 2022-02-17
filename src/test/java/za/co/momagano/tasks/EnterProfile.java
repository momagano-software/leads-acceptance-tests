package za.co.momagano.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import za.co.momagano.model.CompanyProfile;
import za.co.momagano.ui.Profile;

public class EnterProfile implements Task {
    private CompanyProfile companyProfile;

    public EnterProfile(CompanyProfile companyProfile) {
        this.companyProfile = companyProfile;
    }

    public static Performable company(CompanyProfile companyProfile) {
        return Instrumented.instanceOf(EnterProfile.class).withProperties(companyProfile);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(companyProfile.getName()).into(Profile.NAME),
                Enter.theValue(companyProfile.getTradingName()).into(Profile.TRADING_NAME),
                Enter.theValue(companyProfile.getContact()).into(Profile.CONTACT),
                Enter.theValue(companyProfile.getEmail()).into(Profile.EMAIL),
                Enter.theValue(companyProfile.getExperience()).into(Profile.EXPERIENCE),
                Enter.theValue(companyProfile.getLocation()).into(Profile.LOCATION),
                Enter.theValue(companyProfile.getPortfolio()).into(Profile.PORTFOLIO),
                EnterSocials.socials(companyProfile.getSocials())
                // todo: Enter working hours
        );
    }
}
