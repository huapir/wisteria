$(function () {
    var _connectionKey;
    
    $('#connect').click(function () {
        var _connectString = $('#connectString').val();
        ligutils.ajaxget({
            url: '/zk/connect/'
            ,data: {connectString: _connectString},
            success: function (result) {
                _connectionKey = result.data;
                loadTree(_connectionKey, '');
                ligutils.success('连接成功!')

            }
        });
    });
    

});
function loadTree(connectionKey, path) {
    // zTree 的参数配置
    var setting = {
        async: {
            enable: true
            ,url: '/zk/node/children/?key=' + connectionKey
        }
    };
    // zTree 的数据属性，深入使用请参考 API 文档（zTreeNode 节点数据详解）
    var zNodes = [
        {name:"test1", open:true, children:[
            {name:"test1_1"}, {name:"test1_2"}]},
        {name:"test2", open:true, children:[
            {name:"test2_1"}, {name:"test2_2"}]}
    ];
    var treeObjct = $.fn.zTree.init($('#treeData'), setting);
}