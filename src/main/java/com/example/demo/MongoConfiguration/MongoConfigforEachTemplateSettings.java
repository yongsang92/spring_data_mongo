package com.example.demo.MongoConfiguration;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


/*
몽고디비 레퍼런스에서 mongoTemplate에 writeconcern을 설정할 수 있다고 했는데
안된다 -_-
 */
@Configuration
public class MongoConfigforEachTemplateSettings {

    @Value("${spring.data.mongodb.uri}")
    private String mongodbURI;

    @Value("${spring.data.mongodb.database}")
    private String database;

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create(mongodbURI);
    }

    @Bean
    public MongoTemplate mongoTemplate2() {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoClient(), database);
        mongoTemplate.setWriteConcern(new WriteConcern(0, 10));
        mongoTemplate.setWriteConcern(WriteConcern.MAJORITY);

        return mongoTemplate;
    }
}


