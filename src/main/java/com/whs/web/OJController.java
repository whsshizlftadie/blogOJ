package com.whs.web;

import com.whs.OJUse.Answer;
import com.whs.OJUse.CompileResponse;
import com.whs.OJUse.Task;
import com.whs.bean.Problem;
import com.whs.service.OJService;
import com.whs.utils.MarkdownUtils;
import com.whs.utils.OJUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping("OJ")
public class OJController {

    @Autowired
    private OJService ojService;

    @RequestMapping("/")
    public String OJ(Model model,@PageableDefault(size = 8,sort = {"id"},direction = Sort.Direction.DESC) Pageable pageable){
        model.addAttribute("Page",ojService.PROBLEM_LIST(pageable));
        return "oj";
    }

    @RequestMapping("/{id}")
    public String one(@PathVariable Long id,Model model){
        Problem problemById = ojService.getProblemById(id);
        String s = MarkdownUtils.markdownToHtmlExtensions(problemById.getDescription());
        problemById.setDescription(s);
        Problem p=new Problem();
        BeanUtils.copyProperties(problemById,p);
        model.addAttribute("problem", p);
        return "problem";
    }

    @RequestMapping("/compile")
    @ResponseBody
    public CompileResponse compile(Long pId,String code){
        Problem problem = ojService.getProblemById(pId);
        String testCode = problem.getTestCode();
//        System.out.println(code);
        String finalCode = OJUtils.mergeCode(code, testCode);
        Task task = new Task();
        Answer answer=new Answer();
        try {
               answer = task.compileAndRun(finalCode);

        }  catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        CompileResponse compileResponse = new CompileResponse();

        if(answer.getReason()!=null){
            if(answer.getReason().equals("运行超时")){
                compileResponse.setReason("运行超时");
                return compileResponse;
            }
        }


        compileResponse.setStatus(200);
        compileResponse.setErrno(answer.getErrno());
        compileResponse.setReason(answer.getReason());
        compileResponse.setStdout(answer.getStdout());
        return compileResponse;
    }

}
