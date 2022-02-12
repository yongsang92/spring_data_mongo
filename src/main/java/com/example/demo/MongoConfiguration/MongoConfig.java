//package com.example.demo.MongoConfiguration;
//
//import com.mongodb.*;
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import com.mongodb.connection.ClusterSettings;
//import org.bson.UuidRepresentation;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.MongoDatabaseFactory;
//import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
//import org.springframework.data.mongodb.core.*;
//import org.springframework.data.mongodb.core.convert.*;
//import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
//
//import java.sql.Connection;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//@Configuration
//public class MongoConfig extends AbstractMongoClientConfiguration {
//
//
//    @Override
//    protected String getDatabaseName() {
//        return "sample_analytics"; // 근데 이거 uri에 있어서 // return "listingsAndReviews";를 했는데 아니었다
//    }
//
//    /*
//    replica set 세팅
//     */
//    @Override
//    protected void configureClientSettings(MongoClientSettings.Builder builder) {
////        final String mongodbURI = "mongodb://localhost:27017,localhost:27018,localhost:27019,localhost:27020/?replicaSet=rs0";
//        // mongodb://mongodb0.example.com:27017,mongodb1.example.com:27017,mongodb2.example.com:27017/?replicaSet=myRepl
////        final String mongodbURI = "mongodb+srv://asd:asd@mflix.kazzu.mongodb.net/sample_analytics?retryWrites=true&w=majority";
////        final String mongodbURI = "mongodb+srv://asd:asd@mflix.kazzu.mongodb.net/?retryWrites=true&w=majority";
//        // TODO 문자열 설정은 다른것보다 우선순위가 높다는거
//        final String mongodbURI = "mongodb+srv://asd:asd@mflix.kazzu.mongodb.net";
//        // 이렇게 해도 되네?
//        ConnectionString connectionString = new ConnectionString(mongodbURI);
//        builder.applyConnectionString(connectionString);
//    }
//
//
//
////    @Override
////    protected MongoClientSettings mongoClientSettings() {
////        MongoClientSettings.Builder builder=MongoClientSettings.builder();
////        builder.uuidRepresentation(UuidRepresentation.JAVA_LEGACY);
//////        builder.writeConcern(WriteConcern.W3);
//////        builder.writeConcern(new WriteConcern(3,10));
//////        builder.readConcern(ReadConcern.LINEARIZABLE);
////        configureClientSettings(builder);
////
////        return builder.build();
////    }
//
//
//    @Override
//    public MongoDatabaseFactory mongoDbFactory() {
//        return new SimpleMongoClientDatabaseFactory(mongoClient(), getDatabaseName());
//    }
//
//    @Override
//    public MappingMongoConverter mappingMongoConverter(MongoDatabaseFactory databaseFactory, MongoCustomConversions customConversions, MongoMappingContext mappingContext) {
//        DbRefResolver dbRefResolver = new DefaultDbRefResolver(databaseFactory);
//        MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, mappingContext);
//        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
//        return converter;
//    }
//
//
//    @Override
//    public MongoTemplate mongoTemplate(MongoDatabaseFactory databaseFactory, MappingMongoConverter converter) {
//        MongoTemplate mongoTemplate = new MongoTemplate(databaseFactory, converter);
//        mongoTemplate.setWriteConcern(WriteConcern.W1);
//        return mongoTemplate;
//    }
//
//
//}
