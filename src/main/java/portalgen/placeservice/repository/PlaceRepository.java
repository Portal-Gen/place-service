package portalgen.placeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portalgen.placeservice.entity.PlaceEntity;

@Repository
public interface PlaceRepository extends JpaRepository<PlaceEntity, Long>{
    PlaceEntity findPlaceEntityByGooglePlaceId(String googlePlaceId);

    boolean existsByGooglePlaceId(String googlePlaceId);

    boolean existsByDisplayName(String name);
}
