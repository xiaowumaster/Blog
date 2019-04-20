package cn.blog.service.impl;

import cn.blog.dao.CommentDao;
import cn.blog.entity.Comment;
import cn.blog.service.CommentService;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentDao commentDao;

    public int add(Comment comment) {
        return this.commentDao.add(comment);
    }

    public List<Comment> list(Map<String, Object> map) {
        return this.commentDao.list(map);
    }

    public Long getTotal(Map<String, Object> map) {
        return this.commentDao.getTotal(map);
    }

    public Integer delete(Integer id) {
        return this.commentDao.delete(id);
    }

    public int update(Comment comment) {
        return this.commentDao.update(comment);
    }
}

