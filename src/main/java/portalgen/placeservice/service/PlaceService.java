package portalgen.placeservice.service;

import portalgen.placeservice.model.request.PlaceRequest;
import portalgen.placeservice.model.request.UpdatePlaceRequest;
import portalgen.placeservice.model.response.PlaceResponse;

import java.util.List;

public interface PlaceService {
    PlaceResponse createPlace(PlaceRequest placeRequest);

    PlaceResponse getPlace(Long placeId);

    PlaceResponse getPlaceByGooglePlaceId(String googlePlaceId);

    List<PlaceResponse> getPlaces(List<Long> placeIds);

    PlaceResponse updatePlace(UpdatePlaceRequest placeRequest);

    PlaceResponse deletePlace(Long placeId);
}
