package portalgen.placeservice.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import portalgen.placeservice.entity.PlaceEntity;
import portalgen.placeservice.entity.WorldCityEntity;
import portalgen.placeservice.model.enums.PriceLevel;
import portalgen.placeservice.model.request.PlaceRequest;
import portalgen.placeservice.model.response.PlaceResponse;

@Component
@RequiredArgsConstructor
public class PlaceMapper {
    public PlaceEntity toEntity(PlaceRequest placeRequest, WorldCityEntity worldCityEntity) {
        PlaceEntity entity = new PlaceEntity();
        entity.setGooglePlaceId(placeRequest.getGooglePlaceId());
        entity.setDisplayName(placeRequest.getDisplayName());
        entity.setLatitude(placeRequest.getLatitude());
        entity.setLongitude(placeRequest.getLongitude());
        entity.setFormattedAddress(placeRequest.getFormattedAddress());
        entity.setRating(placeRequest.getRating());
        entity.setUserRatingCount(placeRequest.getUserRatingCount());
        entity.setPriceLevel(PriceLevel.valueOf(placeRequest.getPriceLevel()));
        entity.setWebsiteUri(placeRequest.getWebsiteUri());
        entity.setWorldCity(worldCityEntity);

        return entity;
    }

    public PlaceResponse toResponse(PlaceEntity placeEntity) {
        PlaceResponse response = new PlaceResponse();
        response.setGooglePlaceId(placeEntity.getGooglePlaceId());
        response.setDisplayName(placeEntity.getDisplayName());
        response.setLatitude(placeEntity.getLatitude());
        response.setLongitude(placeEntity.getLongitude());
        response.setFormattedAddress(placeEntity.getFormattedAddress());
        response.setRating(placeEntity.getRating());
        response.setUserRatingCount(placeEntity.getUserRatingCount());
        response.setPriceLevel(placeEntity.getPriceLevel().getValue());
        response.setWebsiteUri(placeEntity.getWebsiteUri());
        response.setCityName(placeEntity.getWorldCity().getCity());

        return response;
    }
}
