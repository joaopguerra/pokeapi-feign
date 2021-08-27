package com.guerra.poke.exception;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {

        log.error("Fallback for method: {}, with code: {} and error: {}", methodKey, response.status(), response.body());

        throw new NotFoundException("No pokemons here");
    }

}
