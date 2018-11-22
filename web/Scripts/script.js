$(function () {
    $("#indexpagebtn").click(gotoLoginPage);
    $("#signup").click(signup);
});
function gotoLoginPage() {

}
function signup(){
    window.location.replace("/signup");
}