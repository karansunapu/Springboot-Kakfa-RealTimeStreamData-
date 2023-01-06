package com.kafkaConsumer.database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "wikimedia_recentchange")
@Getter
@Setter
public class EventData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Lob
    private String eventData;
}
