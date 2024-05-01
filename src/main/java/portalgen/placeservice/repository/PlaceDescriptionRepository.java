package portalgen.placeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portalgen.placeservice.entity.PlaceDescriptionEntity;

@Repository
public interface PlaceDescriptionRepository extends JpaRepository<PlaceDescriptionEntity, Long> {

}
