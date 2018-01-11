package org.wisteria.web.mvc.base;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;

public interface BaseMapper<P, M, V> {

	int insert(M record);
	
	int update(M record);
	
	V select(@Param("id") P id);
	Page<V> selectByPage(M record);
	
	int deleteBatchIds(@SuppressWarnings("unchecked") @Param("ids") P... ids);
	
}
