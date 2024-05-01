package portalgen.placeservice.service;

import portalgen.placeservice.model.request.PlaceRequest;
import portalgen.placeservice.model.request.UpdatePlaceRequest;
import portalgen.placeservice.model.response.PlaceResponse;

public interface PlaceService {
    PlaceResponse createPlace(PlaceRequest placeRequest);
    PlaceResponse getPlace(Long placeId);
    PlaceResponse updatePlace(UpdatePlaceRequest placeRequest);
    PlaceResponse deletePlace(Long placeId);
}
