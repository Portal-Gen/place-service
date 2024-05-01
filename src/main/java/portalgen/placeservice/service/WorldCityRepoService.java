package portalgen.placeservice.service;

import portalgen.placeservice.entity.WorldCityEntity;

public interface WorldCityRepoService {
    WorldCityEntity save(WorldCityEntity worldCityEntity);

    WorldCityEntity findById(Long id);

    boolean existsById(Long id);
}
