package com.rifqimuhammadaziz.apimedicalrecordsystem;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class DemoTest {

    Calculator underTest = new Calculator();

    @Test
    void itShouldAddTwoNumbers() {
        // given
        int numberOne = 10;
        int numberTwo = 50;

        // when (actual)
        int result = underTest.add(numberOne, numberTwo);

        // then (expected)
        int expected = 60;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    class Calculator {
        int add(int a, int b) {
            return a + b;
        }
    }
}
