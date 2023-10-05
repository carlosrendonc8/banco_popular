package BancoPopular.Repository.user;

import BancoPopular.Commons.domains.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity, Integer>{
}
