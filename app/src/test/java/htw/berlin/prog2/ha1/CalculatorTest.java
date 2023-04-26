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

    @Test
    @DisplayName("should display result after getting the multiplication 20 and 5")
    void testmultiplication() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "100";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }



    @Test
    @DisplayName("should display result after getting the multiplication via enter-key")
    void TestOpertationEqualsKey(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(4);
        calc.pressEqualsKey();
        calc.pressEqualsKey();
        calc.pressEqualsKey();

        String expected = "256";
        String actual = calc.readScreen();

        assertEquals(expected,actual);
    }

        @Test
        @DisplayName("should display value on screen starting with 0 and a decimal point")
        void testDecimalDots() {
            Calculator calc = new Calculator();

            calc.pressDotKey();
            calc.pressDigitKey(7);

            String expected = "0.7";
            String actual = calc.readScreen();

            assertEquals(expected, actual);
        }


    @Test
    @DisplayName("should display value on screen via pressing multiple times the %-key")
    void testPercent() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressUnaryOperationKey("%");
        calc.pressUnaryOperationKey("%");




        String expected = "1.0E-4";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error message when zero is divided by zero")
    void TestZeroDivisionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

}

