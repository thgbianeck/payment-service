package br.com.bieniek.payment.application.ports.in;

import br.com.bieniek.payment.application.core.domain.User;

public interface FindUserByIdInputPort {

    User find(final Integer userId);
}
