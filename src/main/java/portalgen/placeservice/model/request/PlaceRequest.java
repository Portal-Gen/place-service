package portalgen.placeservice.model.request;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlaceRequest {
    private String googlePlaceId;
    private String displayName;
    private String formattedAddress;
    private float latitude;
    private float longitude;
    private float rating;
    private int userRatingCount;
    private String priceLevel;
    private Long worldCityId;
    private String websiteUri;
}
