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


    //TODO hier weitere Tests erstellen

    //1. Teilaufgabe: Grüner Test

    @Test
    @DisplayName("should display numbers after multiplying two positive multi-digit numbers")
    void testPositiveMultiplication() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(8);
        calc.pressEqualsKey();

        String expected = "40";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    //2. Teilaufgabe: Rote Tests

    @Test
    @DisplayName("should clear screen after clicking on clear key once, latest result maintained")
    void pressClearKey() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();
        calc.pressClearKey();

        String expectedScreen = "0";
        String actualScreen = calc.readScreen();

        double expectedValue = 1.0;
        double actualValue = calc.getLatestValue();

        String expectedOperation = "+";
        String actualOperation = calc.getLatestOperation();

        assertEquals(expectedScreen, actualScreen);
        assertEquals(expectedValue, actualValue);
        assertEquals(expectedOperation, actualOperation);
    }

    //@Test
    //@DisplayName("should clear screen and latest result after clicking on clear key twice")
    //void pressClearKeyTwice() {
      //  Calculator calc = new Calculator();

        //calc.pressDigitKey(2);
        //calc.pressBinaryOperationKey("+");
        //calc.pressDigitKey(2);
        //calc.pressEqualsKey();
        //calc.pressClearKey();
        //calc.pressClearKey();

        //String expectedScreen = "0";
        //String actualScreen = calc.readScreen();

        //double expectedValue = 0.0;
        //double actualValue = calc.getLatestValue();

        //String expectedOperation = "";
        //String actualOperation = calc.getLatestOperation();

        //assertEquals(expectedScreen, actualScreen);
        //assertEquals(expectedValue, actualValue);
        //assertEquals(expectedOperation, actualOperation);
    //}

    @Test
    @DisplayName("should remain result after pressing on equal key multiple times")
    void multipleEqualKeys() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(4);
        calc.pressEqualsKey();
        calc.pressEqualsKey();

        String expectedScreen = "4";
        String actualScreen = calc.readScreen();

        assertEquals(expectedScreen, actualScreen); //assert = behaupten
    }

}

