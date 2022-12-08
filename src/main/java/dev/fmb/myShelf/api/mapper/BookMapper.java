package dev.fmb.myShelf.api.mapper;

import dev.fmb.myShelf.api.controller.BookInputDTO;
import dev.fmb.myShelf.api.model.BookOutputDTO;
import dev.fmb.myShelf.domain.model.Book;

public interface BookMapper {

    Book toEntity(BookInputDTO inputDTO);

    BookOutputDTO toOutputDTO(Book book);

}
