package _27383.Q3;

public class Employer extends Taxpayer {
    private final String employerName;
    private final String employerTIN;
    private final String contact;

    public Employer(int id, String authorityName, String region, String email,
                    String categoryName, double rate, String code,
                    String tin, String taxpayerName, String address,
                    String employerName, String employerTIN, String contact) throws TaxDataException {
        super(id, authorityName, region, email, categoryName, rate, code, tin, taxpayerName, address);
        if (contact.length() != 10) throw new TaxDataException("Contact must be 10 digits");
        this.employerName = employerName;
        this.employerTIN = employerTIN;
        this.contact = contact;
    }

    public String getEmployerName() {
        return employerName;
    }

    public String getEmployerTIN() {
        return employerTIN;
    }

    public String getContact() {
        return contact;
    }
}
