package portalgen.placeservice.model.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchWorldCityRequest {
    private String city;
    private String country;
}