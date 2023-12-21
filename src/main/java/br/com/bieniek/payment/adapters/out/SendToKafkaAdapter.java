package br.com.bieniek.payment.adapters.out;

import br.com.bieniek.payment.adapters.out.message.SaleMessage;
import br.com.bieniek.payment.application.core.domain.Sale;
import br.com.bieniek.payment.application.core.domain.enums.SaleEvent;
import br.com.bieniek.payment.application.ports.out.SendToKafkaOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendToKafkaAdapter implements SendToKafkaOutputPort {

    private final KafkaTemplate<String, SaleMessage> kafkaTemplate;
    @Override
    public void send(Sale sale, SaleEvent event) {
        var saleMessage = new SaleMessage(sale, event);
        kafkaTemplate.send("sale", saleMessage);
    }
}
