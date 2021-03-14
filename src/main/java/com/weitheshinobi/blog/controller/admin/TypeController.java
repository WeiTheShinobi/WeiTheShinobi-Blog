package com.weitheshinobi.blog.controller.admin;

import com.weitheshinobi.blog.constant.TypeConstant;
import com.weitheshinobi.blog.pojo.Type;
import com.weitheshinobi.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TypeController {

    @Autowired
    private TypeService typeService;

//    跳轉到分頁並顯示
    @RequestMapping("/admin/types")
    public String list(@PageableDefault(sort = {"id"},direction = Sort.Direction.DESC) Pageable pageable,
                       Model model){
        Page<Type> types = typeService.listType(pageable);
        model.addAttribute(TypeConstant.PAGE,types);
        return "admin/types";
    }

    @RequestMapping("/admin/types/input")
    public String input(){
        return "admin/types-input";
    }

    @PostMapping("/admin/types/commit")
    public String post(Type type){
        Type type1 = typeService.saveType(type);
        if(type1 != null){

        }else {

        }
        return "redirect:/admin/types";
    }

}