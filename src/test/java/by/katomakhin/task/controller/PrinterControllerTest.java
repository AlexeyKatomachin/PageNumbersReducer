package by.katomakhin.task.controller;

import by.katomakhin.task.dto.ReducedPageNumbersResponseDto;
import by.katomakhin.task.service.impl.PrinterServiceImpl;
import by.katomakhin.task.validator.PrinterValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PrinterControllerTest {
    @Mock
    private PrinterValidator printerValidator;
    @Mock
    private PrinterServiceImpl printerService;

    @Test
    void reducedPageNumbers() {
        String reduced = "1-4";
        String original = "1,2,3,4";
        Mockito.when(printerService.reducePageNumbers(Mockito.any())).thenReturn(reduced);

        PrinterController controller = new PrinterController(printerService, printerValidator);
        ReducedPageNumbersResponseDto response = controller.reducedPageNumbers(original);

        assertNotNull(response);
        assertEquals(response.getReduced(), reduced);
        assertEquals(response.getOriginal(), original);

        Mockito.verify(printerService).reducePageNumbers(Mockito.any());
        Mockito.verifyNoMoreInteractions(printerService);
        Mockito.verify(printerValidator).validateRawPageNumbers(original);
        Mockito.verifyNoMoreInteractions(printerValidator);
    }
}