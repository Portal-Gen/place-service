package portalgen.placeservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import portalgen.placeservice.entity.PlaceEntity;
import portalgen.placeservice.exception.BadRequestError;
import portalgen.placeservice.exception.ResponseException;
import portalgen.placeservice.repository.PlaceRepository;
import portalgen.placeservice.service.PlaceRepoService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlaceRepoServiceImpl implements PlaceRepoService {

    private final PlaceRepository placeRepository;

    @Override
    public PlaceEntity save(PlaceEntity placeEntity) {
        return placeRepository.save(placeEntity);
    }

    @Override
    public PlaceEntity findById(Long id) {
        if (id == null) {
            throw new ResponseException(BadRequestError.PLACE_NOT_FOUND);
        }

        Optional<PlaceEntity> placeEntity = placeRepository.findById(id);
        if (placeEntity.isPresent()) {
            return placeEntity.get();
        } else {
            throw new ResponseException(BadRequestError.PLACE_NOT_FOUND);
        }
    }

    @Override
    public List<PlaceEntity> findByIds(List<Long> ids) {
        Optional<List<PlaceEntity>> placeEntities = Optional.of(placeRepository.findAllById(ids));
        if (placeEntities.isPresent()) {
            return placeEntities.get();
        } else {
            throw new ResponseException(BadRequestError.PLACE_NOT_FOUND);
        }
    }

    @Override
    public PlaceEntity findByGooglePlaceId(String googlePlaceId) {
        Optional<PlaceEntity> placeEntity = Optional.ofNullable(placeRepository.findPlaceEntityByGooglePlaceId(googlePlaceId));
        if (placeEntity.isPresent()) {
            return placeEntity.get();
        } else {
            throw new ResponseException(BadRequestError.PLACE_NOT_FOUND);
        }
    }

    @Override
    public boolean existByGooglePlaceId(String googlePlaceId) {
        return placeRepository.existsByGooglePlaceId(googlePlaceId);
    }

    @Override
    public boolean existByName(String name) {
        return placeRepository.existsByDisplayName(name);
    }
}
