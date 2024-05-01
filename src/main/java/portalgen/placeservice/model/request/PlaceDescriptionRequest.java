package portalgen.placeservice.model.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlaceDescriptionRequest {
    private Long placeId;
    private String description;
}
