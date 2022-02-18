create table if not exists survey_passport
(
    id                                varchar(500) not null primary key unique,
    name                              varchar(3000),
    status                            varchar(100),
    content                           varchar,
    participant_passport_requirements varchar,
    survey_catalog_id                 varchar(100)
    );
create table if not exists user_access
(
    id           varchar(100) not null primary key unique,
    campaign_id  varchar(100),
    role         varchar(100)
    );

create table if not exists survey_catalog
(
    id          varchar(100) not null primary key unique,
    status      varchar(100),
    description varchar
    );
