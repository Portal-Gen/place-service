package portalgen.placeservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portalgen.placeservice.entity.PlaceEntity;
import portalgen.placeservice.entity.WorldCityEntity;
import portalgen.placeservice.exception.BadRequestError;
import portalgen.placeservice.exception.ResponseException;
import portalgen.placeservice.mapper.PlaceMapper;
import portalgen.placeservice.model.enums.PriceLevel;
import portalgen.placeservice.model.request.PlaceRequest;
import portalgen.placeservice.model.request.UpdatePlaceRequest;
import portalgen.placeservice.model.response.PlaceResponse;
import portalgen.placeservice.service.PlaceRepoService;
import portalgen.placeservice.service.PlaceService;
import portalgen.placeservice.service.WorldCityRepoService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaceServiceImpl implements PlaceService {
    private final PlaceRepoService placeRepoService;
    private final WorldCityRepoService worldCityRepoService;
    private final PlaceMapper mapper;

    @Autowired
    public PlaceServiceImpl(PlaceRepoService placeRepoService, WorldCityRepoService worldCityRepoService, PlaceMapper mapper) {
        this.placeRepoService = placeRepoService;
        this.worldCityRepoService = worldCityRepoService;
        this.mapper = mapper;
    }


    @Override
    public PlaceResponse createPlace(PlaceRequest placeRequest) {
        handleCreateRequest(placeRequest);
        WorldCityEntity worldCityEntity = worldCityRepoService.findById(placeRequest.getWorldCityId());
        PlaceEntity placeEntity = mapper.toEntity(placeRequest, worldCityEntity);
        placeEntity.setCreatedAt(LocalDateTime.now());
        placeEntity.setUpdatedAt(LocalDateTime.now());
        placeRepoService.save(placeEntity);
        return mapper.toResponse(placeEntity);
    }

    @Override
    public PlaceResponse getPlace(Long placeId) {
        PlaceEntity placeEntity = placeRepoService.findById(placeId);

        return mapper.toResponse(placeEntity);
    }

    @Override
    public PlaceResponse getPlaceByGooglePlaceId(String googlePlaceId) {
        PlaceEntity placeEntity = placeRepoService.findByGooglePlaceId(googlePlaceId);

        return mapper.toResponse(placeEntity);
    }

    @Override
    public List<PlaceResponse> getPlaces(List<Long> placeIds) {
        List<PlaceEntity> placeEntities = placeRepoService.findByIds(placeIds);
        return placeEntities.stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public PlaceResponse updatePlace(UpdatePlaceRequest placeRequest) {
        if (placeRequest.getId() == null) {
            throw new ResponseException(BadRequestError.PLACE_ID_CANNOT_BE_BLANK);
        }

        PlaceEntity placeEntity = placeRepoService.findById(placeRequest.getId());
        placeEntity = mapper.toEntity(placeEntity, placeRequest);

        placeEntity.setUpdatedAt(LocalDateTime.now());
        placeRepoService.save(placeEntity);

        return mapper.toResponse(placeEntity);
    }

    @Override
    public PlaceResponse deletePlace(Long placeId) {
        return null;
    }


    private void handlePlaceRequest(PlaceRequest placeRequest) {
        if (placeRequest.getDisplayName() == null || placeRequest.getDisplayName().isEmpty()) {
            throw new ResponseException(BadRequestError.PLACE_NAME_INVALID);
        }

        if (placeRequest.getWorldCityId() == null) {
            throw new ResponseException(BadRequestError.PLACE_WORLD_CITY_INVALID);
        }

        if (placeRequest.getGooglePlaceId() == null || placeRequest.getGooglePlaceId().isEmpty()) {
            throw new ResponseException(BadRequestError.PLACE_GOOGLE_PLACE_ID_INVALID);
        }

        if (PriceLevel.valueOf(placeRequest.getPriceLevel()) == PriceLevel.UNKNOWN) {
            throw new ResponseException(BadRequestError.PRICE_LEVEL_INVALID);
        }

        if (placeRequest.getLatitude() > 90 || placeRequest.getLatitude() < -90) {
            throw new ResponseException(BadRequestError.PLACE_LATITUDE_INVALID);
        }

        if (placeRequest.getLongitude() > 180 || placeRequest.getLongitude() < -180) {
            throw new ResponseException(BadRequestError.PLACE_LONGITUDE_INVALID);
        }
    }
    private void handleCreateRequest(PlaceRequest placeRequest) {
        this.handlePlaceRequest(placeRequest);
        if (placeRepoService.existByGooglePlaceId(placeRequest.getGooglePlaceId())) {
            throw new ResponseException(BadRequestError.PLACE_ALREADY_EXISTS);
        }

        if (placeRepoService.existByName(placeRequest.getDisplayName())) {
            throw new ResponseException(BadRequestError.PLACE_NAME_ALREADY_EXISTS);
        }

        if (!worldCityRepoService.existsById(placeRequest.getWorldCityId())) {
            throw new ResponseException(BadRequestError.WORLD_CITY_NOT_FOUND);
        }
    }
}
