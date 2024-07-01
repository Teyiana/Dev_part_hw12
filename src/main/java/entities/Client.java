package entities;

import jakarta.persistence.*;
import lombok.Data;


@Table(name = "client")
@Entity
@Data
public class Client {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String name;

    public Client(){

    }

    public Client(long id, String name){
        this.id = id;
        this.name = name;
    }


    public Client(String name) {
        this.name = name;
    }

    public Client(long id) {
        this.id = id;
    }
}
