package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "planet")
@Entity
@Data
public class Planet {
    @Id
    private String id;
    @Column
    private String name;

    public Planet() {
    }

    public Planet(String planeId, String planetName) {
        this.id = planeId;
        this.name = planetName;
    }
}
