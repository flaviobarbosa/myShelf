package dev.fmb.myShelf.domain.model;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {

    private Long id;
    private String title;
    private Long isbn;
    private Long isbn13;
    private LocalDate startedAt;
    private LocalDate endedAt;
    private List<String> authors;

}
