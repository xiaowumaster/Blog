package cn.blog.dao;

import cn.blog.entity.Comment;
import java.util.List;
import java.util.Map;

public interface CommentDao
{
  public int add(Comment paramComment);
  
  public int update(Comment paramComment);
  
  public List<Comment> list(Map<String, Object> paramMap);
  
  public Long getTotal(Map<String, Object> paramMap);
  
  public Integer delete(Integer paramInteger);
}


