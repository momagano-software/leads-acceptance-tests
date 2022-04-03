package za.co.momagano.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import za.co.momagano.model.CompanyProfile;
import za.co.momagano.ui.CompanyProfileUi;

public class EnterCompanyProfile implements Task {
    private CompanyProfile companyProfile;

    public EnterCompanyProfile(CompanyProfile companyProfile) {
        this.companyProfile = companyProfile;
    }

    public static Performable company(CompanyProfile companyProfile) {
        return Instrumented.instanceOf(EnterCompanyProfile.class).withProperties(companyProfile);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(companyProfile.getName()).into(CompanyProfileUi.NAME),
                Enter.theValue(companyProfile.getCompanyRegistration()).into(CompanyProfileUi.COMPANY_REGISTRATION),
                Enter.theValue(companyProfile.getTradingName()).into(CompanyProfileUi.TRADING_NAME),
                Enter.theValue(companyProfile.getContact()).into(CompanyProfileUi.CONTACT),
                Enter.theValue(companyProfile.getEmail()).into(CompanyProfileUi.EMAIL),
                Enter.theValue(companyProfile.getExperience()).into(CompanyProfileUi.EXPERIENCE),
                Enter.theValue(companyProfile.getLocation()).into(CompanyProfileUi.LOCATION),
                Enter.theValue(companyProfile.getPortfolio()).into(CompanyProfileUi.PORTFOLIO),
                Enter.theValue(companyProfile.getAbout()).into(CompanyProfileUi.ABOUT),
                Enter.theValue(companyProfile.getName()).into(CompanyProfileUi.NAME)
//                EnterSocials.socials(companyProfile.getSocials())
                // todo: Enter working hours
        );
    }
}
