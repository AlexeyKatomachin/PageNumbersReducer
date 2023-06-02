package by.katomakhin.task.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class ReducedPageNumbersResponseDto {
    private String original;
    private String reduced;
}
