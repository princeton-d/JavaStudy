package princeton.restapi.events;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import java.time.LocalDateTime;

import static princeton.restapi.events.EventDto.*;

@Component
public class EventValidator {

    public void validate(RequestEventDto requestEventDto, Errors errors) {

        if (isPriceValidateFailed(requestEventDto)) {
            errors.rejectValue("basePrice", "wrongValue", "basePrice is wrong.");
            errors.rejectValue("maxPrice", "wrongValue", "maxPrice is wrong.");
        }

        if (isEndEventDateTimeValidateFailed(requestEventDto)) {
            errors.rejectValue("endEventDateTime", "wrongValue", "endEventDateTime is wrong.");
        }

    }

    private boolean isPriceValidateFailed(RequestEventDto requestEventDto) {
        int basePrice = requestEventDto.getBasePrice();
        int maxPrice = requestEventDto.getMaxPrice();

        return basePrice > maxPrice && maxPrice != 0;
    }

    private boolean isEndEventDateTimeValidateFailed(RequestEventDto requestEventDto) {
        LocalDateTime endEventDateTime = requestEventDto.getEndEventDateTime();
        LocalDateTime beginEventDateTime = requestEventDto.getBeginEventDateTime();
        LocalDateTime closeEnrollmentDateTime = requestEventDto.getCloseEnrollmentDateTime();
        LocalDateTime beginEnrollmentDateTime = requestEventDto.getBeginEnrollmentDateTime();

        return (endEventDateTime.isBefore(beginEventDateTime) ||
                endEventDateTime.isBefore(closeEnrollmentDateTime) ||
                endEventDateTime.isBefore(beginEnrollmentDateTime));
    }

}
