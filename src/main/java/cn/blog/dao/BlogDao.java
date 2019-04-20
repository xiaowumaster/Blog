package cn.blog.dao;

import cn.blog.entity.Blog;
import java.util.List;
import java.util.Map;

public interface BlogDao {

  public List<Blog> countList();
  
  public List<Blog> list(Map<String, Object> paramMap);
  
  public Long getTotal(Map<String, Object> paramMap);
  
  public Blog findById(Integer paramInteger);
  
  public Integer update(Blog paramBlog);
  
  public Blog getLastBlog(Integer paramInteger);
  
  public Blog getNextBlog(Integer paramInteger);
  
  public Integer add(Blog paramBlog);
  
  public Integer delete(Integer paramInteger);
  
  public Integer getBlogByTypeId(Integer paramInteger);
}

