package kz.aitu.bot.service;

import kz.aitu.bot.model.Category;
import kz.aitu.bot.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CategoryServiceImp implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImp(CategoryRepository categoryRepository) {this.categoryRepository = categoryRepository;}

    @Override
    public List<Category> getCategoryByParentId(Long id) {
        return categoryRepository.findByParentId(id);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }


}
