package com.Scaler.ProjectModule.BackendDev.ProxyServiceImplementation.Controllers;


import com.Scaler.ProjectModule.BackendDev.ProxyServiceImplementation.DTO.ProductDTO;
import com.Scaler.ProjectModule.BackendDev.ProxyServiceImplementation.DTO.RatingDto;
import com.Scaler.ProjectModule.BackendDev.ProxyServiceImplementation.Models.Category;
import com.Scaler.ProjectModule.BackendDev.ProxyServiceImplementation.Models.Product;
import com.Scaler.ProjectModule.BackendDev.ProxyServiceImplementation.Models.Rating;
import com.Scaler.ProjectModule.BackendDev.ProxyServiceImplementation.Services.FSProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    FSProductService productService;

    public ProductController(FSProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
     public ProductDTO getProductById(@PathVariable("id") long id){
         Product product =  productService.getSingleProduct(id);
         ProductDTO productDTO = convertToProductDTO(product);
         return productDTO;
        }

    @GetMapping()
    public List<ProductDTO> getAllProductDTOs(){
        List<Product> products =  productService.getAllProducts();

        List<ProductDTO> productDTOS = new ArrayList<>();

        for (Product product: products) {
            ProductDTO productDTO = convertToProductDTO(product);
            productDTOS.add(productDTO);
        }

        return productDTOS;
    }
    @PostMapping()
    public ProductDTO addNewProduct(@RequestBody ProductDTO productDTO){
        Product product = convertToProduct(productDTO);
        Product  DBproduct = productService.addNewProduct(product);
        ProductDTO dbproductDTO = convertToProductDTO(DBproduct);
        return dbproductDTO;
    }



    @PatchMapping("/{id}")
    public ProductDTO  updateProduct( @PathVariable("id") long id, @RequestBody ProductDTO productDTO){
        Product product = convertToProduct(productDTO);
        Product DBproduct = productService.updateProduct(id,product);
        ProductDTO DBproductDTO = convertToProductDTO(DBproduct);
        return DBproductDTO;
    }

    @DeleteMapping("/{id}")
    public ProductDTO deleteProduct(@PathVariable("id") long id){
        Product BDproduct = productService.deleteProduct(id);
        ProductDTO DBproductDTO = convertToProductDTO(BDproduct);
        return DBproductDTO;
    }

    @GetMapping("/categories")
    public List<String> getAllCategories(){
        List<String> categories = productService.getAllCategory();
        return categories;
    }

    @GetMapping("/category/{categoryName}")
    public List<ProductDTO>  getInCategory(@PathVariable("categoryName") String categoryName){
        List<Product> products = productService.getInCategory(categoryName);

        List<ProductDTO> productDTOS = new ArrayList<>();

        for (Product product: products) {
            ProductDTO productDTO = convertToProductDTO(product);
            productDTOS.add(productDTO);
        }

        return productDTOS;
    }




    //helper methods
    private ProductDTO convertToProductDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setTitle(product.getTitle());
        productDTO.setPrice(product.getPrice());
        productDTO.setCategory(product.getCategory().getName());
        productDTO.setImage(product.getImage());
        productDTO.setDescription(product.getDescription());
        RatingDto ratingDto = new RatingDto();
        ratingDto.setRate(product.getRating().getRate());
        ratingDto.setCount(product.getRating().getCount());
        productDTO.setRating(ratingDto);
        return productDTO;
    }

    private Product convertToProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setTitle(productDTO.getTitle());
        product.setPrice(productDTO.getPrice());
        Category category = new Category();
        category.setName(productDTO.getCategory());
        product.setCategory(category);
        product.setImage(productDTO.getImage());
        product.setDescription(productDTO.getDescription());
        Rating rating = new Rating();
//        rating.setRate(productDTO.getRating().getRate());
//        rating.setCount(productDTO.getRating().getCount());
        product.setRating(rating);
        return product;
    }
}
