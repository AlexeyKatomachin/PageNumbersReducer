package by.katomakhin.task.controller;


import by.katomakhin.task.dto.ReducedPageNumbersResponseDto;
import by.katomakhin.task.service.PrinterService;
import by.katomakhin.task.validator.PrinterValidator;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("printer")
public class PrinterController {
    private final PrinterService printerService;
    private final PrinterValidator printerValidator;

    @GetMapping("reducedPageNumbers")
    @Operation(summary = "Getting reduced form for arbitrary set of page numbers")
    public ReducedPageNumbersResponseDto reducedPageNumbers(@RequestParam("rawPageNumbers") String rawPageNumbers) {
        printerValidator.validateRawPageNumbers(rawPageNumbers);
        String reduced = printerService.reducePageNumbers(rawPageNumbers);
        return ReducedPageNumbersResponseDto.builder()
                .original(rawPageNumbers)
                .reduced(reduced)
                .build();
    }
}
