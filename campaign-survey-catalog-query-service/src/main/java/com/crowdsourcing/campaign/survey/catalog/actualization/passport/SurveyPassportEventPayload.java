package com.crowdsourcing.campaign.survey.catalog.actualization.passport;

import lombok.*;

@Data
public class SurveyPassportEventPayload {

    private String id;
    private String name;
    private String surveyCatalogId;
    private String participantPassportRequirements;

}
