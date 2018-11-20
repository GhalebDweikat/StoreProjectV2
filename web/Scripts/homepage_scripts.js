$(function () {
    $(".addtocart").click(addProductToCart);
    $(".prodsummary").click(ajaxProdDetails);
});
function addProductToCart(e) {
    let id = e.target.id;
    $.get("/cart", {"add":id}).done(alertSuccess);
}
function alertSuccess() {
    alert("Product Successfully Added");
}
function ajaxProdDetails(e) {
    let id = e.target.id.substring(4,e.target.id.length);
    alert(id);
    $.get("/product", {"id":id}).done(displayProduct);
}
function displayProduct(data) {
    $(".prodsummary").remove();
    $(".products").append($("<div>", {"class": "col proddetails"}).html(data));
    $(".products").append($("<button>",
        {"click": function () {
                $.get("/home").done(backToAllProducts);
            },
            "text":"Go Back"
    }));
}

function backToAllProducts(data) {
        $(".container").remove();
        $("body").html(data);
}