function logout() {
    sessionStorage.removeItem(SESSION_STORAGE_LOGIN_TOKEN_NAME);
    window.location.replace(ROOT_PATH + "/logout")
}

function populateDataTableAndUpdate(books) {
    jQuery.each(books, function(i,book) {
        $("#booksUpdate").append("<tr id='bookRow" + book.id + "'><td>" + book.id + "</td><td>" + book.title + "</td><td><input value='Update' type='button' class='register-form-btn' id='ma' onclick='print()'></td></tr>");
     });

}
function populateDataTable(books) {
    jQuery.each(books, function(i,book) {
        $("#books").append("<tr id='bookRow" + book.id + "'><td>" + book.id + "</td><td>" + book.title + "</td></tr>");
     });

}
function print(){
      $("#booksUpdate tr").click(function() {
       let tabler=$(this).children("td").html();
       window.location.href="update.html?bookid="+tabler;
    });
}


function details(){
      $.ajax({
           url: ROOT_PATH + "/books"
       }).then(function(books) {
           populateDataTableAndUpdate(books);
       });
}

function loadBook(id) {
    $.ajax({
        url: ROOT_PATH + "/books/" + id
    }).then(function(book) {
       $("input[name=id]").val(book.id);
       $("input[name=title]").val(book.title);
       $("input[name=isbn]").val(book.isbn);
    });
};

$(document).ready(function() {
   $.ajax({
        url: ROOT_PATH + "/books"
    }).then(function(books) {
        populateDataTable(books);
    });

    $("#saveButton").on('click', function(event){
        event.preventDefault();
        alert("To be done...");
    });

    $("#deleteButton").on('click', function(event){
        event.preventDefault();
        let bookId = $("input[name=id]").val();
        $.ajax({
            url: ROOT_PATH + "/books/" + bookId,
            type : "DELETE",
            dataType : 'json',
            contentType: 'application/json',
                success : function(result) {
                    $("#bookRow" + bookId).remove();
                    $("input[name=id]").val("");
                    $("input[name=title]").val("");
                    $("input[name=isbn]").val("");
                },
                error: function(xhr, resp, text) {
                    console.log(xhr, resp, text);
                    alert("Could not delete book!");
                 }
         })

    });
});
