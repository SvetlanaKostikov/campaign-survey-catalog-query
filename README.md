Модуль - Справочник опроса. Запросы.

Реализует сложные запросы, выборку конкретных опросов для конкретного участника, краткое и полное их описание, проверяет принадлежит ли участник к конкретной кампании и какие опросы в рамках этой кампании ему доступны.
Запросы реализуются посредством языка SQL в репозитории SurveyCatalogContenteNativeQuery, прописанные над методами с аннотацией Query.
Информация о самой опубликованной кампании, а также о паспортах опросов приходит посредстом событий в Kafka.
