package br.com.bieniek.payment.adapters.out.repository.mapper;

import br.com.bieniek.payment.adapters.out.repository.entity.UserEntity;
import br.com.bieniek.payment.application.core.domain.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

    User toUser(UserEntity userEntity);

    UserEntity toUserEntity(User user);

}
