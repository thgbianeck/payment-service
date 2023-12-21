package br.com.bieniek.payment.application.core.usecase;

import br.com.bieniek.payment.application.core.domain.User;
import br.com.bieniek.payment.application.ports.in.FindUserByIdInputPort;
import br.com.bieniek.payment.application.ports.out.FindUserByIdOutputPort;

public class FindUserByIdUseCase implements FindUserByIdInputPort{

    private final FindUserByIdOutputPort findUserByIdOutputPort;

    public FindUserByIdUseCase(FindUserByIdOutputPort findUserByIdOutputPort) {
        this.findUserByIdOutputPort = findUserByIdOutputPort;
    }

    @Override
    public User find(final Integer id) {
        return findUserByIdOutputPort.find(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
