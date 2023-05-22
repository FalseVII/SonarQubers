    function handle(number,list){
    count = 0;

        for (var i = 0; i < list.length; i++) {
            var obj = list[i];

            // Get the 'key' property value
            var key = obj.key;

            // Check if the key already exists in the count object
            if (count.hasOwnProperty(key)) {
                // Increment the count if the key exists
                count[key]++;
            } else {
                // Initialize the count to 1 if the key doesn't exist
                count[key] = 1;
            }
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