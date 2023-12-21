package br.com.bieniek.payment.adapters.in.consumer;

import br.com.bieniek.payment.adapters.out.message.SaleMessage;
import br.com.bieniek.payment.application.core.domain.enums.SaleEvent;
import br.com.bieniek.payment.application.ports.in.SalePaymentInputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ReceiveSaleToPaymentConsumer {

    private final SalePaymentInputPort salePaymentInputPort;

    @KafkaListener(topics = "tp-saga-sale", groupId = "payment")
    public void receive(SaleMessage saleMessage) {
        if(SaleEvent.UPDATED_INVENTORY.equals(saleMessage.getEvent())) {
            log.info("Início do pagamento.");
            salePaymentInputPort.payment(saleMessage.getSale());
            log.info("Fim do pagamento.");
        }
    }

}
