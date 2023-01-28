package com.whs.web.admin;

import com.whs.bean.Blog;
import com.whs.bean.Tag;
import com.whs.bean.Type;
import com.whs.bean.User;
import com.whs.service.BlogService;
import com.whs.service.TagService;
import com.whs.service.TypeService;
import com.whs.utils.NumberUtils;
import com.whs.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Controller
@RequestMapping("admin")
public class BlogController {

    private static final String INPUT="admin/blogs-input";
    private static final String OUTPUT="admin/blogs";
    private static final String REDIRECT_LIST="redirect:/admin/blogs";

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @GetMapping("blogs")
    public String blogs(Model model,
                        @PageableDefault(size = 5,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable,
                        BlogQuery blog){
        model.addAttribute("types",typeService.findAll());
        model.addAttribute("blogPage",blogService.listBlog(pageable,blog));
        return "admin/blogs";
    }

    @PostMapping("blogs/search")
    public String blogsSearch(Model model,
                        @PageableDefault(size = 1,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable,
                        BlogQuery blog){

        model.addAttribute("blogPage",blogService.listBlog(pageable,blog));
        //System.out.println(blogService.listBlog(pageable,blog).getPageable().getPageSize());
        return "admin/blogs::blogList";
    }

    @GetMapping("/blog/input")
    public String input(Model model){
        model.addAttribute("types",typeService.findAll());
        model.addAttribute("tags",tagService.findAll());
        model.addAttribute("blog",new Blog());
        return INPUT;
    }

    @PostMapping("/blog/add")
    public String add(Model model, Blog blog, HttpSession session, RedirectAttributes attributes){

        String tagIds=blog.getTagIds();
        List<String> strs = convertToList(tagIds);

        for (String str : strs) {
            boolean numeric = NumberUtils.isNumeric(str);
            if(!numeric){
                Tag tagByName = tagService.getTagByName(str);
                if(tagByName!=null){
                    strs.remove(str);
                    strs.add(String.valueOf(tagByName.getId()));
                }else{
                    strs.remove(str);
                    Tag tag = new Tag();
                    tag.setName(str);
                    Tag tag1 = tagService.saveTag(tag);
                    strs.add(String.valueOf(tag1.getId())) ;
                }

            }
        }
        String s = ListStringToIds(strs);
        blog.setTagIds(s);

        blog.setUser((User) session.getAttribute("user"));
        blog.setType(typeService.getType(blog.getType().getId()));
        blog.setTags(tagService.listTag(blog.getTagIds()));
        Blog b = blogService.saveBlog(blog);
        if(b==null){
            attributes.addFlashAttribute("msg","操作失败");
        }else{
            attributes.addFlashAttribute("msg","操作成功");

        }


        return REDIRECT_LIST;
    }


    @RequestMapping("/blog/{id}/edit")
    public String edit(Model model,@PathVariable Long id){
        Blog blog = blogService.getBlog(id);
        model.addAttribute("types",typeService.findAll());
        model.addAttribute("tags",tagService.findAll());
        blog.init();
        model.addAttribute("blog",blog);
        return INPUT;
    }

    @RequestMapping("/blog/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
        blogService.deleteBlog(id);
        attributes.addFlashAttribute("msg","删除成功");
        return REDIRECT_LIST;
    }

    private List<String> convertToList(String ids) {
        List<String> list = new ArrayList<>();
        if (!"".equals(ids) && ids != null) {
            String[] idarray = ids.split(",");
            for (int i=0; i < idarray.length;i++) {
                list.add(new String(idarray[i]));
            }
        }
        return list;
    }

    private String ListStringToIds(List<String> tagIds) {
        if (!tagIds.isEmpty()) {
            StringBuffer ids = new StringBuffer();
            boolean flag = false;
            for (String tagId : tagIds) {
                if (flag) {
                    ids.append(",");
                } else {
                    flag = true;
                }
                ids.append(tagId);
            }
            return ids.toString();
        } else {
            return null;
        }
    }
//    @ResponseBody
//    @GetMapping(value = "/blogs/types",  produces = "application/json;charset=UTF-8")
//    public Object listTypes(){
//        List<Type> types = typeService.findAll();
//        HashMap<String, Object> result = new HashMap<>();
//        result.put("success", true);
//        result.put("results", types);
//        result.put("message", "heheda");
//        return result;
//    }

}
