package com.crowdsourcing.campaign.survey.catalog.actualization.api.web.jwt;

public class InvalidTokenException extends RuntimeException{

    public InvalidTokenException(String message){
        super(message);
    }
}
