<%@ page language="java" import="java.util.*,com.product.bean.CustomerBean,com.product.dao.CustomerDao" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
<style>  
.conter  
{  
width:100%;  
height:300px;  
border:0px solid #000;  
padding:0px;  
} 
 
.conter h1  
{  
height:20px;  
font-size:14px;  
font-weight:bold;
background:#F2F9FD;  
line-height:20px;  
text-indent:5px;  
margin-top:0px;  
}  
</style>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 修改客户信息</strong></div>
  <div class="conter"><h1>基本信息</h1>
  <div class="body-content">
    <form method="post" class="form-x" action="ModifycusServlet.do">
     <%	 
           CustomerBean ub  = (CustomerBean)request.getAttribute("cus");%>
           
           
           
           <table border=0 style="border-spacing:5px; width:1000px;height:250px" >
           <tr>
	           <td style="vertical-align:middle;">
				       <div class="label">
                       <label for="sitename">单位编码：</label>
        </div>
	           </td>
              <td style="vertical-align:middle;"> 
		                    <div class="field">
                                  <input type="text"  style="width:200px;" class="input w50"  name="cuid" size="50" placeholder="请输入单位编码" data-validate="required:请输入单位编码" readonly value=<%= ub.getCuid() %> >        
                              </div>    
			  </td>
	           <td style="vertical-align:middle;">
				                <div class="label">
							          <label for="sitename">单位名称：</label>
							        </div>
	           </td>
	           <td style="vertical-align:middle;"> 
			                   <div class="field">
						          <input type="text"  style="width:200px;" class="input w50"  name="cucompany" size="50" placeholder="请输入单位名称" data-validate="required:请输入单位名称" value=<%= ub.getCucompany() %> />       
						        </div>
		        </td>
           </tr>
        <tr>
	        <td style="vertical-align:middle;">
		         <div class="label">
		          <label for="sitename">联系人：</label>
		        </div>
	        </td>
	        <td style="vertical-align:middle;">       
		          <div class="field">
		          <input type="text"   style="width:200px;" class="input w50" name="cuconnector" size="50" placeholder="请输入联系人" data-validate="required:请输入联系人" value=<%= ub.getCuconnector() %> />       
		        </div>
	        </td>
	        <td style="vertical-align:middle;">
		        <div class="label">
		          <label for="sitename">电话：</label>
		        </div>
	        </td>
	        <td style="vertical-align:middle;">
		          <div class="field">
			         <input type="text"  style="width:200px;" class="input w50"  name="cutel" size="50" placeholder="请输入联系人" data-validate="required:请输入电话" value=<%= ub.getCutel() %> />       
			        </div>
	      </td>
        </tr>
            <tr>
		        <td style="vertical-align:middle;">
			         <div class="label">
				          <label for="sitename">email：</label>
				        </div>
		        </td>
			        <td style="vertical-align:middle;">
				         <div class="field">
				         <input type="text"  style="width:200px;" class="input w50"  name="cuemail" size="50" placeholder="请输入联系人" data-validate="required:请输入email" value=<%= ub.getCuemail()%> />              
				        </div> 
			        </td>
			        <td style="vertical-align:middle;"> 
				         <div class="label">
				          <label for="sitename">邮编：</label>
				        </div>
			        </td>
			       	 <td style="vertical-align:middle;"> 
					       	 <div class="field">
					         <input type=type="text"   style="width:200px;" class="input w50"  name="cucode" size="50" placeholder="请输入邮编" data-validate="required:请输入邮编" value=<%= ub.getCucode() %> />       
					        </div>
			        </td>
        	</tr>
        <tr>
			        <td style="vertical-align:middle;">    
					        <div class="label">
					          <label for="sitename">地址：</label>
					        </div>
			        </td>
			        <td style="vertical-align:middle;"> 
					         <div class="field">
					         <input type="text" class="input w50"  style="width:200px;"  name="cuaddress" size="50" placeholder="请输入地址" data-validate="required:请输入地址" value=<%= ub.getCuaddress()%> />       
					        </div>
			        </td>
			        <td style="vertical-align:middle;">
				       <div class="label">
				          <label for="sitename">备注：</label>
				        </div>
			     	</td>
				     <td style="vertical-align:middle;">    
					      <div class="field">
					         <input type="text" class="input w50"  style="width:200px;" id="mpass" name="curemark" size="50" placeholder="请输入地址" data-validate="required:请输入地址" value=<%= ub.getCuremark()%> />       
					        
					        </div>
				    </td>
        </tr>    
         <tr>
			        <td style="vertical-align:middle;">      
			        </td>
			        <td style="vertical-align:middle;"> 
					    <button class="button bg-main icon-check-square-o" type="submit"> 修改</button>     
			        </td>
			        <td style="vertical-align:middle;">
			        <button class="button bg-main icon-check-square-o"  onclick="javascript:history.go(-1);"> 返回</button>
                        
			     	</td>
				     <td style="vertical-align:middle;">    
				    </td>
        </tr> 
       </table> 
    </form>
  </div>
  </div>
</div>
</body></html>
