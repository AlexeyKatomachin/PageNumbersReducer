package by.katomakhin.task.service.impl;

import by.katomakhin.task.service.PrinterService;
import by.katomakhin.task.util.ReducerUtil;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PrinterServiceImpl implements PrinterService {
    public String reducePageNumbers(String pages) {
        Set<Integer> convertedPages = ReducerUtil.convertStringArrToTreeSet(pages.split(","));
        return ReducerUtil.reducePageNumbers(convertedPages.toArray(Integer[]::new));
    }
}
