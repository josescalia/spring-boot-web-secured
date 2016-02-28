<#--Add New Form Component -->
<#macro addNewFormComponent>
    <a href="#" id="btnSave" class="btn btn-info btn-sm"><span class="glyphicon glyphicon-floppy-disk"></span> Save</a>
    <a href="#" id="btnCancel" data-dismiss="modal" class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-step-backward"></span> Cancel</a>
</#macro>

<#--Edit Form Component-->
<#macro editFormComponent>
    <a href="#" id="btnUpdate" class="btn btn-info btn-sm"><span class="glyphicon glyphicon-floppy-disk"></span> Update</a>
    <a href="#" id="btnCancel" class="btn btn-danger btn-sm" onclick="history.back()"><span class="glyphicon glyphicon-step-backward"></span> Back</a>
</#macro>

<#--Search Component-->
<#macro searchComponent>
<div class="row">
    <div class="col-lg-6 col-md-6 col-sm-6">
        <a href="#modalForm" class="tblAddNew btn btn-info btn-sm" data-toggle="modal" data-placement="top">Add New</a>
    </div>
    <div class="col-lg-6 col-md-6 col-sm-6 form-inline text-right">
        <input type="text" class="form-control" id="searchText" name="searchText" style="width:50%" value="${searchText!""}">
        <button type="button" id="btnFind" class="btn btn-warning btn-sm"><span
                class="glyphicon glyphicon-search"></span> Search
        </button>
    </div>
</div>
<p>&nbsp;</p>
</#macro>

<#--Action Button on list-->
<#macro actionBtn id>
<td style="text-align:center;">
    <a href="edit?id=${id}" class="btn btn-info btn-sm"><span class="glyphicon glyphicon-edit"></span> </a>
    <a href="#" class="btn btn-danger btn-sm" onclick="deleteData('${id}')"><span class="glyphicon glyphicon-trash"></span> </a>
</td>
</#macro>

<#macro onTheFlyForm form>
<div class="modal fade" id="modalForm" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true"
     style="overflow-y:auto">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header" style="background-color:rgba(173, 216, 230, 0.17)">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"
                        style="margin:3px">&times;</button>
                <h4 class="text-center">Add New Publisher</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <#include form>
                </form>
            </div>
            <div class="modal-footer">
                <@crudComponent.addNewFormComponent/>
            </div>
        </div>
    </div>
</div>
</#macro>