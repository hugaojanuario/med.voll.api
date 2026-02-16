package med.voll.api.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratamentoDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity entityNotFound(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValid(MethodArgumentNotValidException exception){
        var err = exception.getFieldErrors();

        return ResponseEntity.badRequest().body(err.stream().map(DataErrorValid::new).toList());
    }

    private record DataErrorValid(String atributo, String message ){
        public DataErrorValid(FieldError err){
            this(err.getField(), err.getDefaultMessage());
        }
    }

}
