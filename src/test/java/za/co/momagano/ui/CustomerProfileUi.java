package za.co.momagano.ui;

import net.serenitybdd.screenplay.targets.Target;

public class CustomerProfileUi {
    public static final Target NAME = Target.the("name field").locatedBy("#name");
    public static final Target SURNAME = Target.the("surname field").locatedBy("#surname");
    public static final Target CONTACT = Target.the("contact field").locatedBy("#contact");
    public static final Target EMAIL = Target.the("email field").locatedBy("#email");
    public static final Target SUBMIT_BUTTON = Target.the("submit button").locatedBy("#submit");
    public static final Target CUSTOMER_PROFILE_LINK = Target.the("customer profile link").locatedBy("#customer-registration-link");
    public static final Target ERROR_MESSAGES = Target.the("customer profile errors").locatedBy(".error-messages");
}

