package portalgen.placeservice.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import portalgen.placeservice.entity.PlaceEntity;
import portalgen.placeservice.entity.WorldCityEntity;
import portalgen.placeservice.model.enums.PriceLevel;
import portalgen.placeservice.model.request.PlaceRequest;
import portalgen.placeservice.model.request.UpdatePlaceRequest;
import portalgen.placeservice.model.response.PlaceResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        response.setCreatedAt(String.valueOf(placeEntity.getCreatedAt()));
        response.setUpdatedAt(String.valueOf(placeEntity.getUpdatedAt()));

        return response;
    }

    public PlaceEntity toEntity(PlaceEntity originalEntity, UpdatePlaceRequest request) {
        if (request.getGooglePlaceId() != null) {
            originalEntity.setGooglePlaceId(request.getGooglePlaceId());
        }
        if (request.getDisplayName() != null) {
            originalEntity.setDisplayName(request.getDisplayName());
        }

        originalEntity.setLatitude(request.getLatitude());

        originalEntity.setLongitude(request.getLongitude());

        if (request.getFormattedAddress() != null) {
            originalEntity.setFormattedAddress(request.getFormattedAddress());
        }

        originalEntity.setRating(request.getRating());

        originalEntity.setUserRatingCount(request.getUserRatingCount());

        originalEntity.setPriceLevel(PriceLevel.valueOf(request.getPriceLevel()));

        if (request.getWebsiteUri() != null) {
            originalEntity.setWebsiteUri(request.getWebsiteUri());
        }

        return originalEntity;
    }
}
