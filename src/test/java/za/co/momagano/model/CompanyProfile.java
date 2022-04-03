package za.co.momagano.model;

import java.util.List;

public class CompanyProfile {

    private final String companyRegistration;
    private final String name;
    private final String tradingName;
    private final String email;
    private final String contact;
    private final String experience;
    private final List<WorkingHours> workingHours;
    private final String location;
    private final String portfolio;
    private final List<Social> socials;
    private final String about;

    public CompanyProfile(String companyRegistration, String name, String tradingName, String email, String contact, String experience, List<WorkingHours> workingHours, String location, String portfolio, List<Social> socials, String about) {
        this.companyRegistration = companyRegistration;
        this.name = name;
        this.tradingName = tradingName;
        this.email = email;
        this.contact = contact;
        this.experience = experience;
        this.workingHours = workingHours;
        this.location = location;
        this.portfolio = portfolio;
        this.socials = socials;
        this.about = about;
    }

    public String getName() {
        return name;
    }

    public String getTradingName() {
        return tradingName;
    }

    public String getEmail() {
        return email;
    }

    public String getContact() {
        return contact;
    }

    public String getExperience() {
        return experience;
    }

    public List<WorkingHours> getWorkingHours() {
        return workingHours;
    }

    public String getLocation() {
        return location;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public List<Social> getSocials() {
        return socials;
    }

    public String getAbout() {
        return about;
    }

    public String getCompanyRegistration() {
        return companyRegistration;
    }

    @Override
    public String toString() {
        return "CompanyProfile{" +
                "companyRegistration='" + companyRegistration + '\'' +
                ", name='" + name + '\'' +
                ", tradingName='" + tradingName + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", experience='" + experience + '\'' +
                ", workingHours=" + workingHours +
                ", location='" + location + '\'' +
                ", portfolio='" + portfolio + '\'' +
                ", socials=" + socials +
                ", about='" + about + '\'' +
                '}';
    }
}
