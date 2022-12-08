package dev.fmb.myShelf.api.model;

import dev.fmb.myShelf.api.controller.BookInputDTO;
import dev.fmb.myShelf.domain.model.Book;
import dev.fmb.myShelf.domain.service.AddBookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private AddBookService addBookService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity<BookOutputDTO> add(@RequestBody BookInputDTO resource) {
        Book book = mapper.map(resource, Book.class);

        book = addBookService.add(book);

        BookOutputDTO dto = mapper.map(book, BookOutputDTO.class);

        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
}
