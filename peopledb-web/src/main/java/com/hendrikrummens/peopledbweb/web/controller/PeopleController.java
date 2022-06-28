package com.hendrikrummens.peopledbweb.web.controller;

import com.hendrikrummens.peopledbweb.biz.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/people")
public class PeopleController {

    @GetMapping
    public List<Person> getPeople(Model model){
        List<Person> people = List.of(
                new Person(10l,"Hendrik", "Rummens", LocalDate.of(2000, 6, 10), new BigDecimal(100000)),
                new Person(20l,"Lucas", "Rummens", LocalDate.of(2002, 1, 10), new BigDecimal(200000)),
                new Person(30l,"Henk", "Rummens", LocalDate.of(2003, 3, 10), new BigDecimal(300000))
        );
        model.addAttribute("people", people);
        return people;
    }


}
