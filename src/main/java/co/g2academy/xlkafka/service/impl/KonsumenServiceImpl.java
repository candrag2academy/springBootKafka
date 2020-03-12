package co.g2academy.xlkafka.service.impl;

import co.g2academy.xlkafka.model.KonsumenModel;
import co.g2academy.xlkafka.repository.KonsumenRepository;
import co.g2academy.xlkafka.request.KonsumenRequest;
import co.g2academy.xlkafka.service.KonsumenService;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Repository("KonsumenService")
public class KonsumenServiceImpl implements KonsumenService {
  private KonsumenRepository repository;

  public void createFromKafka(KonsumenRequest request){
    KonsumenModel entity = toEntity(request);
    repository.save(entity);
  }

  private KonsumenModel toEntity(KonsumenRequest entity) {
    return KonsumenModel.builder()
        .nama(entity.getNama())
        .alamat(entity.getAlamat())
        .hp(entity.getHp())
        .saldo(entity.getSaldo())
        .build();
  }

}
