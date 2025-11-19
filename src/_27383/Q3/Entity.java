package _27383.Q3;
import java.time.LocalDate;

public class Entity {
    protected int id;
    protected LocalDate createdDate;
    protected LocalDate updatedDate;

    public Entity(int id) throws TaxDataException {
        if (id <= 0) throw new TaxDataException("ID must be greater than 0");
        this.id = id;
        this.createdDate = LocalDate.now();
        this.updatedDate = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }
}
