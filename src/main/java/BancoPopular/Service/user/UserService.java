package BancoPopular.Service.user;

import BancoPopular.Commons.domains.DTO.user.UserDTO;
import BancoPopular.Commons.domains.responseDTO.GenericResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;

@Component
@Service
public class UserService implements IUserService{


    @Override
    public ResponseEntity<GenericResponseDTO> serviceUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public ResponseEntity<GenericResponseDTO> saveUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public ResponseEntity<GenericResponseDTO> updateUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public ResponseEntity<GenericResponseDTO> deleteUser(UserDTO userDTO) {
        return null;
    }
}
