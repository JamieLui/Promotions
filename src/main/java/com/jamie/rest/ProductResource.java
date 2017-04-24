package com.jamie.rest;

import com.jamie.mapper.ViewMapper;
import com.jamie.model.Product;
import com.jamie.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.Optional;

@RestController
@RequestMapping("/jamie/product/v1")
@Api(value = "product", description = "product service")
public class ProductResource {

    private final ProductService service;
    private final ViewMapper mapper;

    @Autowired
    public ProductResource(final ProductService service, final ViewMapper mapper) {
        this.mapper = mapper;
        this.service = service;
    }

    @ApiOperation(value = "Add product")
    @RequestMapping(method = RequestMethod.POST, value = "/product/add")
    public String addProduct(@ApiParam("Product") @RequestBody final ProductView productView) throws ValidationException {
        Product product = mapper.map(productView, Product.class);
        service.addProduct(product);
        return product.getId();
    }

    @ApiOperation(value = "Get product")
    @RequestMapping(method = RequestMethod.GET, value = "/product/get/{productId}")
    public ProductView getProduct(@ApiParam("Product Id") @PathVariable final String productId) {
        Product product = service.getProductById(productId).orElse(null);
        return mapper.map(product, ProductView.class);
    }
}
