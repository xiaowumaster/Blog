package cn.blog.controller.admin;

import cn.blog.entity.BlogType;
import cn.blog.util.PageBean;
import cn.blog.service.BlogService;
import cn.blog.service.BlogTypeService;
import cn.blog.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping({"/admin/blogType"})
public class BlogTypeAdminController {
    @Resource
    private BlogTypeService blogTypeService;
    @Resource
    private BlogService blogService;

    @RequestMapping({"/list"})
    public String list(@RequestParam(value="page", required=false) String page, @RequestParam(value="rows", required=false) String rows, HttpServletResponse response) throws Exception {
        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        Map<String, Object> map = new HashMap();
        map.put("start", Integer.valueOf(pageBean.getStart()));
        map.put("size", Integer.valueOf(pageBean.getPageSize()));
        List<BlogType> blogTypeList = this.blogTypeService.list(map);Long total = this.blogTypeService.getTotal(map);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(blogTypeList);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.write(response, result);
        return null;
    }

    @RequestMapping({"/save"})
    public String save(BlogType blogType, HttpServletResponse response) throws Exception {
        int resultTotal = 0;
        if (blogType.getId() == null) {
            resultTotal = this.blogTypeService.add(blogType).intValue();
        } else {
            resultTotal = this.blogTypeService.update(blogType).intValue();
        }
        JSONObject result = new JSONObject();
        if (resultTotal > 0) {
            result.put("success", Boolean.valueOf(true));
        } else {
            result.put("success", Boolean.valueOf(false));
        }
        ResponseUtil.write(response, result);
        return null;
    }

    @RequestMapping({"/delete"})
    public String delete(@RequestParam("ids") String ids, HttpServletResponse response) throws Exception {
        String[] idsStr = ids.split(",");
        JSONObject result = new JSONObject();
        for (int i = 0; i < idsStr.length; i++) {
            if (this.blogService.getBlogByTypeId(Integer.valueOf(Integer.parseInt(idsStr[i]))).intValue() > 0) {
                result.put("exist", "博客类别下有博客，不能删除！");
            } else {
                this.blogTypeService.delete(Integer.valueOf(Integer.parseInt(idsStr[i])));
            }
        }
        result.put("success", Boolean.valueOf(true));
        ResponseUtil.write(response, result);
        return null;
    }
}
