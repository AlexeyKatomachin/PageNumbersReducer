package by.katomakhin.task.validator;

import by.katomakhin.task.exception.EmptyPageNumbersRowException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrinterValidatorTest {

    @Test
    void validateRawPageNumbersThrowException() {
        PrinterValidator printerValidator = new PrinterValidator();

        assertThrows(EmptyPageNumbersRowException.class, () -> printerValidator.validateRawPageNumbers(null));
        assertThrows(EmptyPageNumbersRowException.class, () -> printerValidator.validateRawPageNumbers(""));
    }
}