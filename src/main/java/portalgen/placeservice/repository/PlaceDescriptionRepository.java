package portalgen.placeservice.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portalgen.placeservice.entity.PlaceDescriptionEntity;
import portalgen.placeservice.entity.PlaceEntity;

import java.util.List;

@Repository
public interface PlaceDescriptionRepository extends JpaRepository<PlaceDescriptionEntity, Long> {
    List<PlaceDescriptionEntity> findByPlaceId(Long placeId);

    void deleteById (@NonNull Long id);
}
