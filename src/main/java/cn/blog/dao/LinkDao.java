package cn.blog.dao;

import cn.blog.entity.Link;
import java.util.List;
import java.util.Map;

public interface LinkDao {

  public int add(Link paramLink);

  public int update(Link paramLink);

  public List<Link> list(Map<String, Object> paramMap);

  public Long getTotal(Map<String, Object> paramMap);

  public Integer delete(Integer paramInteger);
}

