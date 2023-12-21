package br.com.bieniek.payment.adapters.out;

import br.com.bieniek.payment.adapters.out.repository.PaymentRepository;
import br.com.bieniek.payment.adapters.out.repository.mapper.PaymentEntityMapper;
import br.com.bieniek.payment.application.core.domain.Payment;
import br.com.bieniek.payment.application.ports.out.SavePaymentOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SavePaymentAdapter implements SavePaymentOutputPort {

    private final PaymentRepository paymentRepository;
    private final PaymentEntityMapper paymentEntityMapper;
    @Override
    public void save(Payment payment) {
        var paymentEntity = paymentEntityMapper.toPaymentEntity(payment);
        paymentRepository.save(paymentEntity);

    }
}
