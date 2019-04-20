 package cn.blog.controller.admin;

 import cn.blog.entity.Blogger;
 import cn.blog.service.BloggerService;
 import cn.blog.util.CryptographyUtil;
 import cn.blog.util.DateUtil;
 import cn.blog.util.ResponseUtil;
 import java.io.File;
 import javax.annotation.Resource;
 import javax.servlet.ServletContext;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import net.sf.json.JSONObject;
 import org.apache.shiro.SecurityUtils;
 import org.apache.shiro.subject.Subject;
 import org.springframework.stereotype.Controller;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RequestParam;
 import org.springframework.web.multipart.MultipartFile;

 @Controller
 @RequestMapping({"/admin/blogger"})
 public class BloggerAdminController {
  @Resource
  private BloggerService bloggerService;

  @RequestMapping({"/save"})
  public String save(@RequestParam("imageFile") MultipartFile imageFile, Blogger blogger, HttpServletRequest request, HttpServletResponse response) throws Exception {

      if (!imageFile.isEmpty()) {
          String filePath = request.getServletContext().getRealPath("/");
          String imageName = DateUtil.getCurrentDateStr() + "." + imageFile.getOriginalFilename().split("\\.")[1];
          imageFile.transferTo(new File(filePath + "static/userImages/" + imageName));
          blogger.setImageName(imageName);
      }
      int resultTotal = this.bloggerService.update(blogger).intValue();
      StringBuffer result = new StringBuffer();
      if (resultTotal > 0) {
          result.append("<script language='javascript'>alert('修改成功！');</script>");
      } else {
          result.append("<script language='javascript'>alert('修改失败！');</script>");
      }
      ResponseUtil.write(response, result);
      return null;
  }

  @RequestMapping({"/find"})
  public String find(HttpServletResponse response) throws Exception {
      Blogger blogger = this.bloggerService.find();
      JSONObject jsonObject = JSONObject.fromObject(blogger);
      ResponseUtil.write(response, jsonObject);
      return null;
  }

  @RequestMapping({"/modifyPassword"})
  public String modifyPassword(String newPassword, HttpServletResponse response) throws Exception {
      Blogger blogger = new Blogger();
      blogger.setPassword(CryptographyUtil.md5(newPassword, "java1234"));
      int resultTotal = this.bloggerService.update(blogger).intValue();
      JSONObject result = new JSONObject();
      if (resultTotal > 0) {
          result.put("success", Boolean.valueOf(true));
      } else {
          result.put("success", Boolean.valueOf(false));
      }
      ResponseUtil.write(response, result);
      return null;
  }

  @RequestMapping({"/logout"})
  public String logout() throws Exception {
     SecurityUtils.getSubject().logout();
     return "redirect:/login.jsp";
   }
 }

