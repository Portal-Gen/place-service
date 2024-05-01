package portalgen.placeservice.service;

import portalgen.placeservice.entity.PlaceEntity;

import java.util.List;

public interface PlaceRepoService {
    PlaceEntity save(PlaceEntity placeEntity);

    PlaceEntity findById(Long id);

    List<PlaceEntity> findByIds(List<Long> ids);

    PlaceEntity findByGooglePlaceId(String googlePlaceId);

    boolean existByGooglePlaceId(String googlePlaceId);

    boolean existByName(String name);
}
