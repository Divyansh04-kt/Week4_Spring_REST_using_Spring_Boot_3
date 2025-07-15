package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.ArrayList;

@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @RequestMapping("/countries")
    public List<Country> getAllCountries() {
        LOGGER.info("START: getAllCountries()");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        List<Country> countryList = new ArrayList<>();
        countryList.add(context.getBean("in", Country.class));
        countryList.add(context.getBean("us", Country.class));
        countryList.add(context.getBean("jp", Country.class));
        countryList.add(context.getBean("de", Country.class));

        LOGGER.info("END: getAllCountries()");
        return countryList;
    }
}

