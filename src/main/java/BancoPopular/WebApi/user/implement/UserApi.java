package BancoPopular.WebApi.user.implement;

import BancoPopular.Commons.constans.endPoints.user.IUserEndPoint;
import BancoPopular.Commons.constans.response.user.IUserResponse;
import BancoPopular.Commons.domains.DTO.user.UserDTO;
import BancoPopular.Commons.domains.responseDTO.GenericResponseDTO;
import BancoPopular.Service.user.UserService;
import BancoPopular.WebApi.user.IUserApi;
import lombok.extern.log4j.Log4j2;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(IUserEndPoint.URL_USER)
@Tag(name = "Sistema de Gestión de Usuarios", description = "Ops de autenticar, crear, eliminar y actualizar usuarios")
@Log4j2
public class UserApi implements IUserApi {
    private final UserService userService;

    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @Override
    @Operation(summary = "controlar la autenticación de los usuarios")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = IUserResponse.AUTENTIFICATION_SUCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode  = "400", description = IUserResponse.AUTENTIFICACION_FAIL,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode  = "404", description = IUserResponse.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode  = "500", description = IUserResponse.INTERNAL_SERVER,
                    content = {@Content(mediaType = "application/json")})})
    @GetMapping(IUserEndPoint.SERVICE_VALIDATION_USER)
    public ResponseEntity<GenericResponseDTO> serviceUser(@RequestBody UserDTO userDTO) {
        return this.userService.serviceUser(userDTO);
    }

    @Override
    @Operation(summary = "crear una nueva cuenta de usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = IUserResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode  = "400", description = IUserResponse.CREATE_FAIL,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode  = "500", description = IUserResponse.INTERNAL_SERVER,
                    content = {@Content(mediaType = "application/json")})})
    @PostMapping(IUserEndPoint.CREATE_USER)
    public ResponseEntity<GenericResponseDTO> saveUser(@RequestBody UserDTO userDTO) {
        return this.userService.saveUser(userDTO);
    }

    @Override
    @Operation(summary = "actualizar una cuenta de usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = IUserResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode  = "400", description = IUserResponse.CREATE_FAIL,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode  = "500", description = IUserResponse.INTERNAL_SERVER,
                    content = {@Content(mediaType = "application/json")})})
    @PutMapping(IUserEndPoint.UPDATE_USER)
    public ResponseEntity<GenericResponseDTO> updateUser(UserDTO userDTO) {
        return this.userService.updateUser(userDTO);
    }

    @Override
    @Operation(summary = "eliminar una cuenta de usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = IUserResponse.CREATE_SUCCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode  = "400", description = IUserResponse.CREATE_FAIL,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode  = "500", description = IUserResponse.INTERNAL_SERVER,
                    content = {@Content(mediaType = "application/json")})})
    @DeleteMapping(IUserEndPoint.DELETE_USER)
    public ResponseEntity<GenericResponseDTO> deleteUser(UserDTO userDTO) {
        return this.userService.deleteUser(userDTO);
    }
}