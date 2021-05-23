package academy.digitallab.serviceproduct;

import academy.digitallab.serviceproduct.entity.Category;
import academy.digitallab.serviceproduct.entity.Product;
import academy.digitallab.serviceproduct.repository.ProductRepository;
import academy.digitallab.serviceproduct.service.ProductService;
import academy.digitallab.serviceproduct.service.ProductServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;

@SpringBootTest
public class ProductServiceMockTest {

    @Mock
    private ProductRepository productRepository;

    private ProductService productService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        productService = new ProductServiceImpl(productRepository);
        Product computer = Product.builder()
                .name("computer")
                .id(1L)
                .category(Category.builder().id(1L).build())
                .description("")
                .stock(Double.parseDouble("5"))
                .price(Double.parseDouble("12.5"))
//                .status("Created")
//                .createAt(new Date())
                .build();

        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(computer));

        Mockito.when(productRepository.save(computer)).thenReturn(computer);
    }

    @Test
    public void whenValidGetId_ThenReturnProduct() {
        Product found = productService.getProduct(1L);
        Assertions.assertThat(found.getName()).isEqualTo("computer");
    }

    @Test
    public void whenValidUpdateStock_ThenReturnNewStock()  {
        Product newStock = productService.updateStock(1L,Double.parseDouble("8"));
        Assertions.assertThat(newStock.getStock()).isEqualTo(13);
    }
}
