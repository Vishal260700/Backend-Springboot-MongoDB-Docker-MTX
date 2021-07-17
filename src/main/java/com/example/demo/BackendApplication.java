package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UserRepository repository, MongoTemplate mongoTemplate) {
		return args -> {


			Address address = new Address(
					"India",
					"Jaipur",
					"302034"
			);

			String queryMail = "otherOtherVishal@gmail.com";


			user newUser = new user(
					"Vishal",
					"Agarwal",
					queryMail,
					Gender.MALE,
					address,
					List.of("Computer Science"),
					BigDecimal.TEN
			);


			repository.findUserByEmail(queryMail).ifPresentOrElse(s -> {
				System.out.println(newUser + "already exists");
			}, () -> {
				System.out.println("Inserting user " + newUser);
				repository.insert(newUser);
			});


			// usingMongoTemplateQuery(repository, mongoTemplate, queryMail, newUser);

		};
	}

	private void usingMongoTemplateQuery(UserRepository repository, MongoTemplate mongoTemplate, String queryMail, user newUser) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(queryMail));

		List<user> users = mongoTemplate.find(query, user.class);

		if(users.size() > 1){
			throw new IllegalStateException("found multiple users with email" + queryMail);
		}

		if(users.isEmpty()){
			System.out.println("Inserting user " + newUser);
			repository.insert(newUser);
		}else{
			System.out.println(newUser + "already exists");
		}
	}

}
