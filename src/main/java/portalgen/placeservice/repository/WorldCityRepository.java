package portalgen.placeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portalgen.placeservice.entity.WorldCityEntity;

import java.util.List;

@Repository
public interface WorldCityRepository extends JpaRepository<WorldCityEntity, Long> {
    WorldCityEntity findWorldCityEntityById(Long id);
}
