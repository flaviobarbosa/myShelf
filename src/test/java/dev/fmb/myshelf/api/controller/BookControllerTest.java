package dev.fmb.myshelf.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.fmb.myShelf.api.controller.BookInputDTO;
import dev.fmb.myShelf.api.model.BookOutputDTO;
import dev.fmb.myShelf.domain.model.Book;
import dev.fmb.myShelf.domain.service.AddBookService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.time.LocalDate;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class BookControllerTest {

    private static final String BOOK_PATH = "/books";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AddBookService addBookService;

    @MockBean
    private ModelMapper mapper;

    @Test @DisplayName("Should add a book to shelf")
    void shouldAddBookToShelf() throws Exception {
        BookInputDTO inputDTO = BookInputDTO.builder()
                .title("Random title")
                .isbn(1234567890L)
                .startedAt(LocalDate.now())
                .authors(Arrays.asList("Author 1"))
                .build();

        BookOutputDTO outputDTO = BookOutputDTO.builder()
                .id(1L)
                .title("Random title")
                .isbn(1234567890L)
                .startedAt(LocalDate.now())
                .authors(Arrays.asList("Author 1"))
                .build();

        Book bookWithoutId = Book.builder()
                .title("Random title")
                .isbn(1234567890L)
                .startedAt(LocalDate.now())
                .authors(Arrays.asList("Author 1"))
                .build();

        Book createdBook = Book.builder()
                .id(1L)
                .title("Random title")
                .isbn(1234567890L)
                .startedAt(LocalDate.now())
                .authors(Arrays.asList("Author 1"))
                .build();

        given(mapper.map(any(BookInputDTO.class), ArgumentMatchers.any())).willReturn(bookWithoutId);
        given(addBookService.add(any(Book.class))).willReturn(createdBook);
        given(mapper.map(any(Book.class), ArgumentMatchers.any())).willReturn(outputDTO);

        MockHttpServletRequestBuilder request =
                post(BOOK_PATH)
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(inputDTO))
        ;

        this.mockMvc.perform(request)
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNotEmpty())
        ;
    }
}
