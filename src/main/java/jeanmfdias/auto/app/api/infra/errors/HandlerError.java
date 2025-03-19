package jeanmfdias.auto.app.api.infra.errors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class HandlerError {

    private final ObjectMapper objectMapper;

    public HandlerError() {
        objectMapper = new ObjectMapper();
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> error404(EntityNotFoundException e) throws JsonProcessingException {
        Map<String, String> json = Map.of("message", e.getMessage());
        return ResponseEntity.status(404).body(this.objectMapper.writeValueAsString(json));
    }

}
