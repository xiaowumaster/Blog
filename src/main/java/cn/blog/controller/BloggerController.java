
package cn.blog.controller;

import cn.blog.entity.Blogger;
import cn.blog.service.BloggerService;
import cn.blog.util.CryptographyUtil;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"/blogger"})
public class BloggerController {
    @Resource
    private BloggerService bloggerService;

    @RequestMapping({"/login"})
    public String login(Blogger blogger, HttpServletRequest request) {
        ///Subject subject = SecurityUtils.getSubject();
        //UsernamePasswordToken token = new UsernamePasswordToken(blogger.getUserName(), CryptographyUtil.md5(blogger.getPassword(), "java1234"));
        /*try
        {
            //String username = request.getParameter("username");
            //Blogger blogger1 = bloggerService.getByUserName(username);

            //subject.login(token);
            return "redirect:/admin/main.jsp";
        }
        catch (Exception e)
        {
            e.printStackTrace();
            request.setAttribute("blogger", blogger);
            request.setAttribute("errorInfo", "用户名或密码错误！");
        }
        return "login";*/
        String username = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        String s = CryptographyUtil.md5("passWord", "java1234");
        Blogger blogger1 = bloggerService.getByUserName(username);
        System.out.println(blogger1.getPassword());
        if (blogger1.getPassword().equals(s)) {
            return "redirect:/admin/main.jsp";
        }
        return "login";
    }


    @RequestMapping({"/aboutMe"})
    public ModelAndView aboutMe() throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("blogger", this.bloggerService.find());
        mav.addObject("mainPage", "foreground/blogger/info.jsp");
        mav.addObject("pageTitle", "关于博主_Java开源博客系统");
        mav.setViewName("mainTemp");
        return mav;
    }
}

