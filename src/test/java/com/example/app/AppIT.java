package com.example.app;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class AppIT {
    @Test
    void app_runs() {
        // A simple "integration" style test; in real projects this could start servers, etc.
        Calculator c = new Calculator();
        assertThat(c.add(1, 1)).isEqualTo(2);
    }
}
