package com.crowdsourcing.campaign.survey.catalog.actualization.api.events;

import com.crowdsourcing.campaign.survey.catalog.actualization.PassportEventType;
import com.crowdsourcing.campaign.survey.catalog.actualization.passport.SurveyPassportActualizationService;
import com.crowdsourcing.campaign.survey.catalog.actualization.passport.SurveyPassportEvent;
import com.crowdsourcing.campaign.survey.catalog.actualization.passport.SurveyPassportEventPayload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@EnableKafka
@RequiredArgsConstructor
@Slf4j
public class SurveyPassportEventConsumer {

    private final SurveyPassportActualizationService surveyPassportActualizationService;

    public static final String TOPIC_NAME = "survey_passport";

    @KafkaListener(topics = TOPIC_NAME)
    public void surveyPassportEventListener(SurveyPassportEvent event) {
        log.info("Получено событие: '{}'", event);

        try {
            SurveyPassportEventPayload payload = event.getEventPayload();
            String id = payload.getId();
            String name = payload.getName();
            String participantPassportRequirements = payload.getParticipantPassportRequirements();
            String surveyCatalogId = payload.getSurveyCatalogId();
            PassportEventType type = event.extractEventType();

            switch (type) {
                case SURVEY_PASSPORT_CREATED: {
                    surveyPassportActualizationService.addNewSurveyPassport(id, name, participantPassportRequirements, surveyCatalogId);
                    break;
                }
                case SURVEY_PASSPORT_MODIFIED: {
                    surveyPassportActualizationService.modifySurveyPassport(id, name, participantPassportRequirements, surveyCatalogId);
                    break;
                }
                case SURVEY_PASSPORT_DELETED: {
                    surveyPassportActualizationService.deleteSurveyPassport(id);
                    break;
                }

            }

            log.info("Событие успешно обработано: '{}'", event);
        } catch (Exception e) {
            log.error("Ошибка обработки события - {}", event, e);
        }
    }

}
