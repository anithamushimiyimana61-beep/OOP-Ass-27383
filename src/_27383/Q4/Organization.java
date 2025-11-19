package _27383.Q4;

public class Organization extends Entity {
    private final String orgName;
    private final String address;
    private final String contactEmail;

    public Organization(int id, String orgName, String address, String contactEmail) throws ValidationException {
        super(id);
        if (!contactEmail.contains("@")) throw new ValidationException("Invalid email format");
        this.orgName = orgName;
        this.address = address;
        this.contactEmail = contactEmail;
    }

    public String getOrgName() { return orgName; }
    public String getAddress() { return address; }
    public String getContactEmail() { return contactEmail; }
}
