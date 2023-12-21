package br.com.bieniek.payment.application.ports.out;

import br.com.bieniek.payment.application.core.domain.Sale;
import br.com.bieniek.payment.application.core.domain.enums.SaleEvent;

public interface SendToKafkaOutputPort {

    void send(Sale sale, SaleEvent event);
}
