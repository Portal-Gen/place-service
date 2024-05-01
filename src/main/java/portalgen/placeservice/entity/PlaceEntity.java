package portalgen.placeservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import portalgen.placeservice.model.enums.PriceLevel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Places")
@Data
public class PlaceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "google_place_id")
    private String googlePlaceId;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "formatted_address")
    private String formattedAddress;

    private float latitude;

    private float longitude;

    @Column(name = "rating")
    private float rating;

    @Column(name = "user_rating_count")
    private int userRatingCount;

    @Column(name = "price_level")
    private PriceLevel priceLevel;

    @ManyToOne
    @JoinColumn(name = "world_city_id")
    private WorldCityEntity worldCity;

    @Column(name = "website_uri")
    private String websiteUri;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
    private List<PlaceOpeningHourEntity> openingHours;

    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
    private List<PlaceDescriptionEntity> descriptions;

    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
    private List<PlaceImageURLEntity> imageUrls;
}
