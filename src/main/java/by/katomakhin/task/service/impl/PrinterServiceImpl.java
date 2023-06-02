package by.katomakhin.task.service.impl;

import by.katomakhin.task.service.PrinterService;
import by.katomakhin.task.util.ReducerUtil;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class PrinterServiceImpl implements PrinterService {
    public String reducePageNumbers(String pages) {
        int[] convertedPages = ReducerUtil.convertStringArrToIntArr(pages.split(","));
        Arrays.sort(convertedPages);
        return ReducerUtil.reducePageNumbers(convertedPages);
    }
}
