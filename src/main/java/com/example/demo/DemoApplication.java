package com.example.demo;

//import com.example.demo.MongoConfiguration.MongoConfig;

import com.example.demo.model.Cat;
import com.example.demo.model.Dog;
import com.example.demo.model.Zoo;
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
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.query.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;


@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    MongoOperations mongoTemplate2;

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {


//            Dog dog=new Dog("Pepper","11");
//            mongoTemplate2.save(dog);
//            Cat cat=new Cat("Nilla","12");
//            mongoTemplate2.save(cat);
//            데이터 셋

//            Query query = new Query();
//            query.addCriteria(Criteria.where("age").is("11"));
//            Update update = new Update();
//            update.set("age", "12");
//            var result=mongoTemplate2.update(Cat.class).matching(query).apply(update).first();
//            System.out.println(result);

            for(var animal:mongoTemplate2.findAll(Cat.class)){
                System.out.println(animal);
            }
        };
    }
}
