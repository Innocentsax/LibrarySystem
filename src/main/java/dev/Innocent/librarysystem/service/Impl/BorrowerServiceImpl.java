package dev.Innocent.librarysystem.service.Impl;

import dev.Innocent.librarysystem.DTO.BorrowerDTO;
import dev.Innocent.librarysystem.handler.BookAlreadyBorrowedException;
import dev.Innocent.librarysystem.handler.BookNotBorrowedException;
import dev.Innocent.librarysystem.handler.DuplicateBorrowerEmailException;
import dev.Innocent.librarysystem.handler.ResourceNotFoundException;
import dev.Innocent.librarysystem.model.Book;
import dev.Innocent.librarysystem.model.User;
import dev.Innocent.librarysystem.repository.BookRepository;
import dev.Innocent.librarysystem.repository.UserRepository;
import dev.Innocent.librarysystem.service.BorrowerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowerServiceImpl implements BorrowerService {

    private final UserRepository borrowerRepository;
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public BorrowerServiceImpl(UserRepository borrowerRepository, BookRepository bookRepository, ModelMapper modelMapper) {
        this.borrowerRepository = borrowerRepository;
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public BorrowerDTO registerBorrower(BorrowerDTO borrowerDTO) {
        if (borrowerRepository.existsByEmail(borrowerDTO.getEmail())) {
            throw new DuplicateBorrowerEmailException("A borrower with this email already exists.");
        }

        User borrower = modelMapper.map(borrowerDTO, User.class);
        User savedBorrower = borrowerRepository.save(borrower);
        return modelMapper.map(savedBorrower, BorrowerDTO.class);
    }
    @Override
    public void borrowBook(Long borrowerId, Long bookId) {
        User borrower = borrowerRepository.findById(borrowerId)
                .orElseThrow(() -> new ResourceNotFoundException("Borrower not found with id: " + borrowerId));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + bookId));
        if (book.getBorrower() != null) {
            throw new BookAlreadyBorrowedException("Book is already borrowed");
        }
        book.setBorrower(borrower);
        bookRepository.save(book);
    }

    @Override
    public void returnBook(Long borrowerId, Long bookId) {
        User borrower = borrowerRepository.findById(borrowerId)
                .orElseThrow(() -> new ResourceNotFoundException("Borrower not found with id: " + borrowerId));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + bookId));
        if ( book.getBorrower() == null || !book.getBorrower().equals(borrower)) {
            throw new BookNotBorrowedException("Book was not borrowed by this borrower");
        }
        book.setBorrower(null);
        bookRepository.save(book);
    }

    @Override
    public List<BorrowerDTO> getAllBorrowers() {
        return borrowerRepository.findAll().stream()
                .map(borrower -> modelMapper.map(borrower, BorrowerDTO.class))
                .toList();
    }

    @Override
    public BorrowerDTO getBorrowerById(Long borrowerId) {
        User borrower = borrowerRepository.findById(borrowerId)
                .orElseThrow(() -> new ResourceNotFoundException("Borrower not found with id: " + borrowerId));
        return modelMapper.map(borrower, BorrowerDTO.class);
    }

}