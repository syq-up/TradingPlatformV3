<%@ page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%--TODO 页面待修改为tenplate--%>
<!DOCTYPE HTML>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
	<title>二手交易平台</title>
	<base href="/TradingPlatform/" />
	<link th:href="@css/common.css" rel="stylesheet" type="text/css" />
	<link th:href="css/show-single.css" rel="stylesheet" type="text/css" />
	<link th:href="css/me.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<%@ include file="common/top.jsp"%>

	<div class="head-show-single">
		<div class="head-show-single-body">
			<div class="head-show-single-left fl">
				<span class="left">二手交易平台</span>
			</div>
			<div class="head-show-single-right fl">
				<div class="head-show-single-right-item fl">
					<a href="/TradingPlatform/all/goods/recent/1"><span class="right">首页</span></a>
				</div>
				<div class="head-show-single-right-jianGe fl">
					<span class="right">|</span>
				</div>
				<div class="head-show-single-right-item fl">
					<a href="/TradingPlatform/me-goods/1"><span class="right">我的商品</span></a>
				</div>
				<div class="head-show-single-right-item fl">
					<a href="/TradingPlatform/goods/add"><span class="right">发布商品</span></a>
				</div>
			</div>
			<div class="search fr" style="margin: 27px 0;">
				<form action="" method="post">
					<input class="search-input fl" name="goodsName">
					<input type="submit" value="搜索" class="search-button fr">
				</form>
			</div>
		</div>
	</div>

	<div class="info">
		<div class="info-left fl">
			<img class="info-left-img" src="upload/userHeadImg/${sessionScope.user.userDetail.headImg}">
		</div>
		<div class="info-right fl">
			<div class="info-right-top">发布商品</div>

			<form action="${pageContext.request.contextPath}/goods/save" enctype="multipart/form-data" method="post" >
				<div class="info-right-key">编辑商品信息</div>

				<div class="info-right-value" style="padding-top: 2px;height: 450px;">
					<c:if test="${goods!=null}">
						<input name="goodsId" value="${goods.goodsId}" hidden>
					</c:if>

					<input name="userDetail.detailId" value="${sessionScope.user.userDetail.detailId}" hidden>
					<input name="userDetail.nickname" value="${sessionScope.user.userDetail.nickname}" hidden>
					<input name="userDetail.phone" value="${sessionScope.user.userDetail.phone}" hidden>
					<input name="userDetail.headImg" value="${sessionScope.user.userDetail.headImg}" hidden>
					<input name="userDetail.curAddr.province" value="${sessionScope.user.userDetail.curAddr.province}" hidden>
					<input name="userDetail.curAddr.city" value="${sessionScope.user.userDetail.curAddr.city}" hidden>

					<div class="info-right-value-item">
						<div class="info-right-value-item-key fl">图片：</div>
						<div class="info-right-value-item-value fl">
							<input type="file" name="files" accept="image/png, image/jpeg, image/gif" multiple required>
							<input name="goodsImg" value="${goods.goodsImg}" hidden>
						</div>
					</div>
					<div class="info-right-value-item">
						<div class="info-right-value-item-key fl">商品名称：</div>
						<div class="info-right-value-item-value fl">
							<input type="text" style="width: 474px;" name="goodsName" value="${goods.goodsName}" maxlength="35" required>
						</div>
					</div>
					<div class="info-right-value-item">
						<div class="info-right-value-item-key fl">转卖价：</div>
						<div class="info-right-value-item-value fl">
							￥<input type="text" name="newPrice" value="${goods.newPrice}" pattern="^[0-9]+([.]{1}[0-9]+){0,1}$" maxlength="13" required>
						</div>
					</div>
					<div class="info-right-value-item">
						<div class="info-right-value-item-key fl">原价：</div>
						<div class="info-right-value-item-value fl">
							￥<input type="text" name="oldPrice" value="<c:if test="${goods!=null}">${goods.oldPrice}</c:if>" pattern="^[0-9]+([.]{1}[0-9]+){0,1}$" maxlength="13">
						</div>
					</div>
					<div class="info-right-value-item">
						<div class="info-right-value-item-key fl">成色：</div>
						<div class="info-right-value-item-value fl">
							<input type="text" style="width: 474px;" name="quality" value="${goods.quality}" maxlength="22">
						</div>
					</div>
					<div class="info-right-value-item">
						<div class="info-right-value-item-key fl">交易方式：</div>
						<div class="info-right-value-item-value fl">
							<input style="width: 30px; height: 15px;" type="radio" name="tradeWay" value="在线交易" checked>在线交易
							<input style="width: 30px; height: 15px;" type="radio" name="tradeWay" value="线下交易">线下交易
						</div>
					</div>
					<div class="info-right-value-item">
						<div class="info-right-value-item-key fl">分类：</div>
						<div class="info-right-value-item-value fl">
							<select style="width: 110px; height: 30px;" name="sort">
								<option value="phone">1手机</option>
								<option value="digital">2数码</option>
								<option value="anime">3ACG</option>
								<option value="clothes">4服装</option>
								<option value="house">5租房</option>
								<option value="cosmetics">6美妆</option>
								<option value="sport">7运动</option>
								<option value="game">8游戏</option>
								<option value="instrument">9乐器</option>
								<option value="other">0其它</option>
							</select>
							要选对哦(⊙o⊙)！
						</div>
					</div>
					<div class="info-right-value-item">
						<div class="info-right-value-item-key fl">详情：</div>
						<div class="info-right-value-item-value fl">
							<textarea rows="10" cols="65" name="goodsDetail" value="${goods.goodsDetail}"></textarea>
							<span style="line-height: 12px;"><br/>*请注意信息格式</span>
						</div>
					</div>
					<input name="state" value="1" hidden>
				</div>

				<input type="submit" class="button button-modify" value="确定">
			</form>
		</div>
	</div>

	<%@ include file="common/foot.jsp"%>
</body>
</html>
