package com.crowdsourcing.campaign.survey.catalog.actualization.passport.survey;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SurveyPassportActualizer {

    private final SurveyPassportRepository surveyPassportRepository;

    public void addNewSurveyPassport(String id, String name, String participantPassportRequirements, String surveyCatalogId) {
        addSurveyPassport(id,name,participantPassportRequirements,surveyCatalogId);
    }

    public void deleteSurveyPassportById(String id) {
        Optional<SurveyPassport> survey = surveyPassportRepository.findById(id);
        if(survey.isPresent()) {
            surveyPassportRepository.deleteById(id);
        }
    }

    public void modifySurveyPassport(String id, String name, String participantPassportRequirements, String surveyCatalogId) {
        Optional<SurveyPassport> surveyPassport = surveyPassportRepository.findById(id);
        if(surveyPassport.isPresent()) {
            SurveyPassport modifyPassport = surveyPassport.get();
            modifyPassport.setName(name);
            modifyPassport.setParticipantPassportRequirements(participantPassportRequirements);
            modifyPassport.setSurveyCatalogId(surveyCatalogId);
            surveyPassportRepository.save(modifyPassport);
        } else {
            addSurveyPassport(id, name, participantPassportRequirements, surveyCatalogId);
        }
    }

    private void addSurveyPassport(String id, String name, String participantPassportRequirements, String surveyCatalogId){
        Optional<SurveyPassport> survey = surveyPassportRepository.findById(id);
        if(!survey.isPresent()) {
            SurveyPassport surveyPassport = SurveyPassport.builder()
                    .id(id)
                    .name(name)
                    .participantPassportRequirements(participantPassportRequirements)
                    .surveyCatalogId(surveyCatalogId)
                    .build();
            SurveyPassport s = surveyPassportRepository.save(surveyPassport);
        }
    }
}
