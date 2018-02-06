package pl.pawelb.library;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
class LibraryConfiguration {

    @Bean
    LibraryService libraryService(BookRepository bookRepository) {
        return new LibraryServiceImpl(bookRepository);
    }

    @Bean
    LibraryController libraryController(LibraryService libraryService) {
        return new LibraryController(libraryService);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

}
