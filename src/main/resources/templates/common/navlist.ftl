<div class="col-md-12 green" >
	<!--导航栏左侧按钮，-->
	<ul class="nav navbar-nav navbar-left" style="margin-left: -15px;">
		<li><a href="#" class="green-none white"><span
				class="glyphicon glyphicon-menu-hamburger"></span></a></li>
	</ul>
    <#--<label class="label label-danger">亲，上班记得签到~,签到时间为上午八点到下午十七点</label>-->
    <!--右侧导航栏-->
	<ul class="nav navbar-nav navbar-right moredeep">
        <li><a class="green-none white">
            <span class="glyphicon glyphicon-hand-down"></span>
			<span>亲，上班记得打卡~,上班打卡时间为07:00:00到08:00:00，下班打卡时间为18:00:00到18:30:00，别错过了时间哦</span>
        </a>
        </li>
        <li><a href="javascript:changepath('/infromlist');" class="green-none white"><span
				class="glyphicon glyphicon-bell"></span>
				<#if notice==0>
					<span class="badge blue-badge badge-notice"></span>
				<#else>
					<span class="badge blue-badge badge-notice">${(notice)!''}</span>
				</#if>
		</a>
		</li>
        <#--<li><a href="javascript:changepath('/mail');" class="green-none white"><span-->
				<#--class="glyphicon glyphicon-envelope"></span>-->
				<#--<#if mail==0>-->
					<#--<span class="badge yellow-badge badge-mail"></span>-->
				<#--<#else>-->
					<#--<span class="badge yellow-badge badge-mail">${(mail)!''}</span>-->
				<#--</#if>-->
				<#--</a>-->
		<#--</li>-->
		<li><a href="javascript:changepath('/mytask');" class="green-none white"><span
				class="glyphicon glyphicon-flag"></span>
				<#if task==0>
					<span class="badge red-badge"></span>
				<#else>
					<span class="badge red-badge">${(task)!''}</span>
				</#if>
				</a>
		</li>
		<li class="dropdown">
		<!--设置导航栏头像面板--> 
		<a href="#" class="green-none white" data-toggle="dropdown">
				<img src="/image/${(user.imgPath)!'/timg.jpg'}" class="user-image" /> <span>${user.userName}</span>
		</a> <!--设置点击按钮弹出用户面板层-->
			<ul class="dropdown-menu" style="padding:0;">
				<li class="user-header green"><img src="/image/${(user.imgPath)!'/timg.jpg'}"
					class="img-circle" style="width: 100px;height:100px;" />
					<p class="white" style="">
						<span>${user.dept.deptName} </span> / <span> ${user.role.roleName}</span><br> <small>${user.position.name}</small>
					</p></li>
				<li class="user-footer">
					<div class="pull-left">
						<a href="javascript:changepath('userpanel');" class="btn btn-default">用户面板</a>
					</div>
					<div class="pull-right">
						<a href="loginout" class="btn btn-danger">退出登录</a>
					</div>
				</li>
			</ul>
		</li>

		<li style="position: relative;"><a  id="history" class="green-none white" data-toggle="dropdown"><span
				class="glyphicon glyphicon-time"></span></a>
				
		<ul id="historypanel" class="dropdown-menu"
				style="position: absolute; background-color: #222d32;">
				<#include "/user/userlog.ftl"/>
		</ul>
	</li>
</ul>
</div>
<script>
	function changeemail(){
		var email=$('.badge-mail').text().trim();
		var emailNum=parseInt(email);
		if(emailNum>1){
			$('.badge-mail').text((emailNum-1));
		}else{
			$('.badge-mail').text("");
		}
	}
	function changeinformation(){
		var email=$('.badge-notice').text().trim();
		var emailNum=parseInt(email);
		if(emailNum>1){
			$('.badge-notice').text((emailNum-1));
		}else{
			$('.badge-notice').text("");
		}
	}
	//从右往左滑动效果
	$(function() {
		var num = 1;
		$("#history").click(function() {
			num++;
			if (num % 2 == 0) {
				$("#historypanel").css({ //从右边飞入，使用绝对定位来操作 
					"width" : "230px",
					"right" : "-230px"
				}).show().animate({
					"right" : "0"
				}, "fast");
			} else
				$("#historypanel").animate({
					"width" : "toggle"
				}, "slow");
			$('#historypanel').load('/userlogs');

		})
	})
</script>