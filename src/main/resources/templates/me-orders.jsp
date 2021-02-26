<%@ page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%--TODO 页面待修改为tenplate--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>我的订单</title>
	<base href="/TradingPlatform/" />
	<link href="css/common.css" rel="stylesheet" type="text/css" />
	<link href="css/me.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<%@ include file="common/top.jsp"%>
	<%@ include file="common/head-me.jsp"%>

	<div class="content">
		<div class="content-top">
			我的订单：
		</div>

		<div class="content-head">
			<div class="content-head-item1 fl">商品</div>
			<div class="content-head-item2 fl">商品操作</div>
			<div class="content-head-item2 fl">价格</div>
			<div class="content-head-item2 fl">交易状态</div>
			<div class="content-head-item2 fl">交易操作</div>
		</div>

		<c:if test="${userOrderList == null}">
			什么都没有呢X﹏X
		</c:if>
		<c:forEach var="orderItem" items="${userOrderList}">
			<div class="content-item">
				<div class="content-item-head">
					<div class="content-item-head-item fl">
						${orderItem.datetime}订单编号：${orderItem.orderId}
					</div>
					<div class="content-item-head-item fl">
						${orderItem.goods.goodsName}
					</div>
					<div class="content-item-head-delete fl">
						<a href="/TradingPlatform/goods/me-order/delete/${orderItem.orderId}/${pageNum}">
							<img width="18px" src="images/delete.png">
						</a>
					</div>
				</div>
				<div class="content-item-body">
					<div class="content-item-body-item1 fl">
						<div class="content-item-body-item1-img fl" style="overflow: hidden;">
							<a href="/TradingPlatform/goods/single/${orderItem.goods.goodsId}">
								<img width="80" src="upload/goodsImg/${orderItem.goods.goodsImg}/1.jpg">
							</a>
						</div>
						<div class="content-item-body-item1-goodsname fl">
							<a href="/TradingPlatform/goods/single/${orderItem.goods.goodsId}">${orderItem.goods.goodsName}</a>
						</div>
					</div>
					<div class="content-item-body-item2 fl">
						<p>
							<a href="#">联系卖家</a>
						</p>
						<p>
							<a href="#">申请客服</a>
						</p>
					</div>
					<div class="content-item-body-item2 fl">
						￥${orderItem.goods.newPrice}
					</div>
					<div class="content-item-body-item2 fl">
						交易成功
					</div>
					<div class="content-item-body-item2 fl">
						<a href="#">
							评论
						</a>
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
					<a href="/TradingPlatform/goods/me-order/${pageNum-1}"><img alt="上一页" src="images/prevPage.png"></a>
				</div>
				<%-- 首页 --%>
				<div class="page-item fl <c:if test="${pageNum==1}">bg-color-ffd84d</c:if>" style="background-color: #f2f2f2">
					<a href="/TradingPlatform/goods/me-order/1">1</a>
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
								<a href="/TradingPlatform/goods/me-order/${pagesNum}">${pagesNum}</a>
							</div>
						</c:forEach>
					</c:when>
					<c:when test="${totalPages > 9}">
						<c:choose>
							<c:when test="${pageNum <= 5}">
								<c:forEach var="pagesNum" begin="2" end="7">
									<div class="page-item fl <c:if test="${pagesNum==pageNum}">bg-color-ffd84d</c:if>" style="background-color: #f2f2f2">
										<a href="/TradingPlatform/goods/me-order/${pagesNum}">${pagesNum}</a>
									</div>
								</c:forEach>
							</c:when>
							<c:when test="${pageNum >= (totalPages-4)}">
								<c:forEach var="pagesNum" begin="${totalPages-6}" end="${totalPages-1}">
									<div class="page-item fl <c:if test="${pagesNum==pageNum}">bg-color-ffd84d</c:if>" style="background-color: #f2f2f2">
										<a href="/TradingPlatform/goods/me-order/${pagesNum}">${pagesNum}</a>
									</div>
								</c:forEach>
							</c:when>
							<c:when test="${pageNum>5 && pageNum < (totalPages-4)}">
								<c:forEach var="pagesNum" begin="${totalPages-6}" end="${totalPages-1}">
									<div class="page-item fl <c:if test="${pagesNum==pageNum}">bg-color-ffd84d</c:if>" style="background-color: #f2f2f2">
										<a href="/TradingPlatform/goods/me-order/${pagesNum}">${pagesNum}</a>
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
						<a href="/TradingPlatform/goods/me-order/${totalPages}">${totalPages}</a>
					</div>
				</c:if>
				<%-- 下一页 --%>
				<div class="page-item fl bg-color-fff">
					<a href="/TradingPlatform/goods/me-order/${pageNum+1}"><img alt="下一页" src="images/nextPage.png"/></a>
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
