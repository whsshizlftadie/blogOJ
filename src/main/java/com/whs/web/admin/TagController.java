package com.whs.web.admin;

import com.whs.bean.Tag;
import com.whs.bean.Type;
import com.whs.service.TagService;
import javafx.beans.DefaultProperty;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/tags")
    public String tags(@PageableDefault(size = 5,sort = {"id"},direction = Sort.Direction.DESC) Pageable pageable, Model model){
        model.addAttribute("tagPage",tagService.listTag(pageable));
        return "admin/tags";
    }

    @GetMapping("/tag/input")
    public String input(Model model){
        model.addAttribute("tag",new Tag()) ;
        return "admin/tag-input";
    }

    @GetMapping("/tag/{id}/input")
    public  String TagEdit(@PathVariable Long id, Model model){
        model.addAttribute("tag",tagService.getTag(id));
        return "admin/tag-input";
    }

    @PostMapping("/tag/add")
    public String addTag( @Valid Tag tag,BindingResult result, RedirectAttributes attributes){
        Tag tagByName = tagService.getTagByName(tag.getName());
        if(tagByName != null){
            result.rejectValue("name","nameError","该tag已经拥有过了");
        }
        if (result.hasErrors()) {
            return "admin/tag-input";
        }
        Tag tag1 = tagService.saveTag(tag);
        if(tag1 == null){
            attributes.addFlashAttribute("msg","操作失败");
        }else{
            attributes.addFlashAttribute("msg","操作成功");
        }
        return "redirect:/admin/tags";
    }

    @PostMapping("/tag/{id}/edit")
    public String editTag(@Valid Tag tag, BindingResult result, @PathVariable Long id,RedirectAttributes attributes){
        if(tagService.getTagByName(tag.getName())!=null){
            result.rejectValue("name","nameError","该tag已经拥有过了");
        }
        if (result.hasErrors()) {
            return "admin/tag-input";
        }
        Tag tag1 = tagService.updateTag(id, tag);
        if(tag1 == null){
            attributes.addFlashAttribute("msg","操作失败");
        }else{
            attributes.addFlashAttribute("msg","操作成功");
        }
        return "redirect:/admin/tags";
    }


    @GetMapping("tag/{id}/delete")
    public String del(@PathVariable Long id,RedirectAttributes attributes){
        tagService.deleteTag(id);
        attributes.addFlashAttribute("msg","del success");
        return "redirect:/admin/tags";
    }

}
