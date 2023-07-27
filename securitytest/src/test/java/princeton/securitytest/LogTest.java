package princeton.securitytest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
public class LogTest {

    @Test
    @DisplayName("로그 테스트")
    void logTest() throws Exception {
        long startTime = System.currentTimeMillis();

        for (long i = 0; i < 1000000000L; i++) {
        }

        log.trace("Trace Log");
        log.debug("Debug Log");
        log.info("Info Log");
        log.warn("Warn Log");
        log.error("Error log");
        log.info("경과 시간 = {}ms", System.currentTimeMillis() - startTime);
    }

}
