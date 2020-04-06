<#include "/common/commoncss.ftl">
<#include "/common/modalTip.ftl"/>
<style type="text/css">
    a {
        color: black;
    }

    a:hover {
        text-decoration: none;
    }

    .bgc-w {
        background-color: #fff;
    }
</style>

	<div class="row" style="padding-top: 10px;">
        <div class="col-md-2">
            <h1 style="font-size: 24px; margin: 0;" class="">职位管理</h1>
        </div>
        <div class="col-md-10 text-right">
            <a href="/index" target="_parent"><span class="glyphicon glyphicon-home"></span> 首页</a> >
            <a disabled="disabled">职位管理</a>
        </div>
    </div>

	<div class="row" style="padding-top: 15px;">
        <div class="col-md-12 thistable">

            <#include "/user/positionmanagepaging.ftl"  />

        </div>
    </div>
<script type="text/javascript">
    $(".thistable").on("click",".searchgo",function(){
        var search = $(".thistable .search").val();
        console.log(search);
        $(".thistable").load("positionmanagepaging",{search:search});
    });
</script>
