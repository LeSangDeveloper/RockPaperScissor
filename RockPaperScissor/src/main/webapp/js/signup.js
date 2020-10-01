var signupModule=(function(){
    $(".registerbtn").on("click", function(e){
        e.preventDefault();
        name = $("#username").val();
        name= name.trim()
        if( name ){
            $.post('/signup', {username: name}, function (data, status){

            })
        }
    })
})();