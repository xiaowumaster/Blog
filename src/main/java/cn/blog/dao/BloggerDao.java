package cn.blog.dao;

import cn.blog.entity.Blogger;

public interface BloggerDao
{
  public Blogger find();
  
  public Blogger getByUserName(String paramString);
  
  public Integer update(Blogger paramBlogger);
}


