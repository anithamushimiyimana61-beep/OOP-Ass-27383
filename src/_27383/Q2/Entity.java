package _27383.Q2;
import java.time.LocalDate;
public class Entity {
    public int id;
    private final LocalDate createdDate;
    private final LocalDate updatedDate;

    public Entity(int id, LocalDate createdDate, LocalDate updatedDate) {
        if (id <= 0) throw new ValidationException("ID must be > 0");
        if (createdDate == null || updatedDate == null)
            throw new ValidationException("Dates must not be null");

        this.id = id;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public int getId() { return id; }
    public LocalDate getCreatedDate() { return createdDate; }
    public LocalDate getUpdatedDate() { return updatedDate; }
}
