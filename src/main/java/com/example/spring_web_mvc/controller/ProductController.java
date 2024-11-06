package com.example.spring_web_mvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring_web_mvc.entity.Product;
import com.example.spring_web_mvc.repository.ProductRepository;

@Controller
@RequestMapping("/products")
public class ProductController {


    private ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }


    @GetMapping
    public String findAll(Model model) {
        List<Product> products = this.repository.findAll();
        model.addAttribute("products", products);
        return "products-list";
        
    }

    @GetMapping("/new")
    public String getForm(Model model) {
        model.addAttribute("products", new Product());
        return "products-form";
        
    }

    @PostMapping("/save")
    public String saveOrUpdate(@ModelAttribute("products") Product product) {
        this.repository.save(product);
        return "redirect:/products";

    }

    @GetMapping("/edit/{id}")
    public String getFormEdit(@PathVariable("id") Long id, Model model) {
        Product product = this.repository.findById(id).orElse(new Product());
        model.addAttribute("products", product);
        return "products-form";
    }

    @GetMapping("/{id}/delete")
        public String delete(@PathVariable("id")Long id){
            this.repository.deleteById(id);
            return "redirect:/products";
        }
    
    
}



