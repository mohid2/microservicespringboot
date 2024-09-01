package app.vercel.mohammedelyousfi.booking_service.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    public static String TOPIC = "booking-created";


    @Bean
    public NewTopic userCrestedTopic() {
        return TopicBuilder.name(TOPIC).build();
    }


}
