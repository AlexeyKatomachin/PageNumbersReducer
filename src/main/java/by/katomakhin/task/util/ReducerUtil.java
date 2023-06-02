package by.katomakhin.task.util;

import by.katomakhin.task.exception.InvalidPageNumbersException;
import by.katomakhin.task.exception.message.ExceptionMessage;

public class ReducerUtil {
    public static int[] convertStringArrToIntArr(String[] pages) {
        int[] convertedPages = new int[pages.length];
        for (int i = 0; i < pages.length; i++) {
            try {
                convertedPages[i] = Integer.parseInt(pages[i]);
            } catch (NumberFormatException ex) {
                throw new InvalidPageNumbersException(String.format(ExceptionMessage.INVALID_PAGE_NUMBERS, pages[i]));
            }
            if (convertedPages[i] < 0) {
                throw new InvalidPageNumbersException(String.format(ExceptionMessage.INVALID_PAGE_NUMBERS, pages[i]));
            }
        }
        return convertedPages;
    }

    public static String reducePageNumbers(int[] pages) {
        StringBuilder result = new StringBuilder();
        int previous = pages[0];
        boolean consecutive = false;
        result.append(previous);
        for (int i = 1; i < pages.length; i++) {
            if (consecutive) {
                if (pages[i] != previous + 1) {
                    consecutive = false;
                    result.append(previous).append(',').append(pages[i]);
                }
            } else {
                if (pages[i] == previous + 1) {
                    consecutive = true;
                    result.append('-');
                } else {
                    result.append(',').append(pages[i]);
                }
            }
            previous = pages[i];
        }
        if (consecutive) {
            result.append(previous);
        }
        return result.toString();
    }
}
