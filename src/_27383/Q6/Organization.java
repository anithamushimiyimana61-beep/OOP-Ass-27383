package _27383.Q6;

public class Organization extends Entity {
    private final String orgName;
    private final String orgCode;
    private final String rssbNumber;
    private final String contactEmail;

    public Organization(int id, String orgName, String orgCode, String rssbNumber, String contactEmail) throws ValidationException {
        super(id);
        if (orgCode.length() < 3) throw new ValidationException("Org code must be ≥ 3 chars");
        if (rssbNumber.length() != 8) throw new ValidationException("RSSB number must be 8 digits");
        if (!contactEmail.contains("@")) throw new ValidationException("Invalid email format");
        this.orgName = orgName;
        this.orgCode = orgCode;
        this.rssbNumber = rssbNumber;
        this.contactEmail = contactEmail;
    }

    public String getOrgName() { return orgName; }
    public String getOrgCode() { return orgCode; }
    public String getRssbNumber() { return rssbNumber; }
    public String getContactEmail() { return contactEmail; }
}
