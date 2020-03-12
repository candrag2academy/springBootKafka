package co.g2academy.xlkafka.service;

import co.g2academy.xlkafka.request.KonsumenRequest;
import com.google.gson.Gson;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
  @Autowired
  KonsumenService service;

  private final Logger logger = LoggerFactory.getLogger(Producer.class);


  @KafkaListener(topics = "konsumens", groupId = "group_id")
  public void consume(String message) throws IOException {
    try{
      Gson gson = new Gson();
      KonsumenRequest entity = gson.fromJson(message, KonsumenRequest.class);
      service.createFromKafka(entity);
      logger.info("Success create konsumen '{}' ", entity.getNama());
    } catch (Exception e){
      logger.error("An error occurred! '{}'", e.getMessage());
    }
  }

}
