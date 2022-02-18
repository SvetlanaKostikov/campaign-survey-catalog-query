package com.crowdsourcing.campaign.survey.catalog.query.administrator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SurveyCatalogAdministratorQueryService {

    private final SurveyCatalogContentNativeQuery surveyCatalogContentNativeQuery;

    public SurveyCatalogContentQueryResult getSurveyCatalogContent(String userId, String catalogId) {
        List<SurveyCatalogContentQueryResultRow> list = surveyCatalogContentNativeQuery.getSurveyCatalogContent(userId,catalogId);
        return new SurveyCatalogContentQueryResult(list);
    }

    public SurveyPassportQueryResult getSurveyPassport(String userId, String catalogId, String surveyId) {
        return surveyCatalogContentNativeQuery.getSurveyPassport(userId, catalogId, surveyId);
    }
}
