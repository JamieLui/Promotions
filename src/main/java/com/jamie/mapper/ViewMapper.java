package com.jamie.mapper;

import org.springframework.stereotype.Component;

import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.MapperFactory;

@Component
public class ViewMapper extends ConfigurableMapper {

    @Override
    protected void configure(MapperFactory factory) {
        // using the standard mapping config
    }

}