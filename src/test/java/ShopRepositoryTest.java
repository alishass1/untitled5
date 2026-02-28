import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShopRepositoryTest {
    private ShopRepository repository;
    private Product product1;
    private Product product2;
    private Product product3;

    @BeforeEach
    void setUp() {
        repository = new ShopRepository();
        product1 = new Product(1, "Телефон", 25000);
        product2 = new Product(2, "Ноутбук", 75000);
        product3 = new Product(3, "Наушники", 5000);
    }

    @Test
    void shouldRemoveExistingProduct() {
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);

        repository.removeById(2);

        Product[] expected = {product1, product3};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldThrowNotFoundException() {
        repository.add(product1);
        repository.add(product2);

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(999);
        });
    }
}
