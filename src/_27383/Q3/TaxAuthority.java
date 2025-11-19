package _27383.Q3;

public class TaxAuthority extends Entity {
    private final String authorityName;
    private final String region;
    private final String email;

    public TaxAuthority(int id, String authorityName, String region, String email) throws TaxDataException {
        super(id);
        if (!email.contains("@")) throw new TaxDataException("Invalid email format");
        this.authorityName = authorityName;
        this.region = region;
        this.email = email;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public String getRegion() {
        return region;
    }

    public String getEmail() {
        return email;
    }
}
