package portalgen.placeservice.service;

import portalgen.placeservice.entity.PlaceDescriptionEntity;

import java.util.List;

public interface PlaceDescriptionRepoService {
    PlaceDescriptionEntity save(PlaceDescriptionEntity placeDescriptionEntity);

    PlaceDescriptionEntity findById(Long id);

    boolean existsById(Long id);

    List<PlaceDescriptionEntity> findByPlaceId(Long placeId);

    PlaceDescriptionEntity deleteById(Long id);

    List<PlaceDescriptionEntity> deleteAllByPlaceId(Long placeId);
}
