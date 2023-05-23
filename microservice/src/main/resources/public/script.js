    function handle(number,list){
    var count = 0;

        for (var i = 0; i < list.length; i++) {
            count++;
        }

        var countElement = document.getElementById("step" + number);
        countElement.append("Count: " + JSON.stringify(count));
    }
    function getGeneric(number){
        $.ajax({
            url: "http://localhost:8080/api/v1/owasp"+number,
            type: "GET",
            success: function(response) {
                console.log("GET request successful:", response);
                handle(number,response)
            },
            error: function(xhr, status, error) {
                console.log("GET request error:", error);
                // Handle the error here
            }
        });

    }
    $(document).ready(function() {

        for(i =1; i <=10; i++ ){
            getGeneric(i);
        }
});