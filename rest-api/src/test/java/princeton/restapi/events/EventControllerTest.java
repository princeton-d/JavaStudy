package princeton.restapi.events;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.startsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static princeton.restapi.events.EventDto.*;

@SpringBootTest
@AutoConfigureMockMvc
public class EventControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    EventRepository eventRepository;

    @Test
    public void createEvent() throws Exception {
        RequestEventDto event = RequestEventDto.builder()
                .name("Spring")
                .description("REST API Development with Spring")
                .beginEnrollmentDateTime(LocalDateTime.of(2023, 6, 21, 14, 0))
                .closeEnrollmentDateTime(LocalDateTime.of(2023, 6, 22, 14, 0))
                .beginEventDateTime(LocalDateTime.of(2023, 6, 25, 14, 0))
                .endEventDateTime(LocalDateTime.of(2023, 6, 26, 14, 0))
                .basePrice(100)
                .maxPrice(200)
                .limitOfEnrollment(100)
                .location("강남역 D2 스타텁 팩토리")
                .build();

        mockMvc.perform(post("/api/events")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaTypes.HAL_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(event)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(header().exists(HttpHeaders.LOCATION))
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, startsWith(MediaTypes.HAL_JSON_VALUE)));
    }

    @Test
    public void badRequest() throws Exception {
        Event event = Event.builder()
                .name("Spring")
                .description("REST API Development with Spring")
                .beginEnrollmentDateTime(LocalDateTime.of(2023, 6, 21, 14, 0))
                .closeEnrollmentDateTime(LocalDateTime.of(2023, 6, 22, 14, 0))
                .beginEventDateTime(LocalDateTime.of(2023, 6, 25, 14, 0))
                .endEventDateTime(LocalDateTime.of(2023, 6, 26, 14, 0))
                .basePrice(100)
                .maxPrice(200)
                .limitOfEnrollment(100)
                .location("강남역 D2 스타텁 팩토리")
                .offline(true)
                .free(true)
                .build();

        mockMvc.perform(post("/api/events")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaTypes.HAL_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(event)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void createEventBedRequestEmptyInput() throws Exception {
        RequestEventDto requestEventDto = RequestEventDto.builder()
//                .beginEnrollmentDateTime(LocalDateTime.of(2023, 6, 21, 14, 0))
//                .closeEnrollmentDateTime(LocalDateTime.of(2023, 6, 20, 14, 0))
//                .beginEventDateTime(LocalDateTime.of(2023, 6, 19, 14, 0))
//                .endEventDateTime(LocalDateTime.of(2023, 6, 18, 14, 0))
                .build();

        mockMvc.perform(post("/api/events")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestEventDto)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void createEventBedRequestWrongInput() throws Exception {
        RequestEventDto requestEventDto = RequestEventDto.builder()
                .name("Spring")
                .description("REST API Development with Spring")
                .beginEnrollmentDateTime(LocalDateTime.of(2023, 6, 21, 14, 0))
                .closeEnrollmentDateTime(LocalDateTime.of(2023, 6, 20, 14, 0))
                .beginEventDateTime(LocalDateTime.of(2023, 6, 19, 14, 0))
                .endEventDateTime(LocalDateTime.of(2023, 6, 18, 14, 0))
                .basePrice(10000)
                .maxPrice(200)
                .limitOfEnrollment(100)
                .location("강남역 D2 스타텁 팩토리")
                .build();

        mockMvc.perform(post("/api/events")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestEventDto)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

}
