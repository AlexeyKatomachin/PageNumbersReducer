package by.katomakhin.task.validator;

import by.katomakhin.task.exception.EmptyPageNumbersRowException;
import by.katomakhin.task.exception.message.ExceptionMessage;
import org.springframework.stereotype.Component;

@Component
public class PrinterValidator {
    public void validateRawPageNumbers(String pages) {
        if (pages == null || "".equals(pages)) {
            throw new EmptyPageNumbersRowException(ExceptionMessage.EMPTY_PAGE_NUMBERS);
        }
    }
}
