package _27383.Q5;

public class Institution extends Entity {
    private final String institutionName;
    private final String code;
    private final String address;

    public Institution(int id, String institutionName, String code, String address) throws ValidationException {
        super(id);
        if (code.length() < 3) throw new ValidationException("Institution code must be ≥ 3 chars");
        this.institutionName = institutionName;
        this.code = code;
        this.address = address;
    }

    public String getInstitutionName() { return institutionName; }
    public String getCode() { return code; }
    public String getAddress() { return address; }
}
