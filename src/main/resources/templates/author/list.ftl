<#import "../layout/main_layout.ftl" as layout>
<@layout.mainLayout>
<div class="container">
    <#include "../include/_add_search_component.ftl">
<table class="table table-bordered table-striped table-condensed">
    <thead>
    <tr>
        <th>Action</th>
        <th>Name</th>
        <th>Address</th>
        <th>Created</th>
    </tr>
    </thead>
    <tbody>
    <#list authorList as author>
        <tr>
            <td style="text-align:center;">
                <a href="edit?id=${author.id}" class="btn btn-info btn-sm"><span class="glyphicon glyphicon-edit"></span> </a>
                <a href="#" class="btn btn-danger btn-sm" onclick="deleteData('${author.id}')"><span class="glyphicon glyphicon-trash"></span> </a>
            </td>
            <td>${author.authorName}</td>
            <td>${author.authorAddress}</td>
            <td><#if author.createdDate??>${author.createdDate?string('dd MMM yyyy HH:mm:ss')}</#if></td>
        </tr>
    </#list>
    </tbody>
</table>
</div>
<#--author form, hidden by default-->
<div class="modal fade" id="modalForm" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true"
     style="overflow-y:auto">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header" style="background-color:rgba(173, 216, 230, 0.17)">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"
                        style="margin:3px">&times;</button>
                <h4 class="text-center">Add New Author</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                <#include "_form.ftl">
                </form>
            </div>
            <div class="modal-footer">
                <#include "../include/_add_new_component.ftl">
            </div>
        </div>
    </div>
</div>
</@layout.mainLayout>

<script type="text/javascript">
    $(function(){
        $("#btnSave").click(function(){
            $.post("/service/json/author/save", $("#modalForm").find("form").serialize(), function(jsonString){
                if(jsonString == "Save Succeed"){
                    alert(jsonString);
                    window.location.reload();
                }else{
                    alert(jsonString);
                }
            })
        });

        $("#btnFind").click(function(){
            window.location = "list?" + "searchText="+$("#searchText").val();
        });
    });

    function deleteData(id){
        if(confirm("Apakah anda yakin untuk menghapus data ini ?")){
            $.post("delete", "id=" + id, function(textMessage){
                if(textMessage == "Delete Succeed"){
                    alert(textMessage);
                    window.location.reload(true);
                }
            })
        }
    }
</script>