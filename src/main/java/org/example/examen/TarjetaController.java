package org.example.examen;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import org.example.examen.dto.LoginRequestDto;
import org.example.examen.dto.LoginResponseDto;
import org.example.examen.dto.TarjetaRequestDto;
import org.example.examen.dto.TarjetaResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class TarjetaController implements ITarjetaApi {

    @PostMapping("/pagar")
    public ResponseEntity<TarjetaResponseDto> pagar(@RequestBody TarjetaResponseDto request) {
        return null;
    }

    @Override
    @PostMapping(value = "/pagar", produces = "application/json")
    public ResponseEntity<TarjetaResponseDto> procesarPago(@RequestBody TarjetaRequestDto request) {
        ObjectMapper mapper = new ObjectMapper();
        String json;
        try {
            json = mapper.writeValueAsString(request);
            JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);
            JsonSchema jsonSchema = factory.getSchema(TarjetaController.class.getClassLoader().getResourceAsStream("schemas/tarjeta.json"));
            JsonNode jsonNode = mapper.readTree(json);
            Set<ValidationMessage> errors = jsonSchema.validate(jsonNode);

            String errorsCombined = "";
            for (ValidationMessage error : errors) {
                errorsCombined += error.toString() + "\n";
            }

            if (errors.size() > 0) {
                return ResponseEntity.badRequest().body(new TarjetaResponseDto(400, "Please fix your JSON!\n" + errorsCombined));
            }
            // Simulación de un procesamiento de pago exitoso
            return ResponseEntity.ok(new TarjetaResponseDto(0, "Payment successful"));

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new TarjetaResponseDto(400, "Error processing payment"));
        }
    }
}
