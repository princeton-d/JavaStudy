package princeton.restapi.events;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import static princeton.restapi.events.EventDto.*;

@Mapper
public interface EventMapper {

    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

    RequestEventDto toRequestEventDto(Event event);

    Event toEventEntity(RequestEventDto requestEventDto);

}
