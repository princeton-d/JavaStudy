package princeton.securitytest.member.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MemberController {

    @GetMapping("/api/log/test")
    public String logTest() {
        log.info("start test controller");
        log.info("end test controller");
        return "OK";
    }

}
