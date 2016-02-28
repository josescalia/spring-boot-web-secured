<#import "../layout/main_layout.ftl" as layout>
<@layout.mainLayout>
<div class="col-lg-6 col-md-6 col-sm-12">
    <form method="post" id="editForm" class="form-horizontal">
        <div class="panel panel-info">
            <div class="panel-heading">
                <h4>Edit Author</h4>
            </div>

            <div class="panel-body">
                <input type="hidden" id="id" name="id" value="${model.id}">
                    <#include "_form.ftl">

            </div>
            <div class="panel-footer text-right">
                <#include "../include/_edit_component.ftl">
            </div>
            </form>
        </div>
</div>
</@layout.mainLayout>
<script type="text/javascript">
    $(function(){
        $("#btnUpdate").click(function(){
            $.post("/service/json/author/save", $("#editForm").serialize(), function(responseText){
                alert(responseText);
                if(responseText == "Save Succeed"){
                    window.location = "list"
                }
            });
        });
    })
</script>