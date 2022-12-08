package dev.fmb.myShelf.api.mapper.impl;

import dev.fmb.myShelf.api.controller.BookInputDTO;
import dev.fmb.myShelf.api.mapper.BookMapper;
import dev.fmb.myShelf.api.model.BookOutputDTO;
import dev.fmb.myShelf.domain.model.Book;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookMapperImpl implements BookMapper {

    @Autowired
    private ModelMapper mapper;

    public Book toEntity(BookInputDTO inputDTO) {
        return mapper.map(inputDTO, Book.class);
    }

    @Override
    public BookOutputDTO toOutputDTO(Book book) {
        return mapper.map(book, BookOutputDTO.class);
    }

}
