package com.crowdsourcing.campaign.survey.catalog.actualization.passport.survey;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "survey_passport")
public class SurveyPassport {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "content")
    private String content;

    @Column(name = "status")
    private String status;

    @Column(name = "participant_passport_requirements")
    private String participantPassportRequirements;

    @Column(name = "survey_catalog_id")
    private String surveyCatalogId;

}
