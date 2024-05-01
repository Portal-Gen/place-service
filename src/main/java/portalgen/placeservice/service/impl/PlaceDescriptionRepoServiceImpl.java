package portalgen.placeservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import portalgen.placeservice.entity.PlaceDescriptionEntity;
import portalgen.placeservice.entity.PlaceEntity;
import portalgen.placeservice.exception.BadRequestError;
import portalgen.placeservice.exception.InternalServerError;
import portalgen.placeservice.exception.ResponseException;
import portalgen.placeservice.repository.PlaceDescriptionRepository;
import portalgen.placeservice.repository.PlaceRepository;
import portalgen.placeservice.service.PlaceDescriptionRepoService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlaceDescriptionRepoServiceImpl implements PlaceDescriptionRepoService {
    private final PlaceDescriptionRepository placeDescriptionRepository;

    @Override
    public PlaceDescriptionEntity save(PlaceDescriptionEntity placeDescriptionEntity) {
        return placeDescriptionRepository.save(placeDescriptionEntity);
    }

    @Override
    public PlaceDescriptionEntity findById(Long id) {
        if (id == null) {
          throw new ResponseException(BadRequestError.PLACE_DESCRIPTION_ID_CANNOT_BE_BLANK);
        }

        Optional<PlaceDescriptionEntity> placeDescriptionEntity = placeDescriptionRepository.findById(id);
        if (placeDescriptionEntity.isPresent()) {
            return placeDescriptionEntity.get();
        } else {
            throw new ResponseException(BadRequestError.PLACE_DESCRIPTION_NOT_FOUND);
        }
    }

    @Override
    public boolean existsById(Long id) {
        return placeDescriptionRepository.existsById(id);
    }

    @Override
    public List<PlaceDescriptionEntity> findByPlaceId(Long placeId) {
        return placeDescriptionRepository.findByPlaceId(placeId);
    }

    @Override
    public PlaceDescriptionEntity deleteById(Long id) {
        PlaceDescriptionEntity placeDescriptionEntity = findById(id);
        placeDescriptionRepository.deleteById(id);
        return placeDescriptionEntity;
    }

    @Override
    public List<PlaceDescriptionEntity> deleteAllByPlaceId(Long placeId) {
        List<PlaceDescriptionEntity> placeDescriptionEntities = findByPlaceId(placeId);

        try {
            for (PlaceDescriptionEntity placeDescriptionEntity : placeDescriptionEntities) {
                placeDescriptionRepository.deleteById(placeDescriptionEntity.getId());
            }
        } catch (Exception e) {
            throw new ResponseException(InternalServerError.INTERNAL_SERVER_ERROR);
        }

        return placeDescriptionEntities;
    }
}
