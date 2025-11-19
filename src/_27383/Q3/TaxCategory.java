package _27383.Q3;

public class TaxCategory extends TaxAuthority {
    private final String categoryName;
    private final double rate;
    private final String code;

    public TaxCategory(int id, String authorityName, String region, String email,
                       String categoryName, double rate, String code) throws TaxDataException {
        super(id, authorityName, region, email);
        if (rate <= 0) throw new TaxDataException("Rate must be > 0");
        if (code.length() < 3) throw new TaxDataException("Code must be at least 3 characters");
        this.categoryName = categoryName;
        this.rate = rate;
        this.code = code;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public double getRate() {
        return rate;
    }

    public String getCode() {
        return code;
    }
}
