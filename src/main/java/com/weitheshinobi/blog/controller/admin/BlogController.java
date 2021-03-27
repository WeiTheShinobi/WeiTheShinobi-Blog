package com.weitheshinobi.blog.controller.admin;

import com.weitheshinobi.blog.constant.BlogConstant;
import com.weitheshinobi.blog.constant.UserConstant;
import com.weitheshinobi.blog.pojo.Blog;
import com.weitheshinobi.blog.pojo.Tag;
import com.weitheshinobi.blog.pojo.User;
import com.weitheshinobi.blog.service.BlogService;
import com.weitheshinobi.blog.service.TagService;
import com.weitheshinobi.blog.service.TypeService;
import com.weitheshinobi.blog.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

import static com.weitheshinobi.blog.constant.BlogConstant.*;
import static com.weitheshinobi.blog.constant.TagConstant.MESSAGE;
import static com.weitheshinobi.blog.constant.TagConstant.RESULT_MESSAGE_SUCCESS;

@Controller
public class BlogController {

    private static final String INPUT = "admin/blogs-input";
    private static final String LIST = "admin/blogs";
    private static final String REDIRECT_LIST = "redirect:/admin/blogs";

    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;

    @GetMapping("/admin/blogs")
    public String blogs(@PageableDefault(sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                        BlogQuery blog, Model model) {
        model.addAttribute("types", typeService.listType());
        model.addAttribute("page", blogService.listBlog(pageable, blog));
        return LIST;
    }

    @RequestMapping("/admin/blogs/search")
    public String search(@PageableDefault(sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                        BlogQuery blog,Model model) {
        model.addAttribute("page", blogService.listBlog(pageable, blog));
        return "admin/blogs :: blogList";
    }


    @RequestMapping("/admin/blogs/input")
    public String input(Model model) {
        model.addAttribute("types",typeService.listType());
        model.addAttribute("tags",tagService.listTag());
        model.addAttribute("blog", new Blog());
        return INPUT;
    }

    @RequestMapping("/admin/blogs/{id}/input")
    public String editInput(@PathVariable Long id , Model model) {
        model.addAttribute("types",typeService.listType());
        model.addAttribute("tags",tagService.listTag());
        Blog blog = blogService.getBlogByID(id);
        blog.init();
        model.addAttribute("blog", blog);
        return INPUT;
    }

    @PostMapping("/admin/blogs")
    public String post(Blog blog, RedirectAttributes attributes, HttpSession session) {
        blog.setUser((User) session.getAttribute("user"));
        blog.setType(typeService.getTypeById(blog.getType().getId()));
        blog.setTags(tagService.listTag(blog.getTagIds()));
        Blog b;
        if (blog.getId() == null) {
            b =  blogService.saveBlog(blog);
        } else {
            b = blogService.updateBlog(blog.getId(),blog);
        }

        if (b == null ) {
            attributes.addFlashAttribute(MESSAGE, RESULT_MESSAGE_FAIL);
        } else {
            attributes.addFlashAttribute(MESSAGE, RESULT_MESSAGE_SUCCESS);
        }
        return REDIRECT_LIST;
    }

    @RequestMapping("/admin/blogs/{id}/delete")
    public String delete(RedirectAttributes attributes,@PathVariable Long id){
        blogService.deleteBlog(id);
        attributes.addFlashAttribute(MESSAGE,RESULT_MESSAGE_SUCCESS);
        return REDIRECT_LIST;
    }
}
