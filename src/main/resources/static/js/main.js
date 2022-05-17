// alert("hello")
// $(document).ready(function(){
//    $("h1").html("Yo, this works");
// });

$(".edit-post").on("click", function () {
    let postId = $(this).attr("data-id")
    window.location = "/posts/" + postId
});