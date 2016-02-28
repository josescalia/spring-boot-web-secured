<#import "../layout/main_layout.ftl" as layout>
<#import "../include/crud_component.ftl" as crudComponent>
<@layout.mainLayout>
<div class="container">
    <@crudComponent.searchComponent/>
    <table class="table table-bordered table-striped table-condensed">
        <thead>
        <tr>
            <th>Id</th>
            <th>Title</th>
            <th>Author</th>
            <th>Publisher</th>
        </tr>
        </thead>
        <tbody>
            <#list bookList as book>
            <tr>
                <@crudComponent.actionBtn book.id/>
                <td>${book.bookTitle}</td>
                <td>${book.author.authorName}</td>
                <td>${book.publisher.publisherName}</td>
            </tr>
            </#list>
        </tbody>
    </table>
</div>
<@crudComponent.onTheFlyForm "../book/_form.ftl"/>
</@layout.mainLayout>