package com.crowdsourcing.campaign.survey.catalog.actualization.catalog;

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
@Table(name = "campaign")
public class SurveyCatalog {

    @Id
    @Column(name = "id")
    String id;

    @Column(name = "status")
    String status;

    @Column(name = "description")
    String description;

    public boolean isActive() {
        return status.equals("ACTIVE");
    }
}
