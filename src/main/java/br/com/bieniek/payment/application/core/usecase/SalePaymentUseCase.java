package br.com.bieniek.payment.application.core.usecase;

import br.com.bieniek.payment.application.core.domain.Payment;
import br.com.bieniek.payment.application.core.domain.Sale;
import br.com.bieniek.payment.application.core.domain.enums.SaleEvent;
import br.com.bieniek.payment.application.ports.in.FindUserByIdInputPort;
import br.com.bieniek.payment.application.ports.in.SalePaymentInputPort;
import br.com.bieniek.payment.application.ports.out.SavePaymentOutputPort;
import br.com.bieniek.payment.application.ports.out.SendToKafkaOutputPort;
import br.com.bieniek.payment.application.ports.out.UpdateUserOutputPort;

public class SalePaymentUseCase implements SalePaymentInputPort {

    private final FindUserByIdInputPort findUserByIdInputPort;
    private final UpdateUserOutputPort updateUserOutputPort;
    private final SavePaymentOutputPort savePaymentOutputPort;
    private final SendToKafkaOutputPort sendToKafkaOutputPort;

    public SalePaymentUseCase(
            FindUserByIdInputPort findUserByIdInputPort,
            UpdateUserOutputPort updateUserOutputPort,
            SavePaymentOutputPort savePaymentOutputPort,
            SendToKafkaOutputPort sendToKafkaOutputPort) {
        this.findUserByIdInputPort = findUserByIdInputPort;
        this.updateUserOutputPort = updateUserOutputPort;
        this.savePaymentOutputPort = savePaymentOutputPort;
        this.sendToKafkaOutputPort = sendToKafkaOutputPort;
    }

    @Override
    public void payment(Sale sale) {
        var user = findUserByIdInputPort.find(sale.getUserId());
        if (user.getBalance().compareTo(sale.getValue()) < 0) {
            throw new RuntimeException("Insufficient balance");
        }
        user.debitBalance(sale.getValue());
        updateUserOutputPort.update(user);
        savePaymentOutputPort.save(buildPayment(sale));
        sendToKafkaOutputPort.send(sale, SaleEvent.VALIDATED_PAYMENT);
    }

    private Payment buildPayment(Sale sale) {
        return new Payment(sale.getUserId(), sale.getId(), sale.getValue());
    }
}
