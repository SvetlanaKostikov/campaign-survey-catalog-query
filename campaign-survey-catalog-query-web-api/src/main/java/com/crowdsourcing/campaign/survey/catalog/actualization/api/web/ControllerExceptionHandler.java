package com.crowdsourcing.campaign.survey.catalog.actualization.api.web;


import com.crowdsourcing.campaign.survey.catalog.actualization.api.web.jwt.InvalidTokenException;
import com.crowdsourcing.campaign.survey.catalog.actualization.passport.SurveyPassportNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.w3c.dom.events.EventException;

import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity defaultExceptionHandler(Exception e) {
        return new ResponseEntity<>(getResponseBody(e), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({
            InvalidTokenException.class
    })
    public ResponseEntity<Object> handleJwtException(Exception e) {
        return new ResponseEntity<>(getResponseBody(e), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({
            EventException.class,
            IllegalArgumentException.class,
    })
    public ResponseEntity<Object> handleServiceException(Exception e) {
        return new ResponseEntity<>(getResponseBody(e), HttpStatus.INTERNAL_SERVER_ERROR);
    }

//    @ExceptionHandler({
//            SurveyPassportNotFoundException.class
//    })
//    public ResponseEntity<Object> notFoundExceptionHandler(Exception e) {
//        return new ResponseEntity<>(getResponseBody(e), HttpStatus.NOT_FOUND);
//    }


    private Map<String, Object> getResponseBody(Exception e) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("success", "false");
        body.put("message", e.getMessage());
        return body;
    }

}
