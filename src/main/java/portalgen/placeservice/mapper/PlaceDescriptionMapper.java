package portalgen.placeservice.mapper;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import portalgen.placeservice.entity.PlaceDescriptionEntity;
import portalgen.placeservice.entity.PlaceEntity;
import portalgen.placeservice.model.request.PlaceDescriptionRequest;
import portalgen.placeservice.model.response.PlaceDescriptionResponse;

@Component
@NoArgsConstructor
public class PlaceDescriptionMapper {

    public PlaceDescriptionEntity toEntity(PlaceDescriptionRequest placeDescriptionRequest, PlaceEntity placeEntity) {
        PlaceDescriptionEntity entity = new PlaceDescriptionEntity();
        entity.setPlace(placeEntity);
        entity.setDescription(placeDescriptionRequest.getDescription());

        return entity;
    }

    public PlaceDescriptionResponse toResponse(PlaceDescriptionEntity placeDescriptionEntity) {
        PlaceDescriptionResponse response = new PlaceDescriptionResponse();
        response.setId(placeDescriptionEntity.getId());
        response.setDisplayName(placeDescriptionEntity.getPlace().getDisplayName());
        response.setCity(placeDescriptionEntity.getPlace().getWorldCity().getCity());
        response.setCountry(placeDescriptionEntity.getPlace().getWorldCity().getCountry());
        response.setDescription(placeDescriptionEntity.getDescription());

        return response;
    }
}
