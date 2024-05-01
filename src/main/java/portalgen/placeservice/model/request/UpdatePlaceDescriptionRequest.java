package portalgen.placeservice.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePlaceDescriptionRequest extends PlaceDescriptionRequest {
    private Long id;
}
