package portalgen.placeservice.exception;

import jakarta.servlet.http.HttpServletResponse;
import portalgen.placeservice.model.enums.PlaceType;

import java.util.Arrays;

public enum BadRequestError implements ResponseError {
    UNKNOWN(0, "Unknown error"),
    BAD_REQUEST_ERROR(100, "Bad request error"),
    USER_PROFILE_NOT_FOUND(101, "User profile not found"),
    //TODO: handle invalid place type error
    PLACE_ALREADY_EXISTS(150, "Place already exists"),
    WORLD_CITY_NOT_FOUND(151, "World city not found"),
    PLACE_NOT_FOUND(152, "Place not found"),
    PLACE_NAME_INVALID(153, "Place name is invalid"),
    PLACE_LATITUDE_INVALID(154, "Place latitude is ranged from -90 to 90"),
    PLACE_LONGITUDE_INVALID(155, "Place longitude is ranged from -180 to 180"),
    PLACE_WORLD_CITY_INVALID(156, "Place world city is invalid"),
    PLACE_GOOGLE_PLACE_ID_INVALID(157, "Place google place id is invalid"),
    PLACE_NAME_ALREADY_EXISTS(158, "Place name already exists"),
    ;


    private final int errorCode;
    private final String message;

    BadRequestError(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getName() {
        return this.name();
    }

    public Integer getCode() {
        return this.errorCode;
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public int getStatus() {
        return HttpServletResponse.SC_BAD_REQUEST;
    }
}