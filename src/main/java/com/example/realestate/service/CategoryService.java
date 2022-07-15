package com.example.realestate.service;

import com.example.realestate.Payload.CategoryRequest;
import com.example.realestate.Repositories.CategoryRepo;
import com.example.realestate.model.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.realestate.model.ProjectStatus.AVAILABLE_PLOTS;
import static com.example.realestate.model.ProjectStatus.SOLD_OUT;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    private static final Logger logger = LoggerFactory.getLogger(CategoryService.class);

    public Category createCategory(CategoryRequest categoryRequest){
        Category category = new Category();
        category.setName(categoryRequest.getName());
        category.setLocation(categoryRequest.getLocation());
        category.setProjectStatus(categoryRequest.getProjectStatus( AVAILABLE_PLOTS, SOLD_OUT));
        return categoryRepo.save(category);
    }
}
