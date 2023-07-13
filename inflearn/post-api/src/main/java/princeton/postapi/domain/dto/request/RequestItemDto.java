package princeton.postapi.domain.dto.request;

import lombok.*;

import static lombok.AccessLevel.*;

@Getter
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
public class RequestItemDto {

    private String title;
    private String content;
    private int price;
    private String username;

}
