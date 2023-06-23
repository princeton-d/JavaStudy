package princeton.restapi.events;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.io.IOException;

@JsonComponent
public class ErrorsSerializer extends JsonSerializer<Errors> {

    @Override
    public void serialize(Errors errors, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartArray();
        errors.getFieldErrors().forEach(error -> writeFieldError(gen, error));
        errors.getGlobalErrors().forEach(error -> writeGlobalError(gen, error));
        gen.writeEndArray();
    }

    private void writeFieldError(JsonGenerator gen, FieldError error) {
        try {
            gen.writeStartObject();
            gen.writeStringField("field", error.getField());
            gen.writeStringField("objectName", error.getObjectName());
            gen.writeStringField("code", error.getCode());
            gen.writeStringField("defaultMessage", error.getDefaultMessage());
            Object rejectedValue = error.getRejectedValue();
            if (rejectedValue != null) {
                gen.writeStringField("rejectedValue", rejectedValue.toString());
            }
            gen.writeEndObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeGlobalError(JsonGenerator gen, ObjectError error) {
        try {
            gen.writeStartObject();
            gen.writeStringField("objectName", error.getObjectName());
            gen.writeStringField("code", error.getCode());
            gen.writeStringField("defaultMessage", error.getDefaultMessage());
            gen.writeEndObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
