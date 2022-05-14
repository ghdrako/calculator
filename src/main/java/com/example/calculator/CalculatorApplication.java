package com.example.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Javadoc.
 */
@SpringBootApplication
public final class CalculatorApplication {
    private CalculatorApplication() {
       //not called
    }
    /**
       * Method add two operands.
       * @param  args  args
    */
    public static void main(final String[] args) {
        SpringApplication.run(CalculatorApplication.class, args);
    }
}
