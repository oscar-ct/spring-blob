// alert("hello")
// $(document).ready(function(){
//    $("h1").html("Yo, this works");
// });

$(".edit-post").on("click", function () {
    let postId = $(this).attr("data-id")
    window.location = "/posts/" + postId + "/edit"
});




// client.picker().open();


// th:inline="javascript";


//testing it gets passed through

const client = filestack.init(API_KEY);
const options = {
    fromSources: ["local_file_system","instagram","facebook"],
    onUploadDone:
        function (res){
            $("#image3").val(res.filesUploaded[0].url);
            console.log("url + " + res.filesUploaded[0].url);
        }
}


$(".upload-picture").on("click", function () {
// alert("testing")
    client.picker(options).open()
});

// document.querySelector('.upload-picture').addEventListener("click", function () {
//     alert("Your api key is: " + apiKey);
// });
