package br.com.bieniek.payment.config.usecases;

import br.com.bieniek.payment.adapters.out.SavePaymentAdapter;
import br.com.bieniek.payment.adapters.out.SendToKafkaAdapter;
import br.com.bieniek.payment.adapters.out.UpdateUserAdapter;
import br.com.bieniek.payment.application.core.usecase.FindUserByIdUseCase;
import br.com.bieniek.payment.application.core.usecase.SalePaymentUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalePaymentConfig {

    @Bean
    public SalePaymentUseCase salePaymentUseCase(
            FindUserByIdUseCase findUserByIdUseCase,
            UpdateUserAdapter updateUserAdapter,
            SavePaymentAdapter savePaymentAdapter,
            SendToKafkaAdapter sendToKafkaAdapter
    ) {
        return new SalePaymentUseCase(findUserByIdUseCase, updateUserAdapter, savePaymentAdapter, sendToKafkaAdapter);
    }

}