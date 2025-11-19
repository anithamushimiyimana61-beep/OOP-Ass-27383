package _27383.Q3;

public class Taxpayer extends TaxCategory {
    private final String tin;
    private final String taxpayerName;
    private final String address;

    public Taxpayer(int id, String authorityName, String region, String email,
                    String categoryName, double rate, String code,
                    String tin, String taxpayerName, String address) throws TaxDataException {
        super(id, authorityName, region, email, categoryName, rate, code);
        if (tin.length() != 9) throw new TaxDataException("TIN must be 9 digits");
        this.tin = tin;
        this.taxpayerName = taxpayerName;
        this.address = address;
    }

    public String getTin() {
        return tin;
    }

    public String getTaxpayerName() {
        return taxpayerName;
    }

    public String getAddress() {
        return address;
    }
}
