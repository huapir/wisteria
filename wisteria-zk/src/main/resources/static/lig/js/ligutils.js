;!function(window, undefined){
	var table = layui.table;
	
	var ligutils = {
			
		/**弹出层（遮盖）工具类 A**/
		alert: function(message) {
			return layer.alert(message, {icon: 6});
		},
		confirm: function(message, opt, success, error) {
			return layer.confirm(message, opt, success, error);
		},
		error: function(message) {
			layer.alert(message, {icon: 5});
		},
		success: function(message) {
			layer.msg(message, {icon: 1,time: 1500});
		},
		fail: function(message) {
			layer.alert(message, {icon: 5});
		},
		info: function(){},
		open: function(html, option) {
			var _widh = 'auto',
				_height = 'auto';
			if (typeof option != 'undefined') {
				if (typeof option.width != 'undefined' && option.width != '') {
					_widh = option.width + 'px';
				}
				if (typeof option.height != 'undefined' && option.height != '') {
					_height = option.height + 'px';
				}
			}
			return layer.open({
			  type: 1,
			  area: [_widh, _height], //宽高
			  content: html
			});
		},
		closeLayer: function(index) {
			layer.close(index);
		},
		/**弹出层（遮盖）工具类 Z**/
		
		
		/**table工具类 A**/
		/**封装layui grid**/
		table: function(options, toolEvent) {
			if (typeof options == 'undefined') {
				return;
			}
			
			if (typeof options.height == 'undefined') {
				options.height = 'full-107';
			}
			
			if (typeof options.page == 'undefined') {
				options.page = true;//开启分页,
			}
			options.request = {
		    	pageName: 'pageIndex' //页码的参数名称，默认：page
		    	,limitName: 'pageSize' //每页数据量的参数名，默认：limit
		    }
			options.response = {
			  statusName: 'code' //数据状态的字段名称，默认：code
			  ,statusCode: 200 //成功的状态码，默认：0
			  ,msgName: 'message' //状态信息的字段名称，默认：msg
			  ,countName: 'total' //数据总数的字段名称，默认：count
			  ,dataName: 'data' //数据列表的字段名称，默认：data
			}
			
			// 表格数据加载完成
			if (typeof options.done != 'undefined'
					&& typeof options.done == 'function') {
				options.done = options.done;
			}
			var _table = table.render(options);
			
			if (typeof options.toolEvent != 'undefined'
					&& typeof options.toolEvent == 'function') {
				table.on('tool', function(obj){
					options.toolEvent(obj);
				});
			}

            //监听表格复选框选择
			if (typeof options.checkboxEvent != 'undefined'
				&& typeof options.checkboxEvent == 'function') {
                table.on('checkbox(' + options.id + ')', function(obj){
                	options.checkboxEvent(obj);
                });
			}

			
			return _table;
		},
		selectedRows: function(tableId) {
			return  table.checkStatus(tableId);
		},
		/**table工具类 Z**/
		
		/**ajax工具类 A**/
		ajaxpost: function(option) {
			$.ajax({
				type: 'post',
				dataType: 'json',
				url: option.url,
				data: option.data,
				success: function(result) {
					if (result.success) {
						option.success(result);
					}
				},
				error: function() {}
			});
		},
		ajaxget: function(option) {
			$.ajax({
				type: 'get',
				dataType: 'json',
				url: option.url,
				data: option.data,
				success: function(result) {
					if (result.success) {
						option.success(result);
					}
				},
				error: function() {}
			});
		},
		ajaxput: function(option) {
			$.ajax({
				type: 'put',
				dataType: 'json',
				url: option.url,
				data: option.data,
				success: function(result) {
					if (result.success) {
						option.success(result);
					}
				},
				error: function() {}
			});
		}
		/**ajax工具类 Z**/
	}
	
	window.ligutils = ligutils;
}(window);
