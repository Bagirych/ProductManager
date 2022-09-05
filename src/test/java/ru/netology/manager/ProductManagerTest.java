package ru.netology.manager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    static ProductRepository repo = new ProductRepository();
    ProductManager manger = new ProductManager(repo);
    static Product smartphone = new Smartphone(2, "Iphone6S", 20000, "Apple");
    static Product smartphone1 = new Smartphone(5, "GalaxyA52", 10000, "Samsung");
    static Product book = new Book(25, "Dungeons and Dragons", 9999999, "Ernest Gary Gygax");
    static Product book1 = new Book(1, "Eisenhorn Omnibus", 50, "Abnett Dan");
    static Product book2 = new Book(3, "Star Wars: The Old Republic: Revan", 123, "Drew Karpyshyn");

    @BeforeAll
    static void setUp() {
        repo.save(smartphone);
        repo.save(smartphone1);
        repo.save(book);
        repo.save(book1);
        repo.save(book2);
    }

    @Test
    public void shouldFindBookName() {
        Product[] expected = {book};
        Product[] actual = manger.searchBy("Dungeons and Dragons");

        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindSmartphoneProducer() {
        Product[] expected = {smartphone};
        Product[] actual = manger.searchBy("Iphone");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSmartphoneName() {
        Product[] expected = {smartphone1};
        Product[] actual = manger.searchBy("GalaxyA52");

        assertArrayEquals(expected, actual);
    }
 @Test
    public void shouldFindTwoProducts() {
        Product[] expected = {};
        Product[] actual = manger.searchBy("ан");

        assertArrayEquals(expected, actual);
    }

}
