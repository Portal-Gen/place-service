package portalgen.placeservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "PlaceOpeningHours")
@Data
public class PlaceOpeningHourEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private PlaceEntity place;

    private boolean day;

    private short open;

    private short close;
}