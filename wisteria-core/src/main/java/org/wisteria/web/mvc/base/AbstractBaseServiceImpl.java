package org.wisteria.web.mvc.base;

import org.wisteria.web.mvc.model.PageResult;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

public abstract class AbstractBaseServiceImpl<P, M, V> implements IBaseService<P, M, V> {
	
	public abstract BaseMapper<P, M, V> getBaseMapper();

	@Override
	public boolean add(M record) {
		return getBaseMapper().insert(record) > 0;
	}
	
	@Override
	public V query(P id) {
		return getBaseMapper().select(id);
	}

	@Override
	public PageResult<V> queryByPage(M record, int pageIndex, int pageSize) {
		PageHelper.startPage(pageIndex, pageSize);
		Page<V> page = getBaseMapper().selectByPage(record);
		return new PageResult<V>(page.getTotal(), page.getResult());
	}

	@Override
	public boolean modify(M record) {
		return getBaseMapper().update(record) > 0;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean remove(P... id) {
		return getBaseMapper().deleteBatchIds(id) > 0;
	}

}
