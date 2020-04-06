<li class="center">
	<a> <i class="glyphicon glyphicon-time"></i>历史记录
</a>
</li>
<#list userLogList as ulog>
	<#--<#if ulog_index<8>-->
<li class="left">
<a href="javascript:changepath('${(ulog.url)!''}');"><div class="">${(ulog.title)!''}</div>
		<small>${(ulog.logTime)!''}</small></a></li>
	<#--</#if>-->
</#list>
<li>
	<div style="text-align: center; padding: 10px 15px;">
		<a href="javascript:changepath('morelog');">更多记录...</a>
	</div>
</li>