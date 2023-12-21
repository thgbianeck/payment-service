package br.com.bieniek.payment.application.ports.out;

import br.com.bieniek.payment.application.core.domain.Payment;

public interface SavePaymentOutputPort {

    void save(final Payment payment);
}
