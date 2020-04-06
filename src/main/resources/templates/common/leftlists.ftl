
		<div class="panel-group" id="accordion"
			style="margin-top: 10px; margin-left: -12px;">

			<div class="panel panel-default">
				<#list oneMenuAll as one>
				<div class="panel-heading">
					<a class="open-menu green-left" href="#collapse${one.menuId}" data-toggle="collapse"
						data-parent="#accordion"> <span
						class="glyphicon ${one.menuIcon}"></span> <span>${one.menuName}</span> <span
						class="glyphicon glyphicon-menu-left pull-right"></span>
					</a>
				</div>
				<div id="collapse${one.menuId}" class="panel-collapse collapse ">
					<ul>
					<#list twoMenuAll as two>
					<#if one.menuId==two.parentId>
						<#if two.menuUrl??>
						<li>
							<a href="javascript:changepath('${two.menuUrl}');"> <span
									class="glyphicon ${two.menuIcon}"></span> <span>${two.menuName}</span>
							</a>
						</li>
						
						<#else>
							<li>
								<a href="#"> <span
										class="glyphicon ${two.menuIcon}"></span> <span>${two.menuName}</span>
								</a>
							</li>
						</#if>
				</#if>
				</#list>
				</ul>
				</div>
				</#list>
			</div>
		</div>
<script>
	$(function(){
		$(".chazhao").click(function(){
			var $val=$(".cha").val();
			$(".thistable").load("menucha",{val:$val});
		});
	})
</script>