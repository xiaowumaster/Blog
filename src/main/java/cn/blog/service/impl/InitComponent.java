/*
package cn.blog.service.impl;

import cn.blog.entity.Blog;
import cn.blog.entity.BlogType;
import cn.blog.entity.Blogger;
import cn.blog.entity.Link;
import cn.blog.service.BlogService;
import cn.blog.service.BlogTypeService;
import cn.blog.service.BloggerService;
import cn.blog.service.LinkService;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class InitComponent implements ServletContextListener, ApplicationContextAware {
    private static ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        InitComponent.applicationContext = applicationContext;
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext application = servletContextEvent.getServletContext();
        BloggerService bloggerService = (BloggerService)applicationContext.getBean("bloggerService");

        Blogger blogger = bloggerService.find();
        blogger.setPassword(null);
        application.setAttribute("blogger", blogger);

        BlogTypeService blogTypeService = (BlogTypeService)applicationContext.getBean("blogTypeService");
        List<BlogType> blogTypeCountList = blogTypeService.countList();
        application.setAttribute("blogTypeCountList", blogTypeCountList);

        BlogService blogService = (BlogService)applicationContext.getBean("blogService");
        List<Blog> blogCountList = blogService.countList();
        application.setAttribute("blogCountList", blogCountList);

        LinkService linkService = (LinkService)applicationContext.getBean("linkService");
        List<Link> linkList = linkService.list(null);
        application.setAttribute("linkList", linkList);

    }


    public void contextDestroyed(ServletContextEvent sce) {}
}
*/
