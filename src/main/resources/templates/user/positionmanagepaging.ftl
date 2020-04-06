<!--id="container"-->
            <div class="bgc-w box box-primary">
                <!--盒子头-->
                <div class="box-header">
                    <h3 class="box-title">
                        <a href="positionedit" class="label label-success" style="padding: 5px;">
                            <span class="glyphicon glyphicon-plus"></span> 新增
                        </a>
                    </h3>
                    <div class="box-tools">
                        <div class="input-group" style="width: 150px;">
                            <input type="text"  class="form-control input-sm search"
                                   placeholder="查找..." />
                            <div class="input-group-btn">
                                <a class="btn btn-sm btn-default"><span
                                        class="glyphicon glyphicon-search searchgo"></span></a>
                            </div>
                        </div>
                    </div>
                </div>
                <!--盒子身体-->
                <div class="box-body no-padding">
                    <div class="table-responsive">
                        <table class="table table-hover table-striped">
                            <tr>

                                <th scope="col">名称</th>
                                <th scope="col">层级</th>
                                <th scope="col">描述</th>
                                <th scope="col">操作</th>
                            </tr>
						<#list positions as position>
							<tr>
                                <td><span>${position.name}</span></td>
                                <td><span>${(position.level)!''}</span></td>
                                <td><span>${(position.describtion)!''}</span></td>
                                <td><a  href="positionedit?positionid=${position.id}" class="label xiugai"><span
                                        class="glyphicon glyphicon-edit"></span> 修改</a><a
                                        onclick="{return confirm('删除该记录将不能恢复，确定删除吗？');};"
                                        href="removeposition?positionid=${position.id}" class="label shanchu"><span
                                        class="glyphicon glyphicon-remove"></span> 删除</a></td>
                            </tr>
						</#list>
                        </table>
                    </div>
                </div>
                <!--盒子尾-->
	<#include "/common/paging.ftl"/>
            </div>
