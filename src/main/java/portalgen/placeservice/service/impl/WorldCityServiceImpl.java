package portalgen.placeservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import portalgen.placeservice.entity.WorldCityEntity;
import portalgen.placeservice.model.request.SearchWorldCityRequest;
import portalgen.placeservice.service.WorldCityRepoService;
import portalgen.placeservice.service.WorldCityService;

@Service
@RequiredArgsConstructor
public class WorldCityServiceImpl implements WorldCityService {
    private final WorldCityRepoService worldCityRepoService;

    @Override
    public WorldCityEntity searchWorldCity(SearchWorldCityRequest searchWorldCityRequest) {
        return worldCityRepoService.findIdByCityNameAndCountryName(searchWorldCityRequest);
    }
}
