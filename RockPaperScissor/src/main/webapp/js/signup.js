var signupModule=(function(){
    $(".registerbtn").on("click", function(e){
        e.preventDefault();
        name = $("#userName").val();
        name= name.trim()
        if( name ){
            $.post('/signup', {userName: name}, function (data, status){

            })
        }
    })
})();