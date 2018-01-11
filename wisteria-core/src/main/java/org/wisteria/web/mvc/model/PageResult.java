package org.wisteria.web.mvc.model;

import java.util.List;

/**
 * 
 * @author huaPi
 *
 * @param <T>
 */
public class PageResult<T> {
	private long total;
    private List<T> items;

    public PageResult() {}

    public PageResult(long total,List<T> items){
        this.total = total;
        this.items = items;
    }

    /*
    public PageResult(Page<T> page){
        PageInfo pageInfo = page.toPageInfo();
        this.total = pageInfo.getTotal();
        this.items = pageInfo.getList();
    }
	*/
    
    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

}
