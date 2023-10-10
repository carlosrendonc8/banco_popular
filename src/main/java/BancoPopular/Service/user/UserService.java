package BancoPopular.Service.user;

import BancoPopular.Commons.constans.response.user.IUserResponse;
import BancoPopular.Commons.converter.user.UserConverter;
import BancoPopular.Commons.domains.DTO.user.UserDTO;
import BancoPopular.Commons.domains.entity.user.UserEntity;
import BancoPopular.Commons.domains.responseDTO.GenericResponseDTO;
import BancoPopular.Repository.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import java.util.List;
import java.util.Optional;
import lombok.extern.log4j.Log4j2;

@Component
@Service
@Log4j2
public class UserService implements IUserService{

    @Autowired
    public IUserRepository iUserRepository;
    @Autowired
    public UserConverter userConverter;
    @Override
    public ResponseEntity<GenericResponseDTO> serviceUser(UserDTO userDTO) {
        try {
            List<UserEntity> usuarios = iUserRepository.findAll();
            if (!usuarios.isEmpty()) {
                for (UserEntity usuario : usuarios) {
                    UserDTO usuarioDecode = userConverter.convertUserEntityToUserDTONoEncrypt(usuario);
                    if (usuarioDecode.getUserPassword().equals(userDTO.getUserPassword())) {
                        return ResponseEntity.ok(GenericResponseDTO.builder()
                                .message("Operacion exitosa")
                                .objectResponse("Usuario autenticado correctamente")
                                .statusCode(HttpStatus.OK.value())
                                .build());
                    }
                }
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message("Contraseña incorrecta")
                        .objectResponse(null)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .build());
            } else {
                return ResponseEntity.badRequest().body(GenericResponseDTO.builder()
                        .message("Error usuario no encontrado")
                        .objectResponse(null)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .build());
            }
        } catch (Exception e) {
            log.error("Ha ocurrido un error interno", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(GenericResponseDTO.builder()
                            .message("Error interno del servidor")
                            .objectResponse(null)
                            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }

    @Override
    public ResponseEntity<GenericResponseDTO> saveUser(UserDTO userDTO) {
        try {
            Optional<UserEntity> existeUser;
            existeUser = iUserRepository.findById(userDTO.getUserId());
            if(!existeUser.isPresent()){
                UserEntity userEntity = userConverter.convertUserDTOToUserEntityEncrypt(userDTO);
                iUserRepository.save(userEntity);
                return new ResponseEntity<>(GenericResponseDTO.builder()
                        .message(IUserResponse.CREATE_SUCCESS)
                        .objectResponse(IUserResponse.CREATE_LOGIN_SUCCESS)
                        .statusCode(HttpStatus.OK.value())
                        .build(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(GenericResponseDTO.builder()
                        .message(IUserResponse.CREATE_FAIL)
                        .objectResponse(IUserResponse.LOGIN_SUCCESS)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .build(), HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            log.error(IUserResponse.INTERNAL_SERVER + e);
            return new ResponseEntity<>(GenericResponseDTO.builder()
                    .message(IUserResponse.CREATE_FAIL)
                    .objectResponse(null)
                    .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<GenericResponseDTO> updateUser(UserDTO userDTO) {
        try {
            Optional<UserEntity> existeUser = iUserRepository.findById(userDTO.getUserId());
            if(existeUser.isPresent()){
                UserEntity userEntity = userConverter.convertUserDTOToUserEntityEncrypt(userDTO);
                iUserRepository.save(userEntity);
                return new ResponseEntity<>(GenericResponseDTO.builder()
                        .message(IUserResponse.OPERATION_SUCCESS)
                        .objectResponse(IUserResponse.UPDATE_SUCCESS)
                        .statusCode(HttpStatus.OK.value())
                        .build(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(GenericResponseDTO.builder()
                        .message(IUserResponse.OPERATION_FAIL)
                        .objectResponse(IUserResponse.LOGIN_FAIL)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .build(), HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            log.error(IUserResponse.INTERNAL_SERVER + e);
            return new ResponseEntity<>(GenericResponseDTO.builder()
                    .message(IUserResponse.CREATE_FAIL)
                    .objectResponse(null)
                    .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<GenericResponseDTO> deleteUser(UserDTO userDTO) {
        try {
            Optional<UserEntity> existeUser = iUserRepository.findById(userDTO.getUserId());
            if(existeUser.isPresent()){
                UserEntity userEntity = userConverter.convertUserDTOToUserEntityEncrypt(userDTO);
                iUserRepository.delete(userEntity);
                return new ResponseEntity<>(GenericResponseDTO.builder()
                        .message(IUserResponse.OPERATION_SUCCESS)
                        .objectResponse(IUserResponse.DELETE_SUCCESS)
                        .statusCode(HttpStatus.OK.value())
                        .build(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(GenericResponseDTO.builder()
                        .message(IUserResponse.OPERATION_FAIL)
                        .objectResponse(IUserResponse.LOGIN_FAIL)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .build(), HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            log.error(IUserResponse.INTERNAL_SERVER + e);
            return new ResponseEntity<>(GenericResponseDTO.builder()
                    .message(IUserResponse.CREATE_FAIL)
                    .objectResponse(null)
                    .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}