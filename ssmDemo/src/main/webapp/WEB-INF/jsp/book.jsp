<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>layui</title>
  <link rel="stylesheet" href="/ssmDemo/layui/css/layui.css"  media="all">
   <script src="/ssmDemo/js/jquery.js" type="text/javascript"></script>
  <script src="/ssmDemo/layui/layui.js" charset="utf-8"></script>
 
</head>
<script>
</script>
<body>
<table class="layui-hide" id="demo" lay-filter="test"></table>

<div class="site-text" style="margin: 5%; display: none" id="window">
    	<form class="layui-form" action="addBook" method="post" id="form">
    		<input type="hidden" name="id" id="id"  class="layui-input">
    		<div class="layui-form-item">
	    		<label class="layui-form-label">书名：</label>
	   			<div class="layui-input-block">
	      			<input type="text" name="name" id="name"  class="layui-input">
	    		</div>
	    	</div>
	    	<div class="layui-form-item">
	    		<label class="layui-form-label">作者：</label>
	   			<div class="layui-input-block">
	      			<input type="text" name="author" id="author"  class="layui-input">
	    		</div>
	    	</div>
	    	<div class="layui-form-item">
    			<label class="layui-form-label">价格：</label>
		    	<div class="layui-input-block">
	      			<input type="text" name="price" id="price" class="layui-input">
	    		</div>
  			</div>
			
  			<div class="layui-form-item">
		    		<label class="layui-form-label">出版日期：</label>
		   			<div class="layui-input-block">
		      			<input type="date" name="date" id="date" class="layui-input">
		    		</div>
  			</div>
  			<div class="layui-form-item">
			    <div class="layui-input-block">
			      <button class="layui-btn" lay-submit="submit">立即提交</button>
			    </div>
	  		</div> 
  		</form>
	</div>              
<script id="toolbarDemo" type="text/html">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="add">添加</button>
  </div>
</script>
                
<script id="barDemo" type="text/html">
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
</body>
<script>
layui.use('table', function(){
  var table = layui.table;
  
  //展示已知数据
  table.render({
	url:'findBook',
	title: '图书数据表',
	toolbar: '#toolbarDemo',
    elem: '#demo',
    cols: [[ //标题栏
      {field: 'id', title: '编号', width: 220},
      {field: 'name', title: '书名', width: 220},
      {field: 'author', title: '作者名', width: 220},
      {field: 'price', title: '价格', minWidth: 220},
      {field: 'date', title: '出版日期', minWidth: 220},
      {fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
    ]],
		
    //,skin: 'line' //表格风格
    even: true,
    page: true,
    limits: [5, 7, 10],
    limit: 5 //每页默认显示的数量
  });
  
	//头工具栏事件
	table.on('toolbar(test)', function(obj){
		if(obj.event=='add'){
			layer.open({
              type: 1, 
              title:"新增",
              area: '550px',			
              content: $("#window"),
              success: function(layero, index){
          	    $("#id").val("0");
          		}
            });	
			}
		});
	
	  //监听行工具事件
	  table.on('tool(test)', function(obj){
	    var data = obj.data;
	    //console.log(obj)
	    if(obj.event === 'del'){
	      layer.confirm('真的删除行么', function(index){
	        $.ajax({
	        	url:"deleteBook",
	        	data:{
	        		id:data.id
	        	},
	        	dataType:"json",
	        	success:function(result){
	        		console.log(result);
	        		if(result.msg=="删除成功"){
	        			layer.close(index);
	        			table.reload('demo', {
	        				  url: 'findBook'
	        				});
	        		}
	        	}
	        })
	       
	      });
	    } else if(obj.event === 'edit'){
	    	layer.open({
	              type: 1, 
	              title:"修改",
	              area: '550px',			
	              content: $("#window"),
	              success: function(layero, index){
	            	    $("#id").val(data.id);
	            	    $("#name").val(data.name);
	            	    $("#author").val(data.author);
	            	    $("#price").val(data.price);
	            	    $("#date").val(data.date);
	            	}
	         });	
	    }
	  });
});
</script>
 
     
</html>