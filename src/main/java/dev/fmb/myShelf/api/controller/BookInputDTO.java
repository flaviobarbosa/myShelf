package dev.fmb.myShelf.api.controller;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
public class BookInputDTO {

    private String title;
    private Long isbn;
    private Long isbn13;
    private LocalDate startedAt;
    private LocalDate endedAt;
    private List<String> authors;

}
