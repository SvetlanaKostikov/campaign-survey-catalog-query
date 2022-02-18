package com.crowdsourcing.campaign.survey.catalog.actualization.passport.survey;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyPassportRepository extends JpaRepository <SurveyPassport, String> {

}
