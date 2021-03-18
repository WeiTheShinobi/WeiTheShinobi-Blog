package com.weitheshinobi.blog.controller.admin;

import com.weitheshinobi.blog.pojo.Tag;
import com.weitheshinobi.blog.pojo.Type;
import com.weitheshinobi.blog.service.TagService;
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

import static com.weitheshinobi.blog.constant.TagConstant.*;

@Controller
public class TagController {

    @Autowired
    private TagService tagService;

//    跳轉到分頁並顯示
    @RequestMapping("/admin/tags")
    public String list(@PageableDefault(sort = {"id"},direction = Sort.Direction.DESC) Pageable pageable,
                       Model model){
        Page<Tag> tags = tagService.listTag(pageable);
        model.addAttribute(PAGE,tags);
        return "admin/tags";
    }

    @RequestMapping("/admin/tags/input")
    public String input(){
        return "admin/tags-input";
    }

    @RequestMapping("/admin/tags/{id}/input")
    public String editInput(@PathVariable Long id , Model model){
        model.addAttribute(TAG,tagService.getTagById(id));
        return "admin/tags-input";
    }

//    新增Tag
    @PostMapping("/admin/tags/commit")
    public String post(Tag tag, RedirectAttributes attributes){
        Tag tagByName = tagService.getTagByName(tag.getName());
        if(tagByName != null){
            attributes.addFlashAttribute(MESSAGE,RESULT_MESSAGE_DUPLICATE);
            return "redirect:/admin/tags";
        }

        Tag tag1 = tagService.saveTag(tag);
//        成功失敗的回饋訊息
        if(tag1 != null){
            attributes.addFlashAttribute(MESSAGE,RESULT_MESSAGE_SUCCESS);
        }else {
            attributes.addFlashAttribute(MESSAGE,RESULT_MESSAGE_FAIL);
        }
        return "redirect:/admin/tags";
    }

//    修改Tag
    @PostMapping("/admin/tags/{id}")
    public String editPost(Tag tag,@PathVariable Long id, RedirectAttributes attributes){
        Tag tagByName = tagService.getTagByName(tag.getName());
        if(tagByName != null){
            attributes.addFlashAttribute(MESSAGE,RESULT_MESSAGE_DUPLICATE);
            return "redirect:/admin/tags";
        }

        Tag tag1 = tagService.updateTag(id,tag);
//        成功失敗的回饋訊息
        if(tag1 != null){
            attributes.addFlashAttribute(MESSAGE,RESULT_MESSAGE_SUCCESS);
        }else {
            attributes.addFlashAttribute(MESSAGE,RESULT_MESSAGE_FAIL);
        }
        return "redirect:/admin/tags";
    }

    @RequestMapping("/admin/tags/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
        tagService.deleteTag(id);
        attributes.addFlashAttribute(MESSAGE,RESULT_MESSAGE_SUCCESS);
        return "redirect:/admin/tags";
    }

}
