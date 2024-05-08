package org.example.examen;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import org.example.examen.dto.ErrorResponse;
import org.example.examen.dto.TarjetaRequestDto;
import org.example.examen.dto.TarjetaResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

public interface ITarjetaApi {

    @Tag(name = "Tarjeta", description = "Procesar pago con tarjeta")
    @Operation(summary = "Procesar pago con tarjeta", description = "Procesar el pago con tarjeta proporcionada")
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
    @PostMapping("/pagar")
    public ResponseEntity<TarjetaResponseDto> procesarPago(TarjetaRequestDto request);
}
