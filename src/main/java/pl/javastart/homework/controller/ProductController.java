package pl.javastart.homework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.javastart.homework.model.Product;
import pl.javastart.homework.repository.ProductRepository;

import java.util.List;

@Controller
public class ProductController {
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public String mainPage (Model model){
        model.addAttribute("product", new Product());
        return "home";
    }

    @GetMapping("/lista")
    public String showList (Model model){
        getDetails(model);
        return "lista";
    }

    private void getDetails(Model model) {
        List<Product> products = productRepository.getProductsList();
        double productPriceSum = productRepository.getPriceSum();
        model.addAttribute("products", products);
        model.addAttribute("sum", productPriceSum);
    }

    @GetMapping("/tabela")
    public String showTable (Model model){
        getDetails(model);
        return "table";
    }

    @PostMapping("/zapisz")
    public String addProduct (Product product){
        productRepository.addProduct(product);
        return "success";
    }
}
