package com.kafkaConsumer.database.repository;

import com.kafkaConsumer.database.entity.EventData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaDataRepository extends JpaRepository<EventData, Long> {

}
