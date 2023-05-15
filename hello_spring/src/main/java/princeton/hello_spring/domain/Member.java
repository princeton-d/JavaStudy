package princeton.hello_spring.domain;

import lombok.Builder;
import lombok.Getter;
import princeton.hello_spring.exception.AlreadyRegisteredException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Member() {}

    @Builder
    public Member(String name) {
        this.name = name;
    }
}