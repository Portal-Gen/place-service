package portalgen.placeservice.model.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlaceDescriptionGooglePlaceIdRequest {
    private String googlePlaceId;
    private String description;
}
