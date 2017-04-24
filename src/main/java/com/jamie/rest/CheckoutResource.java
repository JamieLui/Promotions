package com.jamie.rest;

import com.jamie.model.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;

@RestController
@RequestMapping("/jamie/checkout/v1")
@Api(value = "checkout", description = "checkout service")
public class CheckoutResource {



}
