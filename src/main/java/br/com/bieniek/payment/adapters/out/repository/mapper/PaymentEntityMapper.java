package br.com.bieniek.payment.adapters.out.repository.mapper;

import br.com.bieniek.payment.adapters.out.repository.entity.PaymentEntity;
import br.com.bieniek.payment.application.core.domain.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentEntityMapper {

    PaymentEntity toPaymentEntity(Payment payment);

}
