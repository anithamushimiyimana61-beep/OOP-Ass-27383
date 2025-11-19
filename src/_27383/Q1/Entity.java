package _27383.Q1;

import java.time.LocalDate;

public class Entity {
    private int id;
    private LocalDate createdDate;
    private LocalDate updatedDate;

    public Entity(int id, LocalDate createdDate, LocalDate updatedDate) {
        if (id <= 0) throw new ValidationException("id must be > 0");
        if (createdDate == null || updatedDate == null)
            throw new ValidationException("dates must not be null");
        this.id = id;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public int getId() { return id; }
    public LocalDate getCreatedDate() { return createdDate; }
    public LocalDate getUpdatedDate() { return updatedDate; }

    public void setUpdatedDate(LocalDate updatedDate) {
        if (updatedDate == null) throw new ValidationException("updatedDate must not be null");
        this.updatedDate = updatedDate;
    }
}

