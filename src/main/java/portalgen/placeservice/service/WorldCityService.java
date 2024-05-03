package portalgen.placeservice.service;

import portalgen.placeservice.entity.WorldCityEntity;
import portalgen.placeservice.model.request.SearchWorldCityRequest;

public interface WorldCityService {
    WorldCityEntity searchWorldCity(SearchWorldCityRequest searchWorldCityRequest);
}
