package cn.blog.service.impl;

import cn.blog.dao.BloggerDao;
import cn.blog.entity.Blogger;
import cn.blog.service.BloggerService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("bloggerService")
public class BloggerServiceImpl implements BloggerService {
    @Resource
    private BloggerDao bloggerDao;

    public Blogger find() {
        return this.bloggerDao.find();
    }
    public Blogger getByUserName(String userName) {
        return this.bloggerDao.getByUserName(userName);
    }

    public Integer update(Blogger blogger) {
        return this.bloggerDao.update(blogger);
    }
}
