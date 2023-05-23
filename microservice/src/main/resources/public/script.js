    function handle(number,list){
    var count = 0;

        for (var i = 0; i < list.length; i++) {
            count++;
        }

        var countElement = document.getElementById("step" + number);
        countElement.append("Count: " + JSON.stringify(count));
    }

    function Drawgraph(json){

    }

    function getAndDrawOverAllRating() {
        $.ajax({
            url: "http://localhost:8080/api/v1/rating",
            type: "GET",
            success: function(response) {
                console.log("GET request successful:", response);
                var ratingOverAllElement = document.getElementById("ratingOverAll");
                if (response === 1) {
                    ratingOverAllElement.textContent = "A";
                } else if (response === 2) {
                    ratingOverAllElement.textContent = "B";
                } else if (response === 3) {
                    ratingOverAllElement.textContent = "C";
                } else if (response === 4) {
                    ratingOverAllElement.textContent = "D";
                } else if (response === 5) {
                    ratingOverAllElement.textContent = "E";
                } else {
                    ratingOverAllElement.textContent = "Unknown";
                }
            },
            error: function(xhr, status, error) {
                console.log("GET request error:", error);
                // Handle the error here
            }
        });
    }


    function getGraphingData(){
        $.ajax({
            url: "http://localhost:8080/api/v1/repo",
            type: "GET",
            success: function(response) {
                console.log("GET request successful:", response);
                Drawgraph(response);
            },
            error: function(xhr, status, error) {
                console.log("GET request error:", error);
                // Handle the error here
            }
        });
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

        getGraphingData();
        getAndDrawOverAllRating();

});