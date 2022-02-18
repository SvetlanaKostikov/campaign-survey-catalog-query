package com.crowdsourcing.campaign.survey.catalog.actualization.api.web.jwt;

public class OperationUnauthorizedException extends Exception {

    public OperationUnauthorizedException(String message) {
        super(message);
    }
}
