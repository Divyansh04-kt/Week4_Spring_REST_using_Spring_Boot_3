package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {

    public Country getCountry(String code) {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        List<Country> countryList = new ArrayList<>();
        countryList.add(context.getBean("in", Country.class));
        countryList.add(context.getBean("us", Country.class));
        countryList.add(context.getBean("jp", Country.class));
        countryList.add(context.getBean("de", Country.class));

        return countryList.stream()
                .filter(country -> country.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null); 
    }
}

