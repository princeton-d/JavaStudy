package princeton.core.member.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import princeton.core.member.domain.role.Grade;

import static lombok.AccessLevel.*;

@Getter
@Builder
@AllArgsConstructor(access = PROTECTED)
public class Member {

    private Long id;
    private String name;
    private Grade grade;

}
