package by.katomakhin.task.service;

import by.katomakhin.task.service.impl.PrinterServiceImpl;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class PrinterServiceImplTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/ReducePageNumbers.csv", numLinesToSkip = 1)
    void reducePageNumbers(String input, String expected) {
        PrinterServiceImpl printerService = new PrinterServiceImpl();

        String result = printerService.reducePageNumbers(input);

        assertNotNull(result);
        assertEquals(result, expected);
    }
}