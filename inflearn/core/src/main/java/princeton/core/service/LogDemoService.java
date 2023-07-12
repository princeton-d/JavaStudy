package princeton.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import princeton.core.common.MyLogger;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final MyLogger myLogger;

    public void logic(String id) {
        myLogger.log("service id = " + id);
    }
}
