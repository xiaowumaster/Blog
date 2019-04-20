package cn.blog.service.impl;

import cn.blog.dao.BlogTypeDao;
import cn.blog.entity.BlogType;
import cn.blog.service.BlogTypeService;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("blogTypeService")
public class BlogTypeServiceImpl implements BlogTypeService {
    @Resource
    private BlogTypeDao blogTypeDao;

    public List<BlogType> countList() {
        return this.blogTypeDao.countList();
    }

    public List<BlogType> list(Map<String, Object> map) {
        return this.blogTypeDao.list(map);
    }

    public Long getTotal(Map<String, Object> map) {
        return this.blogTypeDao.getTotal(map);
    }

    public Integer add(BlogType blogType) {
        return this.blogTypeDao.add(blogType);
    }

    public Integer update(BlogType blogType) {
        return this.blogTypeDao.update(blogType);
    }

    public Integer delete(Integer id) {
        return this.blogTypeDao.delete(id);
    }
}
