package kz.aitu.bot.service;

import kz.aitu.bot.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getCategoryByParentId(Long id);

    List<Category> getAllCategories();

}
