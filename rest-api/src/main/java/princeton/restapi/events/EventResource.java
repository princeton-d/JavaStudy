package princeton.restapi.events;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

import static princeton.restapi.events.EventDto.*;

@Getter
@AllArgsConstructor
public class EventResource extends RepresentationModel<EventResource> {

    @JsonProperty("data")
    private List<RequestEventDto> dtos;

}
