package kz.aitu.bot.rest;

import kz.aitu.bot.dtos.CategoryDTO;
import kz.aitu.bot.model.Category;
import kz.aitu.bot.model.Language;
import kz.aitu.bot.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryRestController {

    private final CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Category>> getCategoryByParentId(@PathVariable("id")Long parentId) {
        List<Category> categories = categoryService.getCategoryByParentId(parentId);

        if(categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(categories, HttpStatus.OK);

    }

    @RequestMapping(value = "{lang}/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CategoryDTO>> getCategoryByParentIdLang(@PathVariable("lang")String lang,@PathVariable("id")Long parentId) {
        if(parentId == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        List<Category> categories = categoryService.getCategoryByParentId(parentId);
        List<CategoryDTO> categoryDTOS = new ArrayList<>();

        if(categories.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        try {
            lang = lang.toUpperCase();
            lang = lang.replaceAll("\\s", "");
            for (Category category : categories) {
                categoryDTOS.add(new CategoryDTO(category, Language.valueOf(lang)));
            }

            return new ResponseEntity<>(categoryDTOS, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(categoryDTOS, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = this.categoryService.getAllCategories();

        if(categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
