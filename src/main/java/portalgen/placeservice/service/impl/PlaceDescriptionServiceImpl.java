package portalgen.placeservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portalgen.placeservice.entity.PlaceDescriptionEntity;
import portalgen.placeservice.entity.PlaceEntity;
import portalgen.placeservice.exception.BadRequestError;
import portalgen.placeservice.exception.ResponseException;
import portalgen.placeservice.mapper.PlaceDescriptionMapper;
import portalgen.placeservice.model.request.PlaceDescriptionRequest;
import portalgen.placeservice.model.request.UpdatePlaceDescriptionRequest;
import portalgen.placeservice.model.response.PlaceDescriptionResponse;
import portalgen.placeservice.service.PlaceDescriptionRepoService;
import portalgen.placeservice.service.PlaceDescriptionService;
import portalgen.placeservice.service.PlaceRepoService;

import java.util.List;

@Service
public class PlaceDescriptionServiceImpl implements PlaceDescriptionService {
    private final PlaceDescriptionRepoService placeDescriptionRepoService;
    private final PlaceRepoService placeRepoService;
    private final PlaceDescriptionMapper mapper;

    @Autowired
    public PlaceDescriptionServiceImpl(PlaceDescriptionRepoService placeDescriptionRepoService, PlaceRepoService placeRepoService, PlaceDescriptionMapper mapper) {
        this.placeDescriptionRepoService = placeDescriptionRepoService;
        this.placeRepoService = placeRepoService;
        this.mapper = mapper;
    }

    @Override
    public PlaceDescriptionResponse createPlaceDescription(PlaceDescriptionRequest placeDescriptionRequest) {
        handlePlaceDescriptionRequest(placeDescriptionRequest);
        PlaceEntity placeEntity = placeRepoService.findById(placeDescriptionRequest.getPlaceId());
        PlaceDescriptionEntity placeDescriptionEntity = mapper.toEntity(placeDescriptionRequest, placeEntity);

        placeDescriptionRepoService.save(placeDescriptionEntity);

        return mapper.toResponse(placeDescriptionEntity);
    }

    @Override
    public PlaceDescriptionResponse getPlaceDescription(Long placeDescriptionId) {
        if (placeDescriptionId == null) {
            throw new ResponseException(BadRequestError.PLACE_DESCRIPTION_ID_CANNOT_BE_BLANK);
        }

        PlaceDescriptionEntity placeDescriptionEntity = placeDescriptionRepoService.findById(placeDescriptionId);

        return mapper.toResponse(placeDescriptionEntity);
    }

    @Override
    public List<PlaceDescriptionResponse> getPlaceDescriptions(Long placeId) {
        if (placeId == null) {
            throw new ResponseException(BadRequestError.PLACE_ID_CANNOT_BE_BLANK);
        }

        List<PlaceDescriptionEntity> placeDescriptionEntities = placeDescriptionRepoService.findByPlaceId(placeId);

        return placeDescriptionEntities.stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public PlaceDescriptionResponse updatePlaceDescription(UpdatePlaceDescriptionRequest placeDescriptionRequest) {
        if (placeDescriptionRequest.getId() == null) {
            throw new ResponseException(BadRequestError.PLACE_DESCRIPTION_ID_CANNOT_BE_BLANK);
        }

        PlaceDescriptionEntity placeDescriptionEntity = placeDescriptionRepoService.findById(placeDescriptionRequest.getId());
        placeDescriptionEntity.setDescription(placeDescriptionRequest.getDescription());

        placeDescriptionRepoService.save(placeDescriptionEntity);

        return mapper.toResponse(placeDescriptionEntity);
    }

    @Override
    public PlaceDescriptionResponse deletePlaceDescription(Long placeDescriptionId) {
        if (placeDescriptionId == null) {
            throw new ResponseException(BadRequestError.PLACE_DESCRIPTION_ID_CANNOT_BE_BLANK);
        }

        PlaceDescriptionEntity placeDescriptionEntity = placeDescriptionRepoService.deleteById(placeDescriptionId);

        return mapper.toResponse(placeDescriptionEntity);
    }

    @Override
    public List<PlaceDescriptionResponse> deletePlaceDescriptions(Long placeId) {
        if (placeId == null) {
            throw new ResponseException(BadRequestError.PLACE_ID_CANNOT_BE_BLANK);
        }

        List<PlaceDescriptionEntity> placeDescriptionEntities = placeDescriptionRepoService.deleteAllByPlaceId(placeId);

        if (placeDescriptionEntities.isEmpty()) {
            throw new ResponseException(BadRequestError.PLACE_NOT_FOUND);
        }

        return placeDescriptionEntities.stream()
                .map(mapper::toResponse)
                .toList();
    }


    private void handlePlaceDescriptionRequest(PlaceDescriptionRequest placeDescriptionRequest) {
        if (placeDescriptionRequest.getPlaceId() == null || placeDescriptionRequest.getPlaceId() == 0){
            throw new ResponseException(BadRequestError.PLACE_ID_CANNOT_BE_BLANK);
        }
        if (placeDescriptionRequest.getDescription() == null || placeDescriptionRequest.getDescription().isBlank()) {
            throw new ResponseException(BadRequestError.PLACE_DESCRIPTION_CANNOT_BE_BLANK);
        }
        if (placeDescriptionRequest.getDescription().length() > 500) {
            throw new ResponseException(BadRequestError.PLACE_DESCRIPTION_TOO_LONG);
        }
    }

}
