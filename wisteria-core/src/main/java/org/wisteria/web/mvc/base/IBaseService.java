package org.wisteria.web.mvc.base;

import org.wisteria.web.mvc.model.PageResult;

public interface IBaseService<P, M, V> {

	boolean add(M record);
	
	V query(P id);
	PageResult<V> queryByPage(M record, int pageIndex, int pageSize);
	
	boolean modify(M record);
	
	@SuppressWarnings("unchecked")
	boolean remove(P... id);
	
}
