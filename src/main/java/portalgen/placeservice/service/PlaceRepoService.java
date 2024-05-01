package portalgen.placeservice.service;

import portalgen.placeservice.entity.PlaceEntity;

public interface PlaceRepoService {
    PlaceEntity save(PlaceEntity placeEntity);

    PlaceEntity findById(Long id);

    PlaceEntity findByGooglePlaceId(String googlePlaceId);

    boolean existByGooglePlaceId(String googlePlaceId);

    boolean existByName(String name);
}
