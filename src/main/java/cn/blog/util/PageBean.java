package cn.blog.util;

/**
 * @author xiaowu
 * @create 2019-03-01  13:27
 */
public class PageBean {
    private int page;
    private int pageSize;
    private int start;

    public PageBean(int page, int pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStart() {
        return (this.page - 1) * pageSize;
    }

    public void setStart(int start) {
        this.start = start;
    }
}
