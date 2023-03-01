package com.iuvity.hulkstore.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kardex")
public class kardexController {

    protected static final String APPLICATION_JSON = MediaType.APPLICATION_JSON_UTF8_VALUE;

}