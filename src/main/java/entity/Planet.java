package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import javax.validation.constraints.Pattern;

@Table(name = "planet")
@Entity
@Data
public class Planet {
    @Id
    @Pattern(regexp="[A-Z0-9]")
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
