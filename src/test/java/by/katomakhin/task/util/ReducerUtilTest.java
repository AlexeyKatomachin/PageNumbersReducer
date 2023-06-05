package by.katomakhin.task.util;

import by.katomakhin.task.exception.InvalidPageNumbersException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReducerUtilTest {

    @Test
    void convertStringArrToIntArr() {
        String[] pages = {" 2", "1"};
        Integer[] convertedPages = ReducerUtil.convertStringArrToTreeSet(pages).toArray(Integer[]::new);
        assertNotNull(convertedPages);
        assertEquals(convertedPages[0], Integer.parseInt(pages[1]));
        assertEquals(convertedPages[1], Integer.parseInt(pages[0].trim()));
    }

    @Test
    void convertStringArrToIntArrThrowException() {
        String[] pagesNotDigit = {"1", "a"};
        String[] pagesNotPositive = {"1", "-1"};

        assertThrows(InvalidPageNumbersException.class, () -> ReducerUtil.convertStringArrToTreeSet(pagesNotDigit));
        assertThrows(InvalidPageNumbersException.class, () -> ReducerUtil.convertStringArrToTreeSet(pagesNotPositive));
    }

    @Test
    void reducePageNumbers() {
        Integer[] original = {1, 2, 3, 4, 5, 6, 7, 8, 11, 19, 21, 22, 23, 32};
        String reduced = "1-8,11,19,21-23,32";

        String result = ReducerUtil.reducePageNumbers(original);

        assertNotNull(result);
        assertEquals(result, reduced);
    }
}