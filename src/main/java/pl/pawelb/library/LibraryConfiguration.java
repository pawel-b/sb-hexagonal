package pl.pawelb.library;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.xml.ws.Endpoint;

@Configuration
@EnableSwagger2
class LibraryConfiguration {

    @Bean
    LibraryService libraryService(AuthorRepository authorRepository, BookRepository bookRepository) {
        return new LibraryServiceImpl(authorRepository, bookRepository);
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

    @Bean
    public Endpoint endpoint(Bus bus, LibraryService libraryService) {
        EndpointImpl endpoint = new EndpointImpl(bus, new LibraryWsServiceImpl(libraryService));
        endpoint.publish("/library");
        return endpoint;
    }
}
