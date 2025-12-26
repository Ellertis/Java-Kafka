package com.KafkaDemo.Streams;

import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StoreQueryParameters;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KStreamController {

    @Autowired
    private StreamsBuilderFactoryBean streamsBuilderFactoryBean;

    @GetMapping("/count/{word}")
    public Long getWordCount(@PathVariable String word) {

        KafkaStreams kafkaStreams = streamsBuilderFactoryBean.getKafkaStreams();

        ReadOnlyKeyValueStore<String, Long> store =
                kafkaStreams.store(
                        StoreQueryParameters.fromNameAndType(
                                "word-counts-store",
                                QueryableStoreTypes.keyValueStore()
                        )
                );

        return store.get(word);
    }
}
