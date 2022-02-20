package za.co.momagano.model;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;

import java.util.List;
import java.util.Locale;
import java.util.Map;

public class TypeConfigurer implements TypeRegistryConfigurer {
    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(new DataTableType(CompanyProfile.class,
                (Map<String,String> row)->{

                    String name = row.get("Name");
                    String tradingName = row.get("Trading Name");
                    String email = row.get("Email");
                    String contact = row.get("Contact");
                    String experience = row.get("Experience");
                    List<WorkingHours> workingHours = WorkingHours.getWorkingHours(row.get("Working hours"));
                    String location = row.get("Location");
                    String portfolio = row.get("Portfolio");
                    List<Social> socials = Social.getSocials(row.get("Socials"));
                    String about = row.get("About");
                    String companyRegistration = row.get("Company Reg");


                    return new CompanyProfile(companyRegistration,name,tradingName,email,contact,experience,workingHours,location,portfolio,socials,about);
                }));
    }

}
