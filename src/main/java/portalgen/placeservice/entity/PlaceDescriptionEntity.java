package portalgen.placeservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "PlaceDescriptions")
@Data
public class PlaceDescriptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private PlaceEntity place;

    @Column(columnDefinition = "TEXT")
    private String description;
}