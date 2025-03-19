package jeanmfdias.auto.app.api.infra.errors;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

class HandlerErrorTest {

    @Test
    void shouldReturnAnInstanceOfResponseEntity() throws JsonProcessingException {
        // ARRANGE
        var handlerError = new HandlerError();
        var error = new EntityNotFoundException("Not found");

        // ACT
        var response = handlerError.error404(error);

        // ASSERT
        Assertions.assertInstanceOf(ResponseEntity.class, response);
    }

}