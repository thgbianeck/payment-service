package br.com.bieniek.payment.application.ports.in;

import br.com.bieniek.payment.application.core.domain.Sale;

public interface SalePaymentInputPort {

    void payment(Sale sale);

}
