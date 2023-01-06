package com.kafka.producer;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class WikiChangesProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(WikiChangesProducer.class);

    private KafkaTemplate<String, String> kafkaTemplate;

    public WikiChangesProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void sendMesssage() throws InterruptedException {
        String topicName = "karan_wiki_recent_changes";

        // to read real time stream data from wikimedia, we use event source

        // we make a event source to connect and read real time data
        // which we will pass to eventhandler so that if any changes it will
        // capture the event and perform action -> publish to topic

        EventHandler eventHandler = new WikiChangesHandler(kafkaTemplate, topicName);
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url));
        EventSource eventSource = builder.build();
        eventSource.start();

        TimeUnit.MINUTES.sleep(10);
    }
}
