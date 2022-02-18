package com.crowdsourcing.campaign.survey.catalog.query.administrator;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
public class SurveyCatalogContentQueryResult {
    List<SurveyCatalogContentQueryResultRow> survey_passports;

    public SurveyCatalogContentQueryResult(List<SurveyCatalogContentQueryResultRow> rows) {
        survey_passports = new ArrayList<>();
        for(SurveyCatalogContentQueryResultRow row:rows) {
            survey_passports.add(row);
        }
    }
}
