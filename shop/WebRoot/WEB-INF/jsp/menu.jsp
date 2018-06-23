<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="span10 last">
	<div class="topNav clearfix">
		<ul>
			<s:if test="#session.existUser == null">
			<li id="headerLogin" class="headerLogin" style="display: list-item;">
				<a href="${ pageContext.request.contextPath }/user_loginPage.action">登录</a>|</li>
			<li id="headerRegister" class="headerRegister"
				style="display: list-item;"><a href="${ pageContext.request.contextPath }/user_registPage.action">注册</a>|
			</li>
			</s:if>
			<s:else>
			<li id="headerLogin" class="headerLogin" style="display: list-item;">
				<s:property value="#session.existUser.name"/>
				|</li>
			<li id="headerLogin" class="headerLogin" style="display: list-item;">
				<a href="${ pageContext.request.contextPath }/order_findByUid.action?page=1">我的订单</a>
			|</li>
			<li id="headerRegister" class="headerRegister"
				style="display: list-item;"><a href="${ pageContext.request.contextPath }/user_quit.action">退出</a>|
			</li>
			</s:else>
		
			<li><a>会员中心</a> |</li>
			<li><a>购物指南</a> |</li>
			<li><a>关于我们</a></li>
		</ul>
	</div>
	<div class="cart">
		<a href="${ pageContext.request.contextPath }/cart_myCart.action">购物车</a>
	</div>
	<div class="mall-search">
	<form action="product_findByCsname.action"> 
    <input type="text" style="width:160px;height:25px; " class="input w50" name="csname" size="50px" placeholder="请输入图书类别"/>
    <button type="submit" class="button border-yellow" style="width:43px;height:27px;color:blue ;" ><span class="icon-plus-square-o"></span> 搜索</button>  
    </form>	
	</div>
</div>
<div class="span24">
	<ul class="mainNav">
		<li><a href="${ pageContext.request.contextPath }/index.action">首页</a> |</li>
		<s:iterator var="c" value="#session.cList">
			<li><a href="${ pageContext.request.contextPath }/product_findByCid.action?cid=<s:property value="#c.cid"/>&page=1"><s:property value="#c.cname"/></a> |</li>
		</s:iterator>

	</ul>
</div>