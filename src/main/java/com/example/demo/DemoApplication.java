package com.example.demo;

import com.example.demo.MongoConfiguration.MongoConfig;
import com.example.demo.model.Dog;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.FindAndReplaceOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.*;

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


//            Dog upserted = mongoTemplate.update(Dog.class)
//                    .matching(new Query(Criteria.where("name").is("jjaerong")))
////                    .matching(new Query(Criteria.where("name").is("jjaerong")).with(Sort.by(Sort.Direction.DESC,"age")))
//                    .apply(new Update())
//                    .withOptions(
//                            FindAndModifyOptions.options().upsert(true).returnNew(true))
//                    .findAndModifyValue();

//
            Dog dog=new Dog("ari","10");
            mongoTemplate.insert(dog);

//            Optional<Dog> upserted = mongoTemplate.update(Dog.class)// _class를 저장안해서 안될거라고 생각함 // 결과 : 되네 -_-
//                    .matching(new Query(where("name").is("ari")).with(Sort.by(Sort.Direction.DESC, "age")))
//                    .apply(new Update().set("age", "110"))
//                    .withOptions(FindAndModifyOptions.options().upsert(true).returnNew(true))
//                    .findAndModify();

//            mongoTemplate.query(Person.class)
//                    .matching(
//                            Query.query(
//                                    Criteria.where("name").is("david").and("accounts.balance").gt(2000))
//                    ).first().get();

            var result = mongoTemplate.query(Dog.class)
                    .distinct("name").all();

            for (Object o : result) {
                System.out.println(o);
            }

        };
    }

    @Document("person")
    static class Person {
        String id, age, name;

        @Override
        public String toString() {
            return "Person{" +
                    "id='" + id + '\'' +
                    ", age='" + age + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    static class TypeMapper extends DefaultMongoTypeMapper {

    }
}
