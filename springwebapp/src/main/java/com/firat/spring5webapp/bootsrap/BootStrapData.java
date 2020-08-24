package com.firat.spring5webapp.bootsrap;

import com.firat.spring5webapp.domain.Author;
import com.firat.spring5webapp.domain.Book;
import com.firat.spring5webapp.domain.Publisher;
import com.firat.spring5webapp.repositories.AuthorRepository;
import com.firat.spring5webapp.repositories.BookRepository;
import com.firat.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component  /* using this component annotation to tell the SpringFramework that this is a spring managed component */
public class BootStrapData implements CommandLineRunner
{

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in BootStrap");
        Publisher publisher=new Publisher();
        publisher.setName("hakki bulut");
        publisher.setCity("izmir");
        publisher.setState("tr");


        publisherRepository.save(publisher);

        System.out.println("Publisher Count" +publisherRepository.count());



        Author firat =new Author("Firat","Celik");
        Book spns =new Book("sapiens","123123");

        firat.getBooks().add(spns);
        spns.getAuthors().add(firat);

        authorRepository.save(firat);
        bookRepository.save(spns);

        Author rod=new Author("Rod","Johnson");
        Book noEJB=new Book("J2EE Development without EJB","21312312");

                rod.getBooks().add(noEJB);
                noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

                System.out.println("Started in Bootstrap");
                System.out.println("Number of books " +bookRepository.count());

    }
}
