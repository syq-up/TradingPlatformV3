<%@ page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%--TODO 页面待修改为tenplate--%>
<!DOCTYPE HTML>
<html>
<head>
	<title>个人信息</title>
	<base href="/TradingPlatform/" />
	<link href="css/common.css" rel="stylesheet" type="text/css" />
	<link href="css/me.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<%@ include file="common/top.jsp"%>
	<%@ include file="common/head-me.jsp"%>

	<div class="info fl" style="margin: 0 433px">
		<div class="info-left fl">
			<img class="info-left-img" src="upload/userHeadImg/${sessionScope.user.userDetail.headImg}">
		</div>
		<div class="info-right fl">
			<div class="info-right-top">个人资料</div>

			<div class="info-right-key">基本信息</div>
			<div class="info-right-value">
				<div class="info-right-value-item">
					<div class="info-right-value-item-key fl">昵称：</div>
					<div class="info-right-value-item-value fl">${sessionScope.user.userDetail.nickname}</div>
				</div>
				<div class="info-right-value-item">
					<div class="info-right-value-item-key fl">真实姓名：</div>
					<div class="info-right-value-item-value fl">${sessionScope.user.userDetail.realName}</div>
				</div>
				<div class="info-right-value-item">
					<div class="info-right-value-item-key fl">性别：</div>
					<div class="info-right-value-item-value fl">${sessionScope.user.userDetail.sex}</div>
				</div>
				<div class="info-right-value-item">
					<div class="info-right-value-item-key fl">生日：</div>
					<div class="info-right-value-item-value fl">${sessionScope.user.userDetail.birthday}</div>
				</div>
				<div class="info-right-value-item">
					<div class="info-right-value-item-key fl">手机：</div>
					<div class="info-right-value-item-value fl">${sessionScope.user.userDetail.phone}</div>
				</div>
				<div class="info-right-value-item">
					<div class="info-right-value-item-key fl">居住地：</div>
					<div class="info-right-value-item-value fl">
						${sessionScope.user.userDetail.curAddr.province}
						${sessionScope.user.userDetail.curAddr.city}
					</div>
				</div>
			</div>
			<a href="/TradingPlatform/user/userModify">
				<button class="button button-modify" style="margin-bottom: 15px">修改</button>
			</a>

			<div class="info-right-key">收货地址</div>
			<div class="info-right-value">
				<div class="info-right-value-item">
					<div class="info-right-value-item-key fl">省：</div>
					<div class="info-right-value-item-value fl"></div>
				</div>
				<div class="info-right-value-item">
					<div class="info-right-value-item-key fl">市：</div>
					<div class="info-right-value-item-value fl"></div>
				</div>
				<div class="info-right-value-item">
					<div class="info-right-value-item-key fl">县/区：</div>
					<div class="info-right-value-item-value fl"></div>
				</div>
				<div class="info-right-value-item">
					<div class="info-right-value-item-key fl">详细地址：</div>
					<div class="info-right-value-item-value fl"></div>
				</div>
			</div>
			<div class="info-right-value">
			</div>
			<div class="info-right-value">
			</div>
		</div>
	</div>

	<%@ include file="common/foot.jsp"%>
</body>
</html>
