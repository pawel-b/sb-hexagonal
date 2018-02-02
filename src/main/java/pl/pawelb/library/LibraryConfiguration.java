package pl.pawelb.library;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LibraryConfiguration {

    @Bean
    LibraryService libraryService(BookRepository bookRepository) {
         return new LibraryServiceImpl(bookRepository);
    }

    @Bean
    LibraryController libraryController(LibraryService libraryService) {
        return new LibraryController(libraryService);
    }

}
