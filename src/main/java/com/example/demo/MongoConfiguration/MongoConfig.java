package com.example.demo.MongoConfiguration;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.UuidRepresentation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.*;
import org.springframework.data.mongodb.core.convert.*;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {


    @Override
    protected String getDatabaseName() {
        return "testDB";
    }


    /*
    replica set 세팅
     */
    @Override
    protected void configureClientSettings(MongoClientSettings.Builder builder) {

        final String mongodbURI = "mongodb://localhost:27017,localhost:27018,localhost:27019,localhost:27020/?replicaSet=rs0";
        // mongodb://mongodb0.example.com:27017,mongodb1.example.com:27017,mongodb2.example.com:27017/?replicaSet=myRepl
        ConnectionString connectionString = new ConnectionString(mongodbURI);

        builder.applyConnectionString(connectionString);
    }



    @Override
    public MongoDatabaseFactory mongoDbFactory() {
        return new SimpleMongoClientDatabaseFactory(mongoClient(), getDatabaseName());
    }

    @Override
    public MappingMongoConverter mappingMongoConverter(MongoDatabaseFactory databaseFactory, MongoCustomConversions customConversions, MongoMappingContext mappingContext) {
        DbRefResolver dbRefResolver = new DefaultDbRefResolver(databaseFactory);
        MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, mappingContext);
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
        return converter;
    }


    @Override
    public MongoTemplate mongoTemplate(MongoDatabaseFactory databaseFactory, MappingMongoConverter converter) {
        MongoTemplate mongoTemplate = new MongoTemplate(databaseFactory, converter);
        mongoTemplate.setWriteResultChecking(WriteResultChecking.EXCEPTION);
        mongoTemplate.setWriteConcern(WriteConcern.MAJORITY);
        return mongoTemplate;
    }


}
