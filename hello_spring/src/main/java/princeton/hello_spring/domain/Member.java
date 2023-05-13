package princeton.hello_spring.domain;

import lombok.Getter;
import princeton.hello_spring.exception.AlreadyRegisteredException;

@Getter
public class Member {

    private Long id;
    private String name;

    public void createMemberInfo(Long id, String name) throws AlreadyRegisteredException {
        if (this.id != null) {
            throw new AlreadyRegisteredException("한번 등록한 회원정보는 다시 등록할 수 없습니다.");
        }

        this.id = id;
        this.name = name;
    }
}
