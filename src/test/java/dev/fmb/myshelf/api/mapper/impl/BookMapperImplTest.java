package dev.fmb.myshelf.api.mapper.impl;

import dev.fmb.myShelf.api.controller.BookInputDTO;
import dev.fmb.myShelf.api.mapper.BookMapper;
import dev.fmb.myShelf.api.mapper.impl.BookMapperImpl;
import dev.fmb.myShelf.domain.model.Book;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@DisplayName("BookMapper Tests")
public class BookMapperImplTest {

    @InjectMocks
    private BookMapperImpl bookMapper;

    @Mock
    private ModelMapper mapper;

    @Test
    @DisplayName("Should convert input DTO to entity")
    void shouldConvertInputDtoToEntity() {
        BookInputDTO inputDTO = BookInputDTO.builder()
                .title("Book Title")
                .isbn(1234567890L)
                .isbn13(1234567890123L)
                .authors(Arrays.asList("Author 1", "Author 2"))
                .startedAt(LocalDate.now().minusDays(5))
                .endedAt(LocalDate.now().minusDays(1))
                .build();

        Book book = Book.builder()
                .title(inputDTO.getTitle())
                .isbn(inputDTO.getIsbn())
                .isbn13(inputDTO.getIsbn13())
                .authors(inputDTO.getAuthors())
                .startedAt(inputDTO.getStartedAt())
                .endedAt(inputDTO.getEndedAt())
                .build();

        given(mapper.map(any(BookInputDTO.class), any())).willReturn(book);

        Book returnedBook = bookMapper.toEntity(inputDTO);

        Assertions.assertThat(returnedBook).isNotNull();
        Assertions.assertThat(returnedBook.getId()).isNull();
        Assertions.assertThat(returnedBook.getTitle()).isEqualTo(inputDTO.getTitle());
        Assertions.assertThat(returnedBook.getIsbn()).isEqualTo(inputDTO.getIsbn());
        Assertions.assertThat(returnedBook.getIsbn13()).isEqualTo(inputDTO.getIsbn13());
        Assertions.assertThat(returnedBook.getAuthors()).isEqualTo(inputDTO.getAuthors());
        Assertions.assertThat(returnedBook.getStartedAt()).isEqualTo(inputDTO.getStartedAt());
        Assertions.assertThat(returnedBook.getEndedAt()).isEqualTo(inputDTO.getEndedAt());

    }

}
