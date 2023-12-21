package br.com.bieniek.payment.config.usecases;

import br.com.bieniek.payment.adapters.out.FindUserByIdAdapter;
import br.com.bieniek.payment.application.core.usecase.FindUserByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindUserByIdConfig {

    @Bean
    public FindUserByIdUseCase findUserByIdUseCase(
            FindUserByIdAdapter findUserByIdAdapter
    ) {
        return new FindUserByIdUseCase(findUserByIdAdapter);
    }

}
