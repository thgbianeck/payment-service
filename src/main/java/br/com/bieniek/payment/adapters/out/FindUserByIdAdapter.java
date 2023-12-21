package br.com.bieniek.payment.adapters.out;

import br.com.bieniek.payment.adapters.out.repository.UserRepository;
import br.com.bieniek.payment.adapters.out.repository.mapper.UserEntityMapper;
import br.com.bieniek.payment.application.core.domain.User;
import br.com.bieniek.payment.application.ports.out.FindUserByIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindUserByIdAdapter implements FindUserByIdOutputPort {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public Optional<User> find(Integer userId) {
        var userEntity = userRepository.findById(userId);
        return userEntity.map(userEntityMapper::toUser);
    }
}
