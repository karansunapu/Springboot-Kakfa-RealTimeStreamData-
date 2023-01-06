package com.kafkaConsumer.database;

import com.kafkaConsumer.database.entity.EventData;
import com.kafkaConsumer.database.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerDatabase {

    private WikimediaDataRepository dataRepository;

    public KafkaConsumerDatabase(WikimediaDataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerDatabase.class);

    @KafkaListener(topics = "karan_wiki_recent_changes", groupId = "myGroup")
    public void consumeEventMesssage(String eventMessage){
        LOGGER.info(String.format("Event data consumed -> %s", eventMessage));

        EventData data = new EventData();
        data.setEventData(eventMessage);

        dataRepository.save(data);

    }
}
