package cn.blog.service.impl;

import cn.blog.dao.BlogDao;
import cn.blog.entity.Blog;
import cn.blog.service.BlogService;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("blogService")
public class BlogServiceImpl implements BlogService {
    @Resource
    private BlogDao blogDao;

    public List<Blog> countList() {
        return this.blogDao.countList();
    }

    public List<Blog> list(Map<String, Object> map) {
        return this.blogDao.list(map);
    }

    public Long getTotal(Map<String, Object> map) {
        return this.blogDao.getTotal(map);
    }

    public Blog findById(Integer id) {
        return this.blogDao.findById(id);
    }

    public Integer update(Blog blog) {
        return this.blogDao.update(blog);
    }

    public Blog getLastBlog(Integer id) {
        return this.blogDao.getLastBlog(id);
    }

    public Blog getNextBlog(Integer id) {
        return this.blogDao.getNextBlog(id);
    }

    public Integer add(Blog blog) {
        return this.blogDao.add(blog);
    }

    public Integer delete(Integer id) {
        return this.blogDao.delete(id);
    }

    public Integer getBlogByTypeId(Integer typeId) {
        return this.blogDao.getBlogByTypeId(typeId);
    }
}

