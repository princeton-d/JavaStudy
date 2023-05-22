package princeton.toy.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class UsersRepositoryTest {

    @Autowired
    UsersRepository usersRepository;

    @Test
    public void save() throws Exception {
        //given

        //when

        //then
    }

}