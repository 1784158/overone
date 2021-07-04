import service.ProductService;

public class App {
    public static void main(String[] args) {
        var productService = new ProductService();
        productService.menuSelect();
    }
}
