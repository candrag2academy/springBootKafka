package co.g2academy.xlkafka.service;

import co.g2academy.xlkafka.request.KonsumenRequest;



public interface KonsumenService {
  void createFromKafka(KonsumenRequest message);
}
