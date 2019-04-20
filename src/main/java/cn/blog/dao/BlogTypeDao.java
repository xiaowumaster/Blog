package cn.blog.dao;

import cn.blog.entity.BlogType;
import java.util.List;
import java.util.Map;

public interface BlogTypeDao
{
  public List<BlogType> countList();
  
  public BlogType findById(Integer paramInteger);
  
  public List<BlogType> list(Map<String, Object> paramMap);
  
  public Long getTotal(Map<String, Object> paramMap);
  
  public Integer add(BlogType paramBlogType);
  
  public Integer update(BlogType paramBlogType);
  
  public Integer delete(Integer paramInteger);
}

