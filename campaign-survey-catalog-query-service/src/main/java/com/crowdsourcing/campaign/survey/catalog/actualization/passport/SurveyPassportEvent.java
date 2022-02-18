package com.crowdsourcing.campaign.survey.catalog.actualization.passport;

import com.crowdsourcing.campaign.survey.catalog.actualization.EventEnvelope;
import com.crowdsourcing.campaign.survey.catalog.actualization.PassportEventType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class SurveyPassportEvent extends EventEnvelope<SurveyPassportEventPayload> implements Serializable {

    public PassportEventType extractEventType() {
        return PassportEventType.valueOf(getEventType());
    }

}
