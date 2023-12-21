package br.com.bieniek.payment.application.ports.out;

import br.com.bieniek.payment.application.core.domain.User;

import java.util.Optional;

public interface FindUserByIdOutputPort {

    Optional<User> find(final Integer userId);
}
