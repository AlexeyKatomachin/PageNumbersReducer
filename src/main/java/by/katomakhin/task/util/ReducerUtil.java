package by.katomakhin.task.util;

import by.katomakhin.task.exception.InvalidPageNumbersException;
import by.katomakhin.task.exception.message.ExceptionMessage;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReducerUtil {

    public static String reducePageNumbers(Integer[] pages) {
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

    public static Set<Integer> convertStringArrToTreeSet(String[] pages) {
        return Stream.of(pages)
                .filter(x -> !"".equals(x))
                .map(x -> {
                    try {
                        int page = Integer.parseInt(x.trim());
                        if (page <= 0) {
                            throw new NumberFormatException();
                        }
                        return page;
                    } catch (NumberFormatException ex) {
                        throw new InvalidPageNumbersException(String.format(ExceptionMessage.INVALID_PAGE_NUMBERS, x));
                    }
                }).collect(Collectors.toCollection(TreeSet::new));
    }
}
