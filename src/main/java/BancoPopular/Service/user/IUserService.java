package BancoPopular.Service.user;

import org.springframework.http.ResponseEntity;
import BancoPopular.Commons.domains.responseDTO.GenericResponseDTO;
import BancoPopular.Commons.domains.DTO.user.UserDTO;

public interface IUserService {
    ResponseEntity<GenericResponseDTO> serviceUser(UserDTO userDTO);
    ResponseEntity<GenericResponseDTO> saveUser(UserDTO userDTO);
    ResponseEntity<GenericResponseDTO> updateUser(UserDTO userDTO);
    ResponseEntity<GenericResponseDTO> deleteUser(UserDTO userDTO);
}
