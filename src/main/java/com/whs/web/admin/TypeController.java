package com.whs.web.admin;

import com.whs.bean.Type;
import com.whs.service.TypeService;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;



    @GetMapping("/types")
    public String list(@PageableDefault(size = 10,sort = {"id"},direction = Sort.Direction.DESC) Pageable pageable,Model model){
        Page<Type> types = typeService.listType(pageable);
        model.addAttribute("typePage", types);
        return "admin/types";
    }

    @GetMapping("/type/input")
    public String addType(Model model){
        model.addAttribute("type",new Type());
        return "admin/type-input";
    }

    @GetMapping("/type/{id}/input")
    public String editType(Model model,@PathVariable Long id){
        model.addAttribute("type",typeService.getType(id));
        return "admin/type-input";
    }

    @PostMapping("/type/add")
    public String saveOne(@Valid Type type, BindingResult result, RedirectAttributes attributes){

        if(typeService.getTypeByName(type.getName())!=null){
            result.rejectValue("name","nameError","该分类已经拥有过了");
        }
        if (result.hasErrors()) {
            return "admin/type-input";
        }
        Type type1 = typeService.saveType(type);
        if(type1 == null){
            attributes.addFlashAttribute("msg","操作失败");
        }else{
            attributes.addFlashAttribute("msg","操作成功");
        }
        return "redirect:/admin/types";
    }

    @PostMapping("/type/{id}/edit")
    public String edit(@Valid Type type, BindingResult result,@PathVariable Long id,RedirectAttributes attributes){

        if(typeService.getTypeByName(type.getName())!=null){
            result.rejectValue("name","nameError","该分类已经拥有过了");
        }
        if (result.hasErrors()) {
            return "admin/type-input";
        }
        Type type1 = typeService.updateType(id,type);
        if(type1 == null){
            attributes.addFlashAttribute("msg","update失败");
        }else{
            attributes.addFlashAttribute("msg","update成功");
        }
        return "redirect:/admin/types";
    }

    @GetMapping("/type/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
        typeService.deleteType(id);
        attributes.addFlashAttribute("msg","删除成功");
        return "redirect:/admin/types";
    }
}
