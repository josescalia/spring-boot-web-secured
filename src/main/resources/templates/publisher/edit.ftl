<#import "../layout/main_layout.ftl" as layout>
<#import "../include/crud_component.ftl" as crudComponent>
<@layout.secondLayout>
<div class="col-lg-6 col-md-6 col-sm-12">
    <form method="post" id="editForm">
        <div class="panel panel-info">
            <div class="panel-heading">
                <h4>Edit Publisher</h4>
            </div>
            <div class="panel-body">
                <#include "_form.ftl">
                <input type="hidden" id="id" name="id" value="${model.id}">
            </div>
            <div class="panel-footer text-right">
                <@crudComponent.editFormComponent/>
            </div>
        </div>

    </form>
</div>
</@layout.secondLayout>
<script type="text/javascript">
    $(function(){
        $("#btnUpdate").click(function(){
            $.post("/service/json/publisher/save", $("#editForm").serialize(), function(responseText){
                alert(responseText);
                if(responseText == "Save Succeed"){
                    window.location = "list"
                }
            });
        });

        $("#btnCancel").click(function(event){
            event.preventDefault();
            history.back(1);
        })
    })
</script>