package portalgen.placeservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "PlaceImageURLs")
@Data
public class PlaceImageURLEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private PlaceEntity place;

    @Column(name = "image_url")
    private String imageUrl;
}
