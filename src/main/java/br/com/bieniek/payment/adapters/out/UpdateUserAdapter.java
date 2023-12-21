package br.com.bieniek.payment.adapters.out;

import br.com.bieniek.payment.adapters.out.repository.UserRepository;
import br.com.bieniek.payment.adapters.out.repository.mapper.UserEntityMapper;
import br.com.bieniek.payment.application.core.domain.User;
import br.com.bieniek.payment.application.ports.out.UpdateUserOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateUserAdapter implements UpdateUserOutputPort {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    @Override
    public void update(User user) {
        var userEntity = userEntityMapper.toUserEntity(user);
        userRepository.save(userEntity);
    }
}
