package com.crowdsourcing.campaign.survey.catalog.actualization.access;

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
@Table(name = "user_access")
public class UserAccess {

    @Id
    @Column(name = "id")
    String id;

    @Column(name = "campaign_id")
    String campaignId;

    @Column(name = "role")
    String role;
}
