package com.example.demo.MongoConfiguration;

import com.example.demo.model.Dog;
import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.connection.ClusterSettings;
import org.bson.UuidRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.*;
import org.springframework.data.mongodb.core.convert.*;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.core.mapping.event.LoggingEventListener;
import org.springframework.data.mongodb.core.mapping.event.MongoMappingEvent;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {


    @Value("${spring.data.mongodb.uri}")
    private String mongodbURI;

    @Value("${spring.data.mongodb.database}")
    private String database;

    @Override
    protected String getDatabaseName() {
        return database;
    }

    @Override
    protected Collection<String> getMappingBasePackages() {
        return super.getMappingBasePackages();
    }

    @Override
    protected void configureClientSettings(MongoClientSettings.Builder builder) {
        ConnectionString connectionString = new ConnectionString(mongodbURI);
        builder.applyConnectionString(connectionString);
    }

    @Override
    protected MongoClientSettings mongoClientSettings() {
        MongoClientSettings.Builder builder = MongoClientSettings.builder();
        builder.uuidRepresentation(UuidRepresentation.JAVA_LEGACY);
        configureClientSettings(builder);
        return builder.build();
    }



    @Override
    public MongoDatabaseFactory mongoDbFactory() {
        return new SimpleMongoClientDatabaseFactory(mongoClient(), getDatabaseName());
    }

//    @Override
//    public MappingMongoConverter mappingMongoConverter(MongoDatabaseFactory databaseFactory, MongoCustomConversions customConversions, MongoMappingContext mappingContext) {
//        DbRefResolver dbRefResolver = new DefaultDbRefResolver(databaseFactory);
//        MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, mappingContext);
//        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
//        return converter;
//    }

    @Override
    public MongoTemplate mongoTemplate(MongoDatabaseFactory databaseFactory, MappingMongoConverter converter) {
        MongoTemplate mongoTemplate = new MongoTemplate(databaseFactory, converter);
        mongoTemplate.setWriteConcern(new WriteConcern(0, 10));

//        mongoTemplate.setWriteConcernResolver(action -> {
//            if (action.getCollectionName().equals("customer"))
//            return new WriteConcern(3, -3);
//
//
//            if (action.getCollectionName().equals("Cat"))
//                return new WriteConcern(0, 20);
//
//            return action.getDefaultWriteConcern();
//        });
        return mongoTemplate;
    }

    @Override
    public MongoCustomConversions customConversions() {
        return super.customConversions();
    }
}
