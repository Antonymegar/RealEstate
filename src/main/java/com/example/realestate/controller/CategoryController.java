package com.example.realestate.controller;

import com.example.realestate.Payload.ApiResponse;
import com.example.realestate.Payload.CategoryRequest;
import com.example.realestate.Repositories.CategoryRepo;
import com.example.realestate.Repositories.UserRepository;
import com.example.realestate.model.Category;
import com.example.realestate.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/projects")
public class CategoryController
{
    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private UserRepository userRepository;

     @Autowired
     private CategoryService categoryService;

     private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

     @PostMapping
     @RolesAllowed("ROLE_ADMIN")
     public ResponseEntity<?>createCategory(@Valid @RequestBody CategoryRequest categoryRequest) {
         Category category = categoryService.createCategory(categoryRequest);

         URI location = ServletUriComponentsBuilder
                 .fromCurrentRequest().path("/{categoryId}")
                 .buildAndExpand(category.getId()).toUri();
         return ResponseEntity.created(location)
                 .body(new ApiResponse(true , "Category Created"));
     }



}
