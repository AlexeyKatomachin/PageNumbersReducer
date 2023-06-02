package by.katomakhin.task.util;

import by.katomakhin.task.exception.InvalidPageNumbersException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReducerUtilTest {

    @Test
    void convertStringArrToIntArr() {
        String[] pages = {"1","2"};
        int[] convertedPages = ReducerUtil.convertStringArrToIntArr(pages);
        assertNotNull(convertedPages);
        assertEquals(convertedPages[0], Integer.parseInt(pages[0]));
        assertEquals(convertedPages[1], Integer.parseInt(pages[1]));
    }

    @Test
    void convertStringArrToIntArrThrowException() {
        String[] pagesNotDigit = {"1","a"};
        String[] pagesNotPositive = {"1","-1"};

        assertThrows(InvalidPageNumbersException.class,() -> ReducerUtil.convertStringArrToIntArr(pagesNotDigit));
        assertThrows(InvalidPageNumbersException.class,() -> ReducerUtil.convertStringArrToIntArr(pagesNotPositive));
    }

    @Test
    void reducePageNumbers() {
        int[] original = {1,2,3,4,5,6,7,8,11,19,21,22,23,32};
        String reduced = "1-8,11,19,21-23,32";

        String result = ReducerUtil.reducePageNumbers(original);

        assertNotNull(result);
        assertEquals(result, reduced);
    }
}