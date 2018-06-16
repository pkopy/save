package pl.pkopy.save.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "city")
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "id_city")
    private Long idCity;
    private String name;
    private String country;

}
