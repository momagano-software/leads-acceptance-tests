package za.co.momagano.ui;

import net.serenitybdd.screenplay.targets.Target;

public class CompanyProfileUi {
    public static final Target NAME = Target.the("name field").locatedBy("#name");
    public static final Target TRADING_NAME = Target.the("trading name field").locatedBy("#trading-name");
    public static final Target CONTACT = Target.the("contact field").locatedBy("#contact");
    public static final Target EMAIL = Target.the("email field").locatedBy("#email");
    public static final Target EXPERIENCE = Target.the("experience field").locatedBy("#experience");
    public static final Target LOCATION = Target.the("location field").locatedBy("#location");
    public static final Target PORTFOLIO = Target.the("portfolio field").locatedBy("#portfolio");
    public static final Target SUBMIT_BUTTON = Target.the("submit button").locatedBy("#submit");
    public static final Target ERROR_MESSAGES = Target.the("error messages").locatedBy(".error");
    public static final Target COMPANY_REGISTRATION = Target.the("company registration field").locatedBy("#company-registration");
    public static final Target ABOUT = Target.the("about field").locatedBy("#about");
    public static final Target COMPANY_PROFILE_LINK = Target.the("company profile link").locatedBy("#company-registration-link");
}

