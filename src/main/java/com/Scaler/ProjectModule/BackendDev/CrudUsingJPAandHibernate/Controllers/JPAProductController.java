package com.Scaler.ProjectModule.BackendDev.CrudUsingJPAandHibernate.Controllers;


import com.Scaler.ProjectModule.BackendDev.CrudUsingJPAandHibernate.DTO.ProductDTO;
import com.Scaler.ProjectModule.BackendDev.CrudUsingJPAandHibernate.DTO.RatingDto;
import com.Scaler.ProjectModule.BackendDev.CrudUsingJPAandHibernate.Models.Product;
import com.Scaler.ProjectModule.BackendDev.CrudUsingJPAandHibernate.Services.JPAProductService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/JPA/products")
public class JPAProductController {
    private JPAProductService productService;
    public void JProductController(JPAProductService productService) {
          this.productService = productService;
    }

    @GetMapping()
    public ProductDTO getAllProduct(){
        return null;
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable("id") long id){
        return null;
    }

    @PostMapping()
    public ProductDTO addProduct(@RequestBody ProductDTO ProductDTO){
        return null;
    }


    @PatchMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable("id")  long  id,@RequestBody ProductDTO ProductDTO) {
        return null;
    }


    @DeleteMapping("/{id}")
    public  ProductDTO deleteProduct(long id) {
        return null;
    }








//    //helper methods
    public ProductDTO convertToProductDTO(Product product){
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

    public Product convertToProduct(ProductDTO productDTO){
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setTitle(productDTO.getTitle());
        product.setPrice(productDTO.getPrice());
        product.setImage(productDTO.getImage());
        product.setDescription(productDTO.getDescription());
        return product;
    }
}
