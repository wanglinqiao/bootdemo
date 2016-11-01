package com.jyall.resource;

import com.jyall.common.Constans;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Calendar;

/**
 * Created by wang.linqiao on 2016/10/28.
 */
@Controller
@ApiIgnore
public class PageResource {
    @RequestMapping("/")
    public String toHome(Model model){
        model.addAttribute("welcome","欢迎光临本店！");
        model.addAttribute("today", Calendar.getInstance());
        model.addAttribute("productSortMap", Constans.PRODUCT_SORT_MAP);
        return "/home";
    }

    @RequestMapping("/toPage")
    public String toPage(String pageName){
        return "/"+pageName;
    }
}
