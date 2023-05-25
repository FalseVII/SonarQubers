
function handle(number,list){
    var count = 0;
    var grade = 0;
    for (var i = 0; i < list.length; i++) {
        count++;
        switch(list[i].vulnerabilityProbability.toUpperCase()){
            case 'HIGH':
                grade += 50;
                break;
            case 'MEDIUM':
                grade += 25;
                break;
            case 'LOW':
                grade += 10;
                break;
            default:
                break;
        }
    }
    var grade_letter = "";

    if(grade >= 69){
        grade_letter = "E";
    }else if(grade >= 36){
        grade_letter = "D";
    }else if(grade >= 26){
        grade_letter = "C";
    }else if(grade >= 11){
        grade_letter = "B";
    }else if(grade >= 0){
        grade_letter = "A";
    }else{
        grade_letter = "Unknown";
    }


    var countElement = document.getElementById("step" + number);

// Create and append the count text node
    var countTextNode = document.createTextNode("Count: " + JSON.stringify(count));
    countElement.appendChild(countTextNode);

// Create and append the grade HTML element
    var gradeElement = document.createElement('div');
    gradeElement.className = 'rating';

    var gradeLetterElement = document.createElement('div');
    gradeLetterElement.className = grade_letter;
    gradeLetterElement.textContent = grade_letter;

    gradeElement.appendChild(gradeLetterElement);
    countElement.appendChild(gradeElement);



}

    function Drawgraph(data){
    var programData =[];
 for (var i = 0; i < data.length; i++) {
		const date = new Date(data[i].datetime);
		const formattedDate = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate();
		const allHotSpots =  parseInt(data[i].owasp1_count)+  parseInt(data[i].owasp2_count)+  parseInt(data[i].owasp3_count)
		+ parseInt(data[i].owasp4_count) +  parseInt(data[i].owasp5_count);
      programData.push({
        year: formattedDate,
        quantity: allHotSpots
      });
    }
          // Create the chart
            var ctx = document.getElementById('myChartLine').getContext('2d');
    var myChart = new Chart(ctx, {

      type: 'line',
      data: {
        labels: programData.map(function(date) {
          return date.year;
        }),
        datasets: [{
          label: 'Vulnerabilities',
          data: programData.map(function(hotspot) {
            return hotspot.quantity;
          }),
          borderColor: 'rgb(255, 99, 132)',
          borderWidth: 1
        }]
      },
      options: {
        responsive: false,
        maintainAspectRatio: false
      }
          });
			return data;
    }
function getAndDrawOverAllRating() {
    $.ajax({
        url: "http://localhost:8080/api/v1/rating",
        type: "GET",
        success: function(response) {
            console.log("GET request successful:", response);
            var grade_letter;
            if (response === "1.0") {
                grade_letter = "A";
            } else if (response === "2.0") {
                grade_letter = "B";
            } else if (response === "3.0") {
                grade_letter = "C";
            } else if (response === "4.0") {
                grade_letter = "D";
            } else if (response === "5.0") {
                grade_letter = "E";
            } else {
                grade_letter = "Unknown";
            }

            var ratingOverAllElement = document.getElementById("ratingOverAll");

            var gradeElement = document.createElement('div');
            gradeElement.className = 'rating';

            var gradeLetterElement = document.createElement('div');
            gradeLetterElement.className = grade_letter;
            gradeLetterElement.textContent = grade_letter;

            gradeElement.appendChild(gradeLetterElement);
            ratingOverAllElement.appendChild(gradeElement);
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
                //Drawgraph(response);
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