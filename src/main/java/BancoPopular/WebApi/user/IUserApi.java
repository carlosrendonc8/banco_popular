package BancoPopular.WebApi.user;

import BancoPopular.Commons.constans.endPoints.user.IUserEndPoint;
import BancoPopular.Commons.domains.DTO.user.UserDTO;
import BancoPopular.Commons.domains.responseDTO.GenericResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface IUserApi {
    @PostMapping(IUserEndPoint.SERVICE_VALIDATION_USER)
    ResponseEntity<GenericResponseDTO> serviceUser(@RequestBody UserDTO userDTO);
    @PostMapping(IUserEndPoint.CREATE_USER)
    ResponseEntity<GenericResponseDTO> saveUser(@RequestBody UserDTO userDTO);
    @PutMapping(IUserEndPoint.UPDATE_USER)
    ResponseEntity<GenericResponseDTO> updateUser(@RequestBody UserDTO userDTO);
    @DeleteMapping(IUserEndPoint.DELETE_USER)
    ResponseEntity<GenericResponseDTO> deleteUser(@RequestBody UserDTO userDTO);
}
