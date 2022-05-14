package com.example.calculator;

import org.springframework.stereotype.Service;
/**
 * Javadoc.
 */
@Service
public final class Calculator {
 /**
 * Method add two operands.
* @param  a  a first operand
* @param  b  a second operand
* @return     a result of sum od two operaands
 */
 public int sum(final int a,  final int b) {
 return a + b;
 }
}
