package ru.netology.expection.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.expection.NotFoundException;
import ru.netology.expection.Product;
import ru.netology.expection.ShopRepository;


public class RepositoryTest {

    @Test
    public void removedExistProductTest() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Хлеб", 60);
        Product product2 = new Product(2, "Яйца", 100);
        Product product3 = new Product(3, "Картошка", 20);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.remove(3);
        Product[] expected = {product1, product2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void removedNotExistProductTest() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Хлеб", 60);
        Product product2 = new Product(2, "Яйца", 100);
        Product product3 = new Product(3, "Картошка", 20);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () ->
            repo.remove(5)
            );
    }
}