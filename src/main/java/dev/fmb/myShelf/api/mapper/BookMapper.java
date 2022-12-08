package dev.fmb.myShelf.api.mapper;

import dev.fmb.myShelf.api.controller.BookInputDTO;
import dev.fmb.myShelf.domain.model.Book;

public interface BookMapper {

    Book toEntity(BookInputDTO inputDTO);

}
