package portalgen.placeservice.service;

import portalgen.placeservice.model.request.PlaceDescriptionRequest;
import portalgen.placeservice.model.request.UpdatePlaceDescriptionRequest;
import portalgen.placeservice.model.response.PlaceDescriptionResponse;

import java.util.List;

public interface PlaceDescriptionService {
    PlaceDescriptionResponse createPlaceDescription(PlaceDescriptionRequest placeDescriptionRequest);

    PlaceDescriptionResponse getPlaceDescription(Long placeDescriptionId);

    List<PlaceDescriptionResponse> getPlaceDescriptions(Long placeId);

    PlaceDescriptionResponse updatePlaceDescription(UpdatePlaceDescriptionRequest placeDescriptionRequest);

    PlaceDescriptionResponse deletePlaceDescription(Long placeDescriptionId);

    List<PlaceDescriptionResponse> deletePlaceDescriptions(Long placeId);
}
