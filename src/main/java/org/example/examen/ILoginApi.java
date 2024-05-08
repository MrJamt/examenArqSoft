package org.example.examen;

import org.example.examen.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import org.example.examen.dto.ErrorResponse;
import org.example.examen.dto.LoginRequestDto;
import org.example.examen.dto.LoginResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestBody;

public interface ILoginApi {

    @Tag(name = "Login", description = "Authenticate user")
    @Operation(summary = "Authenticate user", description = "Authenticate user with provided credentials")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "400", description = "Bad Request - La solicitud no es válida",
                            content = {
                                    @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = ErrorResponse.class))
                            }
                    ),

                    @ApiResponse(
                            responseCode = "404", description = "Not Found - El recurso solicitado no fue encontrado",
                            content = {
                                    @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = ErrorResponse.class))
                            }
                    ),

                    @ApiResponse(
                            responseCode = "500", description = "Internal Server Error - Error interno del servidor",
                            content = {
                                    @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = ErrorResponse.class))
                            }
                    ),

                    @ApiResponse(
                            responseCode = "503", description = "Service Unavailable - El servicio no está disponible",
                            content = {
                                    @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = ErrorResponse.class))
                            }
                    )

            }
    )
    @PostMapping("/login")
//    public ResponseEntity<LoginResponseDto> login(LoginRequestDto request);
    public ResponseEntity create(@RequestBody UserDto user);
}
