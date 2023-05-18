package princeton.toy.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Builder
@Table(name = "users")
public class User {

    @Id @GeneratedValue
    private Long id;
    private String userId;
    private String userPassword;
    private String username;

    protected User() {}

    protected User(Long id, String userId, String userPassword, String username) {
        this.id = id;
        this.userId = userId;
        this.userPassword = userPassword;
        this.username = username;
    }
}
