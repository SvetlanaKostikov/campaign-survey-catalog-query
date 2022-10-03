package com.crowdsourcing.campaign.survey.catalog.query.administrator;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
public class SurveyCatalogContentQueryResult {
    List<SurveyCatalogContentQueryResultRow> surveyPassports;

    public SurveyCatalogContentQueryResult(List<SurveyCatalogContentQueryResultRow> rows) {
        surveyPassports = new ArrayList<>();
        for(SurveyCatalogContentQueryResultRow row:rows) {
            surveyPassports.add(row);
        }
    }
}
