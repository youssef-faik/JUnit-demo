package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Order(1)
@Disabled
class CalculatorTest {
  Calculator underTest;
  
  // --- Lifecycle methods  ------------------------------------------------------------------------
  @BeforeAll
  static void beforeAll() {
  }
  
  @AfterAll
  static void afterAll() {
  }
  
  private static Stream<Arguments> testIntegerSubtraction() {
    return Stream.of(
            Arguments.of(10, 10, 0),
            Arguments.of(0, 0, 0),
            Arguments.of(10, 20, -10),
            Arguments.of(-10, 20, -30),
            Arguments.of(-10, -20, 10),
            Arguments.of(10, -20, 30)
    );
  }
  
  @BeforeEach
  void setUp() {
    underTest = new Calculator();
  }
  
  
  // --- Start Test methods  ------------------------------------------------------------------------
  
  // Naming test methods:
  // test<System/Method Under Test>_When<Condition or state change>_Then<Expected Result>
  
  @AfterEach
  void tearDown() {
  }
  
  @Test
  @DisplayName("10 / 2 = 5")
  void testIntDivision_WhenTenDividedByTwo_ReturnFive() {
    // Given
    int dividend = 10;
    int divisor = 2;
    int expected = 5;
    
    // When
    int actual = underTest.intDivision(dividend, divisor);
    
    // Then
    assertEquals(expected, actual, () -> dividend + " / " + divisor + " should return " + expected);
  }
  
  @Test
  @DisplayName("10 - 5 = 5")
  void testIntegerSubtraction_WhenTenMinusFive_ReturnFive() {
    // Given
    int minuend = 15;
    int subtrahend = 5;
    int expected = 10;
    
    // When
    int actual = underTest.integerSubtraction(minuend, subtrahend);
    
    // Then
    assertEquals(expected, actual, () -> minuend + " - " + subtrahend + " should return " + expected);
  }
  
  @Test
  @DisplayName("10 / 0 => ArithmeticException")
  void testIntegerDivision_WhenDivideByZero_ThrowDivisionByZeroException() {
    // Given
    int divisor = 0;
    int dividend = 10;
    String expectedExceptionMessage = "/ by zero";
    Class<ArithmeticException> expectedType = ArithmeticException.class;
    Executable executable = () -> underTest.intDivision(dividend, divisor);
    Supplier<String> stringSupplier = () -> dividend + " / " + divisor + " should throws ArithmeticException";
    
    // When & Then
    // assert the exception was thrown
    ArithmeticException arithmeticException = assertThrows(expectedType, executable, stringSupplier);
    
    // assert the message of the thrown exception
    assertEquals(expectedExceptionMessage, arithmeticException.getMessage(), "UnexpectedExceptionMessage");
  }
  
  // --- ParameterizedTests ------------------------------------------------------------------------
  @ParameterizedTest
  @MethodSource
  @DisplayName("Test IntegerSubtraction(int minuend, int subtrahend, int expected)")
  void testIntegerSubtraction(int minuend, int subtrahend, int expected) {
    // Given
    // When
    int actual = underTest.integerSubtraction(minuend, subtrahend);
    
    // Then
    assertEquals(expected, actual, () -> minuend + " - " + subtrahend + " should return " + expected);
  }
  
  @ParameterizedTest
  @CsvSource(
          {"10, 5, 2",
           "-10, 5, -2",
           "10, -5, -2",
           "-10, -5, 2",
           "0, 10, 0"
          }
  )
  @DisplayName("Test IntDivision(int minuend, int subtrahend, int expected)")
  void testIntDivision(int dividend, int divisor, int expected) {
    // Given
    // When
    int actual = underTest.intDivision(dividend, divisor);
    
    // Then
    assertEquals(expected, actual, () -> dividend + " / " + divisor + " should return " + expected);
  }
  
  // --- RepeatedTest ------------------------------------------------------------------------
  
  @RepeatedTest(value = 3, name = "😵 - Rep {currentRepetition} of {totalRepetitions}")
  void repeatedTest(RepetitionInfo repetitionInfo, TestInfo testInfo) {
    System.out.println(testInfo.getTestMethod().get().getName() + " | "+"Rep " + repetitionInfo.getCurrentRepetition() + " of " + repetitionInfo.getTotalRepetitions());
  }
}








