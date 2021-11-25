package main.Java0;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTimeout;

public class TimeOutExample {

    // timed out after 5 seconds
    @Test
    void test_timeout_fail() {
//         assertTimeout(Duration.ofSeconds(5), () -> delaySecond(10)); // this will fail,becasue 10>5

        assertTimeout(Duration.ofSeconds(5), () -> delaySecond(1)); // pass,because 1<5
    }

    void delaySecond(int second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

