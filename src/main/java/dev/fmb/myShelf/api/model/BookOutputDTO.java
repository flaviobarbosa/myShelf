package dev.fmb.myShelf.api.model;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookOutputDTO {

    private Long id;
    private String title;
    private Long isbn;
    private Long isbn13;
    private LocalDate startedAt;
    private LocalDate endedAt;
    private List<String> authors;

}
