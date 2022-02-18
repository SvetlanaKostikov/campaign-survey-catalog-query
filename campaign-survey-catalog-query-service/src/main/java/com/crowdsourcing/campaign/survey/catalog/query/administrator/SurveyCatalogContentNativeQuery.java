package com.crowdsourcing.campaign.survey.catalog.query.administrator;

import com.crowdsourcing.campaign.survey.catalog.actualization.passport.survey.SurveyPassport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyCatalogContentNativeQuery extends JpaRepository <SurveyPassport, String>{

    @Query (value = "select survey_passport.id, survey_passport.name, survey_passport.status " +
            "from survey_passport join survey_catalog " +
            "on survey_passport.survey_catalog_id = survey_catalog.id and survey_catalog.status !='DELETE' " +
            "join user_access " +
            "on survey_catalog.id = user_access.campaign_id and user_access.id = :userId and user_access.campaign_id = :catalogId and user_access.role = 'ADMIN' ", nativeQuery = true)
    List<SurveyCatalogContentQueryResultRow> getSurveyCatalogContent(@Param("userId") String userId, @Param("catalogId")String catalogId);


    @Query (value = "select survey_passport.name, survey_passport.status, survey_passport.content, " +
            "survey_passport.participant_passport_requirements as participantPassportRequirements " +
            "from survey_passport join survey_catalog " +
            "on survey_passport.survey_catalog_id = survey_catalog.id and survey_catalog.status !='DELETE' "+
            "join user_access "+
            "on survey_catalog.id = user_access.campaign_id and user_access.id = :userId and user_access.campaign_id = :catalogId and user_access.role = 'ADMIN' " +
            "where survey_passport.id = :surveyId", nativeQuery = true)
    SurveyPassportQueryResult getSurveyPassport(@Param("userId") String userId, @Param("catalogId")String catalogId, @Param ("surveyId")String surveyId);
}
