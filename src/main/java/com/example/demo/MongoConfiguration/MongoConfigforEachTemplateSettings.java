package com.example.demo.MongoConfiguration;

import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;


/*
몽고디비 레퍼런스에서 mongoTemplate에 writeconcern을 설정할 수 있다고 했는데
안된다 -_-
 */
@Configuration
public class MongoConfigforEachTemplateSettings {
    @Bean
    public MongoClient mongoClient() {
        final String mongodbURI = "mongodb+srv://asd:asd@mflix.kazzu.mongodb.net";
        return MongoClients.create(mongodbURI);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoClient(), "sample_analytics");
        mongoTemplate.setWriteConcern(WriteConcern.MAJORITY);
        return mongoTemplate;
    }
}


