package com.yula.app.storeapp.controllers;

import com.yula.app.storeapp.dto.ProductDTO_ru;
import com.yula.app.storeapp.models.Product_ru;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

public class ProductClientResource {

    private static final String GET_PRODUCT_BY_NAME_OR_DESCRIPTION_API = "http://localhost:8086/api/products/search/{keyword}";
    private static final String GET_ALL_PRODUCTS_API = "http://localhost:8086/api/products/";
    private static final String GET_PRODUCT_BY_ID_API = "http://localhost:8086/api/products/{id}";
    static RestTemplate restTemplate = new RestTemplate();

    static ModelMapper modelMapper = new ModelMapper();
    static Logger log = LoggerFactory.getLogger(ProductClientResource.class);

    public static void main(String[] args) {
        getAllProductsAPI();
        getProductByIdAPI();
        getProductByNameOrDescriptionAPI();
    }
    private static void getAllProductsAPI(){
        log.debug("Request {}", "get all");

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        /* метод exchange() выполняет HTTP-запрос требуемого типа к ресурсу с указанным URL
           и возвращает экземпляр ResponseEntity, содержащий объект, отображающий тело ответа */

        List<Product_ru> resRu = restTemplate.exchange(GET_ALL_PRODUCTS_API, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Product_ru>>() {
        }).getBody();

        List<ProductDTO_ru> resDTO_RU = new ArrayList<>();
        for (Product_ru el : resRu) {
            resDTO_RU.add(convertToProductDTO(el));
        }

        log.debug("Response {}", resDTO_RU);

    }

    private static void getProductByIdAPI(){
        log.debug("Request {}", "get by id");
        Map<String, Integer> param = new HashMap<>();
        param.put("id", 3);

        // метод getForObject() Выполняет запрос HTTP GET и возвращает объект, отображающий тело ответа
        Product_ru product = restTemplate.getForObject(GET_PRODUCT_BY_ID_API, Product_ru.class, param);
        log.debug("Response {}", convertToProductDTO(product));
    }

    private static void getProductByNameOrDescriptionAPI(){

        log.debug("Request {}", "get by name or description");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        Map<String, String> param = new HashMap<>();
        param.put("keyword", "Яблоки");

        ResponseEntity<String> result = restTemplate.exchange(GET_PRODUCT_BY_NAME_OR_DESCRIPTION_API, HttpMethod.GET, entity, String.class, param);

        log.debug("Response {}", result);

    }

    private static ProductDTO_ru convertToProductDTO(Product_ru product_ru){
        return modelMapper.map(product_ru, ProductDTO_ru.class);
    }

}
