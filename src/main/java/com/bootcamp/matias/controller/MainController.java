package com.bootcamp.matias.controller;

import com.bootcamp.matias.service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class MainController {

    @Autowired
    private UtilService service;

    @GetMapping(path = "/romanTranslator/{number}")
    public String TranslateToRoman(@PathVariable int number) {
       return service.getRoman(number);

    }

    @GetMapping("/morse/{morseCode}")
    public String getMorseCode(@PathVariable String morseCode){
        return service.getMorse(morseCode);
    }
}
