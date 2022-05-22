package com.example;

import io.micronaut.http.annotation.*;

@Controller("/dictionary")
public class DictionaryController {

    @Get(uri="/", produces="text/plain")
    public String index() {
        return "Example Response";
    }
}