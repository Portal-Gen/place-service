package portalgen.placeservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "WorldCities")
@Data
public class WorldCityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String city;

    private String country;

    private String cityType;

    private String iso2;

    private String iso3;
}
