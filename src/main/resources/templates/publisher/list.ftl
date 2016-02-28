<#import "../layout/main_layout.ftl" as layout>
<#import "../include/crud_component.ftl" as crudComponent>
<@layout.mainLayout>
<div class="container">

    <@crudComponent.searchComponent/>
    <table class="table table-bordered  table-striped table-condensed">
        <thead>
        <tr>
            <th style="width:20%">Id</th>
            <th style="width:80%">Name</th>
        </tr>
        </thead>
        <tbody>
            <#list publisherList as publisher>
            <tr>
                <@crudComponent.actionBtn publisher.id/>
                <td>${publisher.publisherName}</td>
            </tr>
            </#list>
        </tbody>
    </table>
</div>

<@crudComponent.onTheFlyForm "../publisher/_form.ftl" />
</@layout.mainLayout>

<script type="text/javascript">
    $(function () {
        $("#btnSave").click(function () {
            $.post("/service/json/publisher/save", $("#modalForm").find("form").serialize(), function (jsonString) {
                if (jsonString == "Save Succeed") {
                    alert(jsonString);
                    window.location.reload();
                } else {
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