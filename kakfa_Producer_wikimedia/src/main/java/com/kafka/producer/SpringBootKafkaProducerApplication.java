package com.kafka.producer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootKafkaProducerApplication implements CommandLineRunner {

    @Autowired
    private WikiChangesProducer wikiChangesProducer;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootKafkaProducerApplication.class);
    }


    @Override
    public void run(String... args) throws Exception {
        wikiChangesProducer.sendMesssage();
    }
}
