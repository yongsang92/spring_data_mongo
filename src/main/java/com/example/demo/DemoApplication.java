package com.example.demo;

//import com.example.demo.MongoConfiguration.MongoConfig;
import com.example.demo.model.Dog;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.*;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;


@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired
    MongoTemplate mongoTemplate;


    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {


//            final String mongodbURI = "mongodb+srv://asd:asd@mflix.kazzu.mongodb.net/sample_airbnb?retryWrites=true&w=majority";
//
//            MongoClient client = MongoClients.create(mongodbURI);
//
//            MongoCollection collection = client.getDatabase("sample_airbnb").getCollection("listingsAndReviews");
//
//
//            System.out.println("!!!!!!!!!!!!!!" +
//                    collection.find().projection(Projections.include("name")).first()
//            );

//            System.out.println(
//                    "?"+factory.getMongoDatabase().getReadConcern().getLevel()
//            );
//            // readConcern은 스프링에서 설정할 수 있다
//


            System.out.println("Collection lists: " + mongoTemplate.getCollectionNames());
            var db = mongoTemplate.getDb();
            System.out.println(
                    "MongoTemplate Info : "
                            + db.getWriteConcern()
                            +"\n"
                            + db.getReadConcern().getLevel()
            );

//            System.out.println(
//                    mongoTemplate.findOne(new Query(Criteria.where("name").is("Elizabeth Ray")), Object.class, "customers")
//            );

        };
    }


}
