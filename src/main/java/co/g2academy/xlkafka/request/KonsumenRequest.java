package co.g2academy.xlkafka.request;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KonsumenRequest {
  private Integer id;
  private String nama;
  private String alamat;
  private String hp;
  private BigDecimal saldo;

}
