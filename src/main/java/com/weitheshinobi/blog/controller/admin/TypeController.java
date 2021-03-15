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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @RequestMapping("/admin/types/{id}/input")
    public String editInput(@PathVariable Long id , Model model){
        model.addAttribute(TypeConstant.TYPE,typeService.getTypeById(id));
        return "admin/types-input";
    }

//    新增Type
    @PostMapping("/admin/types/commit")
    public String post(Type type, RedirectAttributes attributes){
        Type typeByName = typeService.getTypeByName(type.getName());
        if(typeByName != null){
            attributes.addFlashAttribute(TypeConstant.MESSAGE,TypeConstant.RESULT_MESSAGE_DUPLICATE);
            return "redirect:/admin/types";
        }

        Type type1 = typeService.saveType(type);
//        成功失敗的回饋訊息
        if(type1 != null){
            attributes.addFlashAttribute(TypeConstant.MESSAGE,TypeConstant.RESULT_MESSAGE_SUCCESS);
        }else {
            attributes.addFlashAttribute(TypeConstant.MESSAGE,TypeConstant.RESULT_MESSAGE_FAIL);
        }
        return "redirect:/admin/types";
    }

//    修改Type
    @PostMapping("/admin/types/{id}")
    public String editPost(Type type,@PathVariable Long id, RedirectAttributes attributes){
        Type typeByName = typeService.getTypeByName(type.getName());
        if(typeByName != null){
            attributes.addFlashAttribute(TypeConstant.MESSAGE,TypeConstant.RESULT_MESSAGE_DUPLICATE);
            return "redirect:/admin/types";
        }

        Type type1 = typeService.updateType(id,type);
//        成功失敗的回饋訊息
        if(type1 != null){
            attributes.addFlashAttribute(TypeConstant.MESSAGE,TypeConstant.RESULT_MESSAGE_SUCCESS);
        }else {
            attributes.addFlashAttribute(TypeConstant.MESSAGE,TypeConstant.RESULT_MESSAGE_FAIL);
        }
        return "redirect:/admin/types";
    }

    @RequestMapping("/admin/types/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
        typeService.deleteType(id);
        attributes.addFlashAttribute(TypeConstant.MESSAGE,TypeConstant.RESULT_MESSAGE_SUCCESS);
        return "redirect:/admin/types";
    }

}
