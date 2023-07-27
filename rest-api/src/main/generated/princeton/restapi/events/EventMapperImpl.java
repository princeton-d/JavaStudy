package princeton.restapi.events;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-27T16:33:38+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
public class EventMapperImpl implements EventMapper {

    @Override
    public EventDto.RequestEventDto toRequestEventDto(Event event) {
        if ( event == null ) {
            return null;
        }

        EventDto.RequestEventDto.RequestEventDtoBuilder requestEventDto = EventDto.RequestEventDto.builder();

        requestEventDto.name( event.getName() );
        requestEventDto.description( event.getDescription() );
        requestEventDto.beginEnrollmentDateTime( event.getBeginEnrollmentDateTime() );
        requestEventDto.closeEnrollmentDateTime( event.getCloseEnrollmentDateTime() );
        requestEventDto.beginEventDateTime( event.getBeginEventDateTime() );
        requestEventDto.endEventDateTime( event.getEndEventDateTime() );
        requestEventDto.location( event.getLocation() );
        requestEventDto.basePrice( event.getBasePrice() );
        requestEventDto.maxPrice( event.getMaxPrice() );
        requestEventDto.limitOfEnrollment( event.getLimitOfEnrollment() );

        return requestEventDto.build();
    }

    @Override
    public Event toEventEntity(EventDto.RequestEventDto requestEventDto) {
        if ( requestEventDto == null ) {
            return null;
        }

        Event.EventBuilder event = Event.builder();

        event.name( requestEventDto.getName() );
        event.description( requestEventDto.getDescription() );
        event.beginEnrollmentDateTime( requestEventDto.getBeginEnrollmentDateTime() );
        event.closeEnrollmentDateTime( requestEventDto.getCloseEnrollmentDateTime() );
        event.beginEventDateTime( requestEventDto.getBeginEventDateTime() );
        event.endEventDateTime( requestEventDto.getEndEventDateTime() );
        event.location( requestEventDto.getLocation() );
        event.basePrice( requestEventDto.getBasePrice() );
        event.maxPrice( requestEventDto.getMaxPrice() );
        event.limitOfEnrollment( requestEventDto.getLimitOfEnrollment() );

        return event.build();
    }
}
