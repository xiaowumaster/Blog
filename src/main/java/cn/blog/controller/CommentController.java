package cn.blog.controller;

import cn.blog.entity.Blog;
import cn.blog.entity.Comment;
import cn.blog.service.BlogService;
import cn.blog.service.CommentService;
import cn.blog.util.ResponseUtil;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({"/comment"})
public class CommentController {
    @Resource
    private CommentService commentService;

    @Resource
    private BlogService blogService;

    @RequestMapping({"/save"})
    public String save(Comment comment, @RequestParam("imageCode") String imageCode, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        String sRand = (String)session.getAttribute("sRand");
        JSONObject result = new JSONObject();
        int resultTotal = 0;
        if (!imageCode.equals(sRand)) {
            result.put("success", Boolean.valueOf(false));
            result.put("errorInfo", "验证码填写错误！");
        } else {
            String userIp = request.getRemoteAddr();
            comment.setUserIp(userIp);
            if (comment.getId() == null) {
                resultTotal = this.commentService.add(comment);
                Blog blog = this.blogService.findById(comment.getBlog().getId());
                blog.setReplyHit(Integer.valueOf(blog.getReplyHit().intValue() + 1));
                this.blogService.update(blog);
            }
            if (resultTotal > 0) {
                result.put("success", Boolean.valueOf(true));
            } else {
                result.put("success", Boolean.valueOf(false));
            }
        }
        ResponseUtil.write(response, result);
        return null;
    }
}
