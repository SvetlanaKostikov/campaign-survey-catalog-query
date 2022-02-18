package com.crowdsourcing.campaign.survey.catalog.actualization.api.web;

import com.crowdsourcing.campaign.survey.catalog.actualization.api.web.jwt.RegisteredUser;
import com.crowdsourcing.campaign.survey.catalog.actualization.api.web.jwt.UserOperations;
import com.crowdsourcing.campaign.survey.catalog.actualization.passport.survey.SurveyPassport;
import com.crowdsourcing.campaign.survey.catalog.actualization.passport.survey.SurveyPassportRepository;
import com.crowdsourcing.campaign.survey.catalog.query.administrator.SurveyCatalogContentQueryResult;
import com.crowdsourcing.campaign.survey.catalog.query.administrator.SurveyCatalogAdministratorQueryService;
import com.crowdsourcing.campaign.survey.catalog.query.administrator.SurveyPassportQueryResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor
@RequestMapping("/v1.0/query")
@Api("Справочник опроса")
public class SurveyCatalogAdministratorController {

    private final SurveyCatalogAdministratorQueryService surveyCatalogAdministratorQueryService;
    private final UserOperations userOperations;

    @GetMapping("/catalog/{catalogId}/content")
    @ApiOperation("Получение списка краткого описания опросов, доступных пользователю")
    public ResponseEntity<SurveyCatalogContentQueryResult> getSurveyCatalogContent(
            @RequestHeader("Authorization") String token,
            @PathVariable ("catalogId")String catalogId) {
        if(catalogId == null || catalogId.isBlank()) {
            throw new IllegalArgumentException("Не указан идентификатор кампании");
        }
        RegisteredUser user = userOperations.createFrom(token);
        return ResponseEntity.ok(surveyCatalogAdministratorQueryService.getSurveyCatalogContent(user.getId(), catalogId));
    }

    @GetMapping("/catalog/{catalogId}/survey/{surveyId}/passport")
    @ApiOperation("Получение полного описания опроса")
    public ResponseEntity<SurveyPassportQueryResult> getSurveyPassport(
            @RequestHeader("Authorization") String token,
            @PathVariable ("catalogId")String catalogId,
            @PathVariable ("surveyId")String surveyId) {

        if(catalogId == null || catalogId.isBlank()) {
            throw new IllegalArgumentException("Не указан идентификатор кампании");
        }
        if(surveyId == null || surveyId.isBlank()) {
            throw new IllegalArgumentException("Не указан идентификатор опроса");
        }
        RegisteredUser user = userOperations.createFrom(token);
        return ResponseEntity.ok(surveyCatalogAdministratorQueryService.getSurveyPassport(user.getId(), catalogId, surveyId));

    }


}
