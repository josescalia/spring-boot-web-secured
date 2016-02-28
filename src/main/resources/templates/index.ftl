<#import "layout/main_layout.ftl" as layout>
<@layout.mainLayout>
<div class="container">
    <h3>Welcome</h3>
    <p>Date : ${model?date}</p>
    <div class="col-lg-6 col-md-6 col-sm-12">
        <table class="table table-bordered table-striped table-condensed">
            <tr>
                <td>Model Normal</td>
                <td class="text-info">${modelName}</td>
            </tr>
            <tr>
                <td>Huruf Depan Kapital</td>
                <td class="text-info">${modelName?capitalize}</td>
            </tr>
            <tr>
                <td>Lower Case</td>
                <td class="text-info">${modelName?lower_case}</td>
            </tr>
            <tr>
                <td>Upper Case</td>
                <td class="text-info">${modelName?upper_case}</td>
            </tr>
            <tr>
                <td>Jumlah Char</td>
                <td class="text-info">${modelName?length}</td>
            </tr>
            <tr>
                <td>3 huruf pertama</td>
                <td class="text-info">${modelName?substring(0,3)}</td>
            </tr>
            <tr>
                <td>3 huruf pertama dengan upper case</td>
                <td class="text-info">${modelName?substring(0,3)?upper_case}</td>
            </tr>
        </table>
    </div>
</div>
</@layout.mainLayout>