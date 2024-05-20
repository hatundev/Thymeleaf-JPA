package com.xuong.ThymeleafJPA.controller;

import com.xuong.ThymeleafJPA.entity.Brand;
import com.xuong.ThymeleafJPA.entity.Category;
import com.xuong.ThymeleafJPA.entity.Product;
import com.xuong.ThymeleafJPA.entity.Status;
import com.xuong.ThymeleafJPA.entity.SubCategory;
import com.xuong.ThymeleafJPA.request.ProductRequest;
import com.xuong.ThymeleafJPA.service.ProductService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ProductController productController;

    @Autowired
    private BrandController brandController;

    @Autowired
    private StatusController statusController;

    @Autowired
    private CateController cateController;

    @Autowired
    private SubCateController subCateController;

    @Autowired
    private ProductService productService;
    private List<Brand> brandList;
    private List<Status> statusList;
    private List<SubCategory> subCategoryList;
    private List<Category> categoryList;

    @PostConstruct
    public void init() {
        this.brandList = brandController.findAll();
        this.statusList = statusController.findAll();
        this.subCategoryList = subCateController.findAll();
        this.categoryList = cateController.findAll();
    }

    /*
     * Get
     * */
    @GetMapping("/view")
    public String view(Model model) {
        model.addAttribute("listBrand", brandList);
        model.addAttribute("listStatus", statusList);
        model.addAttribute("listCate", categoryList);
        model.addAttribute("listProduct", productController.findAll());
        return "view";
    }

    @GetMapping("/add-product")
    public String addProduct(Model model) {
        ProductRequest productRequest = new ProductRequest();
        model.addAttribute("listBrand", brandList);
        model.addAttribute("listSubCate", subCategoryList);
        model.addAttribute("productRequest", productRequest);
        return "addproduct";
    }

    @GetMapping("/detail-product/{id}")
    public String detailProduct(@PathVariable Long id, Model model) {
        Product product = productController.getProduct(id).get();
        model.addAttribute("detailProduct", product);
        model.addAttribute("listBrand", brandList);
        model.addAttribute("listSubCate", subCategoryList);
        model.addAttribute("listStatus", statusList);
        return "detail";
    }

    ;

    @GetMapping("/update-product/{id}")
    public String updateProduct(@PathVariable Long id, Model model) {
        Product product = productController.getProduct(id).get();
        model.addAttribute("detailProduct", product);
        model.addAttribute("listBrand", brandList);
        model.addAttribute("listSubCate", subCategoryList);
        model.addAttribute("listStatus", statusList);
        return "update";
    }

    ;


    /*
     * Post
     * */

    @PostMapping("/save-product")
    public String saveProduct(@ModelAttribute ProductRequest productRequest) {
        productController.addProduct(productRequest);
        return "redirect:/view";
    }

    /*
     * Put
     * */
    @PostMapping("/update-product")
    public String updateProduct(@ModelAttribute Product detailProduct) {
        ProductRequest productRequest = productService.convertProductToProductRequest(detailProduct);
        productService.updateProduct(productRequest);
        return "redirect:/view";
    }

    /*
     * Delete
     * */
    @GetMapping("/del-product/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/view";
    }

}
