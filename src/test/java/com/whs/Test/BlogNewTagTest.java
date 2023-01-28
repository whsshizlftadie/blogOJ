package com.whs.Test;

import com.whs.bean.Blog;
import com.whs.bean.Tag;
import com.whs.bean.User;
import com.whs.service.BlogService;
import com.whs.service.TagService;
import com.whs.service.TypeService;
import com.whs.utils.NumberUtils;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Ignore
@RunWith(SpringRunner.class)
public class BlogNewTagTest {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;



//    @Test
//    @Ignore
//    public void add(){
//
//        String target="1,2,3,乱搞";
//
//        String tagIds=target;
//        List<String> strs = convertToList(tagIds);
//
//        for (String str : strs) {
//            boolean numeric = NumberUtils.isNumeric(str);
//            if(!numeric){
//                strs.remove(str);
//                Tag tag = new Tag();
//                tag.setName(str);
//                Tag tag1 = tagService.saveTag(tag);
//                strs.add(String.valueOf(tag1.getId()));
//
//            }
//        }
//        String s = ListStringToIds(strs);
//        System.out.println(s);
//    }

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
}
