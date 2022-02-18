package com.crowdsourcing.campaign.survey.catalog.actualization.passport;

import com.crowdsourcing.campaign.survey.catalog.actualization.passport.survey.SurveyPassport;
import com.crowdsourcing.campaign.survey.catalog.actualization.passport.survey.SurveyPassportActualizer;
import com.crowdsourcing.campaign.survey.catalog.actualization.passport.survey.SurveyPassportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class SurveyPassportActualizationService {

    private final SurveyPassportActualizer surveyPassportActualizer;


    public void addNewSurveyPassport(String id, String name, String participantPassportRequirements, String surveyCatalogId) {
        surveyPassportActualizer.addNewSurveyPassport(id, name, participantPassportRequirements, surveyCatalogId);
        }


    public void modifySurveyPassport(String id, String name, String participantPassportRequirements, String surveyCatalogId) {
        surveyPassportActualizer.modifySurveyPassport(id, name, participantPassportRequirements, surveyCatalogId);

    }

    public void deleteSurveyPassport(String id) {
        surveyPassportActualizer.deleteSurveyPassportById(id);
    }
}
