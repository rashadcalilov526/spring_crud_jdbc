package spring.crud.jdbc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static spring.crud.jdbc.model.exception.ValidationExceptionCode.FIELD_CANT_BE_BLANK;
import static spring.crud.jdbc.model.exception.ValidationExceptionCode.FIELD_CANT_BE_NULL;
import static spring.crud.jdbc.model.exception.ValidationExceptionCode.INVALID_MAX_AGE;
import static spring.crud.jdbc.model.exception.ValidationExceptionCode.INVALID_MIN_AGE;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto {

    @NotNull(message = FIELD_CANT_BE_NULL)
    @NotBlank(message = FIELD_CANT_BE_BLANK)
    private String name;

    @Min(value = 18, message = INVALID_MIN_AGE)
    @Max(value = 65, message = INVALID_MAX_AGE)
    @NotNull(message = FIELD_CANT_BE_NULL)
    private Integer age;
}
