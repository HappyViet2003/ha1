package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "40";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when dividing by zero")
    void testDivisionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when drawing the square root of a negative number")
    void testSquareRootOfNegative() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should not allow multiple decimal dots")
    void testMultipleDecimalDots() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(7);
        calc.pressDotKey();
        calc.pressDigitKey(8);

        String expected = "1.78";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    // Erster Grüner Test von Viet Anh Hoenemann 587778
    @Test
    @DisplayName("should display result after multiplying two negative numbers")
    void testNegativeMultiplication() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(3);
        calc.pressNegativeKey();
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(9);
        calc.pressNegativeKey();
        calc.pressEqualsKey();

        String expected = "27";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    // Erster Roter Test von Viet Anh Hoenemann 587778 -- Fixed
    @Test
    @DisplayName("should not completely reset the calculator after pressing the clear key once")
    void testClearKey() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(4);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(5);
        calc.pressClearKey();

        calc.pressDigitKey(6);
        calc.pressEqualsKey();

        String expected = "10";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    // Zweiter Roter Test von Viet Anh Hoenemann 587778 -- Fixed
    @Test
    @DisplayName("should continue adding the last number after pressing the equals key multiple times")
    void testMultipleEqualsKeys() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();
        calc.pressEqualsKey();
        calc.pressEqualsKey();

        String expected = "7";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
}

