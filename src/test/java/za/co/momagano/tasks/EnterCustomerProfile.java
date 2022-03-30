package za.co.momagano.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import za.co.momagano.model.CustomerProfile;
import za.co.momagano.ui.CustomerProfileUi;

public class EnterCustomerProfile implements Task {
    private CustomerProfile customerProfile;

    public EnterCustomerProfile(za.co.momagano.model.CustomerProfile customerProfile) {
        this.customerProfile = customerProfile;
    }

    public static Performable customer(za.co.momagano.model.CustomerProfile customerProfile) {
        return Instrumented.instanceOf(EnterCustomerProfile.class).withProperties(customerProfile);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(customerProfile.getName()).into(CustomerProfileUi.NAME),
                Enter.theValue(customerProfile.getSurname()).into(CustomerProfileUi.SURNAME),
                Enter.theValue(customerProfile.getContact()).into(CustomerProfileUi.CONTACT),
                Enter.theValue(customerProfile.getEmail()).into(CustomerProfileUi.EMAIL)
        );
    }
}
