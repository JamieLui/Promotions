package com.jamie.rest.promotions;

import com.jamie.mapper.ViewMapper;
import com.jamie.model.Product;
import com.jamie.model.promotions.CheckoutPromotion;
import com.jamie.model.promotions.ProductPromotion;
import com.jamie.rest.ProductView;
import com.jamie.service.ProductService;
import com.jamie.service.PromotionsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;

@RestController
@RequestMapping("/jamie/promotions/v1")
@Api(value = "promotions", description = "promotions service")
public class PromotionsResource {

    private final PromotionsService service;
    private final ViewMapper mapper;

    @Autowired
    public PromotionsResource(final PromotionsService service, final ViewMapper mapper) {
        this.mapper = mapper;
        this.service = service;
    }

    @ApiOperation(value = "Add checkout promotion")
    @RequestMapping(method = RequestMethod.POST, value = "/checkout/add")
    public String addCheckoutPromotion (@ApiParam("Checkout Promotion") @RequestBody CheckoutPromotionView checkoutPromotionsView) throws ValidationException {
        CheckoutPromotion checkoutPromotion = mapper.map(checkoutPromotionsView, CheckoutPromotion.class);
        service.addCheckoutPromotion(checkoutPromotion);
        return checkoutPromotion.getId();
    }

    @ApiOperation(value = "Get checkout promotion")
    @RequestMapping(method = RequestMethod.GET, value = "/checkout/get/{checkoutPromotionId}")
    public CheckoutPromotionView getCheckoutPromotion (@ApiParam("Checkout Promotion Id") @PathVariable final String checkoutPromotionId) throws ValidationException {
        CheckoutPromotion checkoutPromotion = service.getCheckoutPromotion(checkoutPromotionId).orElse(null);
        return mapper.map(checkoutPromotion, CheckoutPromotionView.class);
    }

    @ApiOperation(value = "Add product promotion")
    @RequestMapping(method = RequestMethod.POST, value = "/product/add")
    public String addProductPromotion (@ApiParam("Product Promotion") @RequestBody ProductPromotionView productPromotionView) throws ValidationException {
        ProductPromotion productPromotion = mapper.map(productPromotionView, ProductPromotion.class);
        service.addProductPromotion(productPromotion);
        return productPromotion.getId();
    }

    @ApiOperation(value = "Get product promotion")
    @RequestMapping(method = RequestMethod.GET, value = "/product/get/{productPromotionId}")
    public ProductPromotionView getProductPromotion (@ApiParam("Product Promotion Id") @PathVariable final String productPromotionId) throws ValidationException {
        ProductPromotion productPromotion = service.getProductPromotion(productPromotionId).orElse(null);
        return mapper.map(productPromotion, ProductPromotionView.class);
    }
}
