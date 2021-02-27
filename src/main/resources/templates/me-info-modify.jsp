<%@ page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%--TODO 页面待修改为tenplate--%>
<!DOCTYPE HTML>
<html>
<head>
	<title>个人信息</title>
	<base href="/TradingPlatform/" />
	<link th:href="@{css/common.css" rel="stylesheet" type="text/css" />
	<link th:href="@{css/me.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<%@ include file="common/top.jsp"%>
	<%@ include file="common/head-me.jsp"%>

	<div class="info">
		<div class="info-left fl">
			<img class="info-left-img" th:src="@{/upload/userHeadImg/${sessionScope.user.userDetail.headImg}">
		</div>
		<div class="info-right fl">
			<div class="info-right-top">个人资料</div>

			<form action="${pageContext.request.contextPath}/user/userUpdate" enctype="multipart/form-data" method="post">
				<div class="info-right-key">基本信息</div>

				<div class="info-right-value" style="padding-top: 2px;">
					<input name="detailId" value="${sessionScope.user.userDetail.detailId}" hidden>

					<div class="info-right-value-item">
						<div class="info-right-value-item-key fl">头像：</div>
						<div class="info-right-value-item-value fl">
							<input type="file" name="file">
							<input name="headImg" value="${sessionScope.user.userDetail.headImg}" hidden>
						</div>
					</div>
					<div class="info-right-value-item">
						<div class="info-right-value-item-key fl">昵称：</div>
						<div class="info-right-value-item-value fl">
							<input type="text" pattern="^[a-zA-Z0-9_\u4e00-\u9fa5]{4,20}" name="nickname" value="${sessionScope.user.userDetail.nickname}">
						</div>
					</div>
					<div class="info-right-value-item">
						<div class="info-right-value-item-key fl">真实姓名：</div>
						<div class="info-right-value-item-value fl">
							<input type="text" pattern="^[\u4e00-\u9fa5]+(·[\u4e00-\u9fa5]+)*$" name="realName" value="${sessionScope.user.userDetail.realName}">
						</div>
					</div>
					<div class="info-right-value-item">
						<div class="info-right-value-item-key fl">性别：</div>
						<div class="info-right-value-item-value fl">
							<input style="width: 15px; height: 15px;" type="radio" id="sex0" name="sex" value="保密" checked>
							<label for="sex0">保密</label>
							<input style="width: 15px; height: 15px;" type="radio" id="sex1" name="sex" value="男">
							<label for="sex1">男</label>
							<input style="width: 15px; height: 15px;" type="radio" id="sex2" name="sex" value="女">
							<label for="sex2">女</label>
						</div>
					</div>
					<div class="info-right-value-item">
						<div class="info-right-value-item-key fl">生日：</div>
						<div class="info-right-value-item-value fl">
							<input type="date" name="birthday" value="${sessionScope.user.userDetail.birthday}" format="yyyy-MM-dd"/>
						</div>
					</div>
					<div class="info-right-value-item">
						<div class="info-right-value-item-key fl">手机号码：</div>
						<div class="info-right-value-item-value fl">
							<input type="text" name="phone" pattern="^[1]([3-9])[0-9]{9}$" maxlength="11" value="${sessionScope.user.userDetail.phone}">
						</div>
					</div>
					<div class="info-right-value-item">
						<div class="info-right-value-item-key fl">居住地(省)：</div>
						<div class="info-right-value-item-value fl">
							<input type="text" class="input2" name="curAddr.province" value="${sessionScope.user.userDetail.curAddr.province}">
						</div>
					</div>
					<div class="info-right-value-item">
						<div class="info-right-value-item-key fl">市：</div>
						<div class="info-right-value-item-value fl">
							<input type="text" class="input2" name="curAddr.city" value="${sessionScope.user.userDetail.curAddr.city}">
						</div>
					</div>
				</div>

				<%--<div class="info-right-key">收货地址</div>
				<div class="info-right-value">
					<div class="info-right-value-item">
						<div class="info-right-value-item-key fl">省：</div>
						<div class="info-right-value-item-value fl">
						</div>
					</div>
					<div class="info-right-value-item">
						<div class="info-right-value-item-key fl">市：</div>
						<div class="info-right-value-item-value fl">
						</div>
					</div>
					<div class="info-right-value-item">
						<div class="info-right-value-item-key fl">县/区：</div>
						<div class="info-right-value-item-value fl">
						</div>
					</div>
					<div class="info-right-value-item">
						<div class="info-right-value-item-key fl">详细地址：</div>
						<div class="info-right-value-item-value fl">
							&lt;%&ndash;input class="input2"&ndash;%&gt;
						</div>
					</div>
				</div>--%>
				<button class="button button-modify" type="submit">保存</button>
			</form>
		</div>
	</div>

	<%@ include file="common/foot.jsp"%>
</body>
</html>
