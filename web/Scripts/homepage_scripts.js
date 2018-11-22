$(function () {
    $(".addtocart").click(addProductToCart);
    $(".prodsummary").click(ajaxProdDetails);
    $("#viewcartbtn").click(ajaxViewCart);
    $(".removebtn").click(removeProduct);
    $(".checkoutbtn").click(ajaxViewCheckout);
    $(".paybtn").click(payNow);
    $(".logoutbtn").click(logout);
    $("#addProduct").click(addProduct);
    $("#search").autocomplete({ source: "product", minLength: 1});
});
function addProductToCart(e) {
    e.stopImmediatePropagation();
    let id = e.target.id;
    $.get("/cart", {"add":id}).done(alertSuccess);
}
function alertSuccess(data) {
    alert("Product Successfully Added");
    //alert(data);
    $("#cartCount").text(data);
}
function ajaxProdDetails(e) {
    let id = e.target.id.substring(4,e.target.id.length);
    $.get("/product", {"id":id}).done(displayProduct);
}
function displayProduct(data) {
    $(".prodsummary").remove();
    $(".products").append($("<div>", {"class": "col proddetails"}).html(data));
    $(".products").append($("<div>", {"class": "colLast"}).append($("<button>",
        {
            "click": function () {
                $.get("/home").done(backToAllProducts);
            },
            "text": "Go Back",
            "class": "backbtn btn btn-primary"
        })));
}

function backToAllProducts(data) {
        $(".container").remove();
        $("body").html(data);
}
function ajaxViewCart() {
    $.get("/cart").done(viewCart);
}
function viewCart(data) {
    $(".prodsummary,.proddetails,.backbtn").remove();
    $(".products").append($("<div>", {"class": "col proddetails"}).html(data));
    $(".products").append($("<div>", {"class": "colLast"}).append($("<button>",
        {
            "click": function () {
                $.get("/home").done(backToAllProducts);
            },
            "text": "Go Back",
            "class": "backbtn btn btn-primary"
        })));
}
function removeProduct(e) {
    $.get("/cart", {"remove":e.target.id}).done(removeSuccess);
    e.stopImmediatePropagation();
}
function removeSuccess() {
    alert("Product Successfully Removed!");
    ajaxViewCart();
}
function ajaxViewCheckout(e) {
    $.get("/checkout",{"user":e.target.id}).done(displayCheckoutView);
    e.stopImmediatePropagation();
}
function displayCheckoutView(data) {
    $(".proddetails,.backbtn").remove();
    $(".products").append($("<div>", {"class": "col proddetails"}).html(data));
    $(".products").append($("<div>", {"class": "colLast"}).append($("<button>",
        {
            "click": function () {
                $.get("/home").done(backToAllProducts);
            },
            "text": "Go Back",
            "class": "backbtn btn btn-primary"
        })));
}
function payNow(e) {
    alert("You Bought Stuff YAY!");
    $.get("/checkout", {"user":e.target.id,"pay":"yes"}).done(backToAllProducts);
    e.stopImmediatePropagation();
}
function logout(e) {
    //$.get("/logout").done(viewLogin);
    //e.stopImmediatePropagation();
    window.location.replace("/logout");
}
function addProduct(e) {
    window.location.replace("/addproduct");
}
function viewLogin(data) {
    $("body").html(data);
}