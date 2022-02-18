package com.crowdsourcing.campaign.survey.catalog.actualization.api.web.jwt;

public enum UserClaims {

    SUB("sub");

    private final String name;

    UserClaims(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
