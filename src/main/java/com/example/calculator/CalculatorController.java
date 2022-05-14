package com.example.calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * Javadoc.
 */
@RestController
class CalculatorController {
 /**
   * The name of bla bla bla.
 */
 @Autowired
 private Calculator calculator;
 /**
 * Method add two operands.
* @param  a  a first operand
* @param  b  a second operand
* @return     a result of sum od two operaands
 */
 @RequestMapping("/sum")
 String sum(@RequestParam("a") Integer a,
  @RequestParam("b") Integer b) {
  return String.valueOf(calculator.sum(a, b));
 }
}
