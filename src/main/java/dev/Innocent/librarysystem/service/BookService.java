package dev.Innocent.librarysystem.service;

import dev.Innocent.librarysystem.DTO.BookDTO;

import java.util.List;

public interface BookService {
    BookDTO registerBook(BookDTO bookDTO);
    List<BookDTO> getAllBooks();

    BookDTO getBookById(Long bookId);
}
