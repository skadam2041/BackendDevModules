package com.Scaler.ProjectModule.BackendDev.ProxyServiceImplementation.Client.FakeStore.FakeStoreClient;

import com.Scaler.ProjectModule.BackendDev.ProxyServiceImplementation.Client.FakeStore.FakeStoreDTO.FakeStoreProductDTO;
import com.Scaler.ProjectModule.BackendDev.ProxyServiceImplementation.Client.FakeStore.FakeStoreDTO.RatingDto;
import com.Scaler.ProjectModule.BackendDev.ProxyServiceImplementation.DTO.ProductDTO;
import com.Scaler.ProjectModule.BackendDev.ProxyServiceImplementation.Models.Category;
import com.Scaler.ProjectModule.BackendDev.ProxyServiceImplementation.Models.Product;
import com.Scaler.ProjectModule.BackendDev.ProxyServiceImplementation.Models.Rating;
import io.micrometer.common.lang.Nullable;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductClient implements FakeStoreClient {


    private <T> ResponseEntity<T> patchForEntity(HttpMethod httpMethod, String url, @Nullable Object request,  Class<T> responseType, Object... uriVariables) throws RestClientException {

        RestTemplate restTemplate = restTemplateBuilder.requestFactory( HttpComponentsClientHttpRequestFactory.class).build();
        RequestCallback requestCallback =restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }

    private <T> ResponseEntity<T> deleteForEntity(HttpMethod httpMethod, String url, @Nullable Object request,  Class<T> responseType, Object... uriVariables) throws RestClientException {

        RestTemplate restTemplate = restTemplateBuilder.requestFactory( HttpComponentsClientHttpRequestFactory.class).build();
        RequestCallback requestCallback =restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }


    RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }



    public List<Product> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        FakeStoreProductDTO[] fakeStoreProductDTOs =
                restTemplate.getForEntity("https://fakestoreapi.com/products", FakeStoreProductDTO[].class).getBody();


        List<Product> products = new ArrayList<>();

        for (FakeStoreProductDTO fakeStoreProductDTO: fakeStoreProductDTOs) {
            Product product = convertToProduct(fakeStoreProductDTO);
            products.add(product);
        }
        return products;
    }


    public Product getSingleProduct(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", FakeStoreProductDTO.class, productId).getBody();

        Product product = convertToProduct(fakeStoreProductDTO);
        return product;
    }



    public Product addNewProduct(ProductDTO productDTO) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        FakeStoreProductDTO fakeStoreProductDTO = convertToFakeStoreProductDTO(productDTO);
        FakeStoreProductDTO fakeStoreProductDTO1 = restTemplate.postForEntity("https://fakestoreapi.com/products", fakeStoreProductDTO, FakeStoreProductDTO.class).getBody();
        fakeStoreProductDTO1.setRating(new RatingDto());
        Product product = convertToProduct(fakeStoreProductDTO1);
        return product;
    }


    public Product updateProduct(Long productId, ProductDTO productDTO) {
        FakeStoreProductDTO fakeStoreProductDTO =  convertToFakeStoreProductDTO(productDTO);

        ResponseEntity<FakeStoreProductDTO> responseEntity = patchForEntity(HttpMethod.PATCH,"https://fakestoreapi.com/products/{id}",fakeStoreProductDTO, FakeStoreProductDTO.class, productId);
        FakeStoreProductDTO DBfakeStoreProductDTO  = responseEntity.getBody();
        DBfakeStoreProductDTO.setRating(new RatingDto());
        Product dbproduct = convertToProduct(DBfakeStoreProductDTO);
        return dbproduct;
    }


    public Product deleteProduct(Long productId) {
        ResponseEntity<FakeStoreProductDTO> responseEntity = deleteForEntity(HttpMethod.DELETE,"https://fakestoreapi.com/products/{id}",null, FakeStoreProductDTO.class, productId);

        FakeStoreProductDTO DBfakeStoreProductDTO  = responseEntity.getBody();
        DBfakeStoreProductDTO.setRating(new RatingDto());
        Product dbproduct = convertToProduct(DBfakeStoreProductDTO);
        dbproduct.setImage("product is deleted");
        return dbproduct;
    }

    @Override
    public List<String> getAllCategory() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String[] categories = restTemplate.getForEntity("https://fakestoreapi.com/products/categories", String[].class).getBody();
        List<String> categoryList = new ArrayList<>();
        for(String category: categories) {
            categoryList.add(category);
        }
        return  categoryList;
    }

    @Override
    public List<Product> getInCategory(String categoryName) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        FakeStoreProductDTO[] fakeStoreProductDTOs =
                restTemplate.getForEntity("https://fakestoreapi.com/products/category/{categoryName}", FakeStoreProductDTO[].class, categoryName).getBody();


        List<Product> products = new ArrayList<>();

        for (FakeStoreProductDTO fakeStoreProductDTO: fakeStoreProductDTOs) {
            Product product = convertToProduct(fakeStoreProductDTO);
            products.add(product);
        }
        return products;
    }

    //helper methods

    public FakeStoreProductDTO convertToFakeStoreProductDTO(ProductDTO productDTO) {
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setTitle(productDTO.getTitle());
        fakeStoreProductDTO.setPrice(productDTO.getPrice());
        fakeStoreProductDTO.setCategory(productDTO.getCategory());
        fakeStoreProductDTO.setImage(productDTO.getImage());
        fakeStoreProductDTO.setDescription(productDTO.getDescription());

        return fakeStoreProductDTO;

    }

    public Product convertToProduct(FakeStoreProductDTO fakeStoreProductDTO) {
        Product product = new Product();
        product.setId(fakeStoreProductDTO.getId());
        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setPrice(fakeStoreProductDTO.getPrice());
        Category category = new Category();
        category.setName(fakeStoreProductDTO.getCategory());
        product.setCategory(category);
        product.setImage(fakeStoreProductDTO.getImage());
        product.setDescription(fakeStoreProductDTO.getDescription());
        Rating rating = new Rating();
        rating.setRate(fakeStoreProductDTO.getRating().getRate());
        rating.setCount(fakeStoreProductDTO.getRating().getCount());
        product.setRating(rating);

        return product;
    }
}
