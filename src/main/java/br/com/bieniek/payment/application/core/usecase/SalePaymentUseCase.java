package br.com.bieniek.payment.application.core.usecase;

import br.com.bieniek.payment.application.core.domain.Payment;
import br.com.bieniek.payment.application.core.domain.Sale;
import br.com.bieniek.payment.application.core.domain.enums.SaleEvent;
import br.com.bieniek.payment.application.ports.in.FindUserByIdInputPort;
import br.com.bieniek.payment.application.ports.out.SavePaymentOutputPort;
import br.com.bieniek.payment.application.ports.out.SendValidatedPaymentOutputPort;
import br.com.bieniek.payment.application.ports.out.UpdateUserOutputPort;

public class SalePaymentUseCase {

    private final FindUserByIdInputPort findUserByIdInputPort;
    private final UpdateUserOutputPort updateUserOutputPort;
    private final SavePaymentOutputPort savePaymentOutputPort;
    private final SendValidatedPaymentOutputPort sendValidatedPaymentOutputPort;

    public SalePaymentUseCase(
            FindUserByIdInputPort findUserByIdInputPort,
            UpdateUserOutputPort updateUserOutputPort,
            SavePaymentOutputPort savePaymentOutputPort,
            SendValidatedPaymentOutputPort sendValidatedPaymentOutputPort) {
        this.findUserByIdInputPort = findUserByIdInputPort;
        this.updateUserOutputPort = updateUserOutputPort;
        this.savePaymentOutputPort = savePaymentOutputPort;
        this.sendValidatedPaymentOutputPort = sendValidatedPaymentOutputPort;
    }

    public void payment(Sale sale) {
        var user = findUserByIdInputPort.find(sale.getUserId());
        if (user.getBalance().compareTo(sale.getValue()) < 0) {
            throw new RuntimeException("Insufficient balance");
        }
        user.debitBalance(sale.getValue());
        updateUserOutputPort.update(user);
        savePaymentOutputPort.save(buildPayment(sale));
        sendValidatedPaymentOutputPort.send(sale, SaleEvent.VALIDATED_PAYMENT);
    }

    private Payment buildPayment(Sale sale) {
        return new Payment(sale.getUserId(), sale.getId(), sale.getValue());
    }
}
