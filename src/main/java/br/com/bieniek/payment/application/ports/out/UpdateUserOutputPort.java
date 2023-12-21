package br.com.bieniek.payment.application.ports.out;

import br.com.bieniek.payment.application.core.domain.User;

public interface UpdateUserOutputPort {

    void update(final User user);
}
