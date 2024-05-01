package portalgen.placeservice.model.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePlaceRequest extends PlaceRequest {
    private Long id;
}
