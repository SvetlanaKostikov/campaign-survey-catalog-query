package com.crowdsourcing.campaign.survey.catalog.query.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableEurekaClient
@EnableJpaRepositories("com.crowdsourcing.campaign.survey.catalog")
@EntityScan("com.crowdsourcing.campaign.survey.catalog")
@SpringBootApplication(scanBasePackages = {"com.crowdsourcing.campaign.survey.catalog"})
public class CampaignSurveyCatalogQueryApplication {
    public static void main(String[] args) {
        SpringApplication.run(CampaignSurveyCatalogQueryApplication.class, args);
    }
}
