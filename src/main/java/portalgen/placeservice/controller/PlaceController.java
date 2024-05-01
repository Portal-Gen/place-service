package portalgen.placeservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import portalgen.placeservice.model.request.PlaceRequest;
import portalgen.placeservice.model.response.PlaceResponse;
import portalgen.placeservice.model.response.Response;
import portalgen.placeservice.service.PlaceService;

@RestController
@RequestMapping("/api/v1/place")
@RequiredArgsConstructor
public class PlaceController {
    private final PlaceService placeService;

    @PostMapping
    public Response createPlace(@RequestBody PlaceRequest placeRequest) {
        PlaceResponse placeResponse = placeService.createPlace(placeRequest);
        return new Response(placeResponse);
    }


}
