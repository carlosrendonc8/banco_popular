package BancoPopular.Commons.converter.user;

import BancoPopular.Commons.constans.response.user.IUserResponse;
import BancoPopular.Commons.domains.DTO.user.UserDTO;
import BancoPopular.Commons.domains.entity.user.UserEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import BancoPopular.Commons.helpers.HelperMapper;

import java.util.Base64;

@Log4j2
@Component
public class UserConverter {
    public UserDTO convertUserEntityToUserDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        try {
            userDTO = HelperMapper.modelMapper().map(userEntity, UserDTO.class);
        } catch (Exception e) {
            log.error(IUserResponse.DOCUMENT_FAIL + e);
        }
        return userDTO;
    }

    public UserEntity convertUserDTOToUserEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        try {
            userEntity = HelperMapper.modelMapper().map(userDTO, UserEntity.class);
        } catch (Exception e) {
            log.error(IUserResponse.DOCUMENT_FAIL + e);
        }
        return userEntity;
    }
    public UserDTO convertUserEntityToUserDTONoEncrypt(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        try {
            userDTO = HelperMapper.modelMapper().map(userEntity, UserDTO.class);
            byte[] cadenaDecodificadaByte = Base64.getDecoder().decode(userEntity.getUserPassword());
            String cadenaDecodificada = new String(cadenaDecodificadaByte);
            userDTO.setUserPassword(cadenaDecodificada);
        } catch (Exception e) {
            log.error(IUserResponse.DOCUMENT_FAIL + e);
        }
        return userDTO;
    }

    public UserEntity convertUserDTOToUserEntityEncrypt(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        try {
            userEntity = HelperMapper.modelMapper().map(userDTO, UserEntity.class);
            userEntity.setUserPassword(
                    Base64.getEncoder().encodeToString(userDTO.getUserPassword().getBytes()));
        } catch (Exception e) {
            log.error(IUserResponse.DOCUMENT_FAIL + e);
        }
        return userEntity;
    }
}
