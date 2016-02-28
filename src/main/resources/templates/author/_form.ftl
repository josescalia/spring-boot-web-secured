<div class="form-group">
    <label for="authorName" class="col-lg-4 col-md-6 col-sm-12">Author Name</label>
    <div class="col-lg-8 col-md-6 col-sm-12">
        <input type="text" class="form-control" id="authorName" name="authorName" value="${model.authorName!""}">
    </div>
</div>
<div class="form-group">
    <label for="authorAddress" class="col-lg-4 col-md-6 col-sm-12">Address</label>
    <div class="col-lg-8 col-md-6 col-sm-12">
       <textarea id="authorAddress" name="authorAddress" class="form-control">${model.authorAddress!""}</textarea>
    </div>
</div>