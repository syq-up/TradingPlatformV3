<%@ page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%--TODO 页面待修改为tenplate--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>我的商品</title>
	<base href="/TradingPlatform/" />
	<link href="css/common.css" rel="stylesheet" type="text/css" />
	<link href="css/me.css" rel="stylesheet" type="text/css" />
</head>

<body>
<%@ include file="common/top.jsp"%>
<%@ include file="common/head-me.jsp"%>

<div class="content">
	<div class="content-top">
		我的商品：
	</div>

	<div class="content-head">
		<div class="content-head-item1 fl">商品</div>
		<div class="content-head-item2 fr">操作</div>
		<div class="content-head-item2 fr">商品状态</div>
		<div class="content-head-item2 fr">价格</div>
	</div>

	<c:if test="${goodsList == null}">
		什么都没有呢X﹏X
	</c:if>
	<c:forEach var="goodsItem" items="${goodsList}">
		<div class="content-item">
			<div class="content-item-body">
				<div class="content-item-body-item1 fl">
					<div class="content-item-body-item1-img fl" style="overflow: hidden;">
						<a href="/TradingPlatform/goods/single/${goodsItem.goodsId}"><img width="80" src="upload/goodsImg/${goodsItem.goodsImg}/1.jpg"></a>
					</div>
					<div class="content-item-body-item1-goodsname fl">
						<a href="/TradingPlatform/goods/single/${goodsItem.goodsId}">${goodsItem.goodsName}</a>
					</div>
					<div class="content-item-body-item1-mastername fl">
						<a href="#">${sessionScope.user.userId}</a>
					</div>
				</div>
				<div class="content-item-body-item2 fr">
					<a href="/TradingPlatform/goods/single/${goodsItem.goodsId}"><img width="26" src="images/edit.png"></a>
					<a href="/TradingPlatform/goods/single/${goodsItem.goodsId}"><img width="26" src="images/delete.png"></a>
				</div>
				<div class="content-item-body-item2 fr">
					<c:choose>
						<c:when test="${goodsItem.state == 1}">未售出</c:when>
						<c:otherwise>卖掉了！</c:otherwise>
					</c:choose>
				</div>
				<div class="content-item-body-item2 fr">
					￥${goodsItem.newPrice}<br/>
					<del>${goodsItem.oldPrice}</del>
				</div>
			</div>
		</div>
	</c:forEach>

	<%--页码--%>
	<div class="page">
		<c:if test="${totalPages>=1}">
			<%-- 页数较少时填充 --%>
			<c:if test="${totalPages < 8}">
				<c:forEach begin="1" end="${(9-totalPages)/2}">
					<div class="page-item fl bg-color-fff"></div>
				</c:forEach>
			</c:if>
			<%-- 上一页 --%>
			<div class="page-item fl bg-color-fff">
				<a href="/TradingPlatform/goods/me-goods/${pageNum-1}"><img alt="上一页" src="images/prevPage.png"></a>
			</div>
			<%-- 首页 --%>
			<div class="page-item fl <c:if test="${pageNum==1}">bg-color-ffd84d</c:if>" style="background-color: #f2f2f2">
				<a href="/TradingPlatform/goods/me-goods/1">1</a>
			</div>
			<%-- 页数过多时的省略号 --%>
			<c:if test="${totalPages > 9 && pageNum > 5}">
				<div class="page-item fl <c:if test="${pageNum == totalPages}">bg-color-ffd84d</c:if>" style="background-color: #f2f2f2">
					<img alt="省略" src="images/ellipsis.png"/>
				</div>
			</c:if>
			<%-- 中间部分的页面显示 --%>
			<c:choose>
				<c:when test="${totalPages<=9}">
					<c:forEach var="pagesNum" begin="2" end="${totalPages-1}">
						<div class="page-item fl <c:if test="${pagesNum==pageNum}">bg-color-ffd84d</c:if>" style="background-color: #f2f2f2">
							<a href="/TradingPlatform/goods/me-goods/${pagesNum}">${pagesNum}</a>
						</div>
					</c:forEach>
				</c:when>
				<c:when test="${totalPages > 9}">
					<c:choose>
						<c:when test="${pageNum <= 5}">
							<c:forEach var="pagesNum" begin="2" end="7">
								<div class="page-item fl <c:if test="${pagesNum==pageNum}">bg-color-ffd84d</c:if>" style="background-color: #f2f2f2">
									<a href="/TradingPlatform/goods/me-goods/${pagesNum}">${pagesNum}</a>
								</div>
							</c:forEach>
						</c:when>
						<c:when test="${pageNum >= (totalPages-4)}">
							<c:forEach var="pagesNum" begin="${totalPages-6}" end="${totalPages-1}">
								<div class="page-item fl <c:if test="${pagesNum==pageNum}">bg-color-ffd84d</c:if>" style="background-color: #f2f2f2">
									<a href="/TradingPlatform/goods/me-goods/${pagesNum}">${pagesNum}</a>
								</div>
							</c:forEach>
						</c:when>
						<c:when test="${pageNum>5 && pageNum < (totalPages-4)}">
							<c:forEach var="pagesNum" begin="${totalPages-6}" end="${totalPages-1}">
								<div class="page-item fl <c:if test="${pagesNum==pageNum}">bg-color-ffd84d</c:if>" style="background-color: #f2f2f2">
									<a href="/TradingPlatform/goods/me-goods/${pagesNum}">${pagesNum}</a>
								</div>
							</c:forEach>
						</c:when>
					</c:choose>
				</c:when>
			</c:choose>
			<%-- 页数过多时的省略号 --%>
			<c:if test="${totalPages > 9 && pageNum < (totalPages-4)}">
				<div class="page-item fl <c:if test="${pageNum == totalPages}">bg-color-ffd84d</c:if>" style="background-color: #f2f2f2">
					<img alt="省略" src="images/ellipsis.png"/>
				</div>
			</c:if>
			<%-- 尾页 --%>
			<c:if test="${totalPages > 1}">
				<div class="page-item fl <c:if test="${pageNum == totalPages}">bg-color-ffd84d</c:if>" style="background-color: #f2f2f2">
					<a href="/TradingPlatform/goods/me-goods/${totalPages}">${totalPages}</a>
				</div>
			</c:if>
			<%-- 下一页 --%>
			<div class="page-item fl bg-color-fff">
				<a href="/TradingPlatform/goods/me-goods/${pageNum+1}"><img alt="下一页" src="images/nextPage.png"/></a>
			</div>
			<%-- 页数较少时填充 --%>
			<c:if test="${totalPages < 9}">
				<c:forEach begin="1" end="${(9-totalPages)/2}">
					<div class="page-item fl bg-color-fff"></div>
				</c:forEach>
			</c:if>
		</c:if>
	</div>

</div>

<%@ include file="common/foot.jsp"%>
</body>
</html>
