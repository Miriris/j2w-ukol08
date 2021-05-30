package cz.czechitas.java2webapps.ukol8.controller;

import cz.czechitas.java2webapps.ukol8.entity.Post;
import cz.czechitas.java2webapps.ukol8.repository.PostRepository;
import cz.czechitas.java2webapps.ukol8.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.Optional;

/*
Bohužel pageable a sort se mnou nechtějí spolupracovat, tak úkol nemám hotový celý. Omlouvám se a posílám aspoň to co mi funguje.
 */

@Controller
public class PostController {

    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ModelAndView seznamPrispevku() {
        return new ModelAndView("index")
                .addObject("prispevky", service.list());
    }

    @GetMapping("/post/{slug}")
    public ModelAndView detail(@PathVariable String slug) {

        return new ModelAndView("prispevek")
                .addObject("prispevek", service.singlePost(slug));
        }

    }



