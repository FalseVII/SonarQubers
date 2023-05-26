window.onload = function() {
    fetch('http://localhost:8080/classify',{
        method: 'POST'
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            fetchAndFillInfoTab()
            drawLineChart()
            for (let i = 1; i <= 10; i++) {
                fetchDataAndFillTab(i);
            }
        })
        .catch(error => console.error('There has been a problem with your fetch operation:', error));
};

function fetchAndFillInfoTab() {
    const tabTitles = [
        "", // to keep 1-based indexing
        "A01 Broken Access Control",
        "A02 Cryptographic Failures",
        "A03 Injection",
        "A04 Insecure Design",
        "A05 Security Misconfiguration",
        "A06 Vulnerable and Outdated Components",
        "A07 Identification and Authentication Failures",
        "A08 Software and Data Integrity Failures",
        "A09 Security Logging and Monitoring Failures",
        "A10 Server Side Request Forgery (SSRF)"
    ];

    // Create an array to store the results for each category
    let categoryResults = new Array(11).fill(null).map(() => ({
        count: 0,
        grade: 0
    }));

    // Make 10 API calls in parallel
    let promises = [];
    for (let i = 1; i <= 10; i++) {
        promises.push(
            fetch(`http://localhost:8080/api/v1/owasp${i}`)
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Network response was not ok');
                    }
                    return response.json();
                })
                .then(data => {
                    // Update the count and grade for this category
                    data.forEach(item => {
                        categoryResults[i].count++;
                        switch(item.vulnerabilityProbability.toUpperCase()){
                            case 'HIGH':
                                categoryResults[i].grade += 50;
                                break;
                            case 'MEDIUM':
                                categoryResults[i].grade += 25;
                                break;
                            case 'LOW':
                                categoryResults[i].grade += 10;
                                break;
                            default:
                                break;
                        }
                    });
                })
        );
    }

    // When all the API calls are done
    Promise.all(promises)
        .then(() => {
            // Create a string with the overview info
            let infoContent = '<div class="info-container text-left mb-3">';

            infoContent += `<h2 class="text-center border-bottom">General Overview</h2>`
            // For each category, calculate the grade and add the stats to infoContent
            for (let i = 1; i <= 10; i++) {
                let grade_letter = "";
                if(categoryResults[i].grade >= 69){
                    grade_letter = "E";
                } else if(categoryResults[i].grade >= 36){
                    grade_letter = "D";
                } else if(categoryResults[i].grade >= 26){
                    grade_letter = "C";
                } else if(categoryResults[i].grade >= 11){
                    grade_letter = "B";
                } else if(categoryResults[i].grade >= 0){
                    grade_letter = "A";
                } else {
                    grade_letter = "Unknown";
                }

                infoContent += `
    <div class="mb-3 ${i % 2 === 0 ? 'dark' : 'light'}">
        <h4>${tabTitles[i]}</h4>
        <div class="d-flex justify-content-between">
            <p>Count: ${categoryResults[i].count}</p>
            <div>
                <span class="fs-5 d-inline-flex justify-content-center align-items-center ${grade_letter}" 
                      style="border-radius: 50%; padding: 10px; width: 50px; height: 50px;">
                      ${grade_letter}
                </span>
            </div>
        </div>
    </div>
`;




            }

            infoContent += '</div>';

            // Insert this string into the info tab
            document.querySelector('#info').innerHTML = infoContent;
        })
        .catch(error => console.error('There has been a problem with your fetch operation:', error));
}

const tabTitles = [
    "", // to keep 1-based indexing
    "A01 Broken Access Control",
    "A02 Cryptographic Failures",
    "A03 Injection",
    "A04 Insecure Design",
    "A05 Security Misconfiguration",
    "A06 Vulnerable and Outdated Components",
    "A07 Identification and Authentication Failures",
    "A08 Software and Data Integrity Failures",
    "A09 Security Logging and Monitoring Failures",
    "A10 Server Side Request Forgery (SSRF)"
];

function fetchDataAndFillTab(tabNumber) {
    fetch(`http://localhost:8080/api/v1/owasp${tabNumber}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            let count = 0;
            let grade = 0;

            data.forEach(item => {
                count++;
                switch(item.vulnerabilityProbability.toUpperCase()){
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
            });

            let grade_letter = "";
            if(grade >= 69){
                grade_letter = "E";
            } else if(grade >= 36){
                grade_letter = "D";
            } else if(grade >= 26){
                grade_letter = "C";
            } else if(grade >= 11){
                grade_letter = "B";
            } else if(grade >= 0){
                grade_letter = "A";
            } else {
                grade_letter = "Unknown";
            }

            let tabContent = `
          <div class="grade-container text-center mb-3">
            <h2>Tab ${tabNumber}</h2>
            <h5>Count: ${count}</h5>
            <p class="${grade_letter}">${grade_letter}</p>
          </div>
        `;

            data.forEach(item => {
                tabContent += `
            <div class="card my-3">
              <div class="card-body">
                <h5 class="card-title">${item.component}</h5>
                <h6 class="card-subtitle mb-2 text-muted">Key: ${item.key}</h6>
                <p class="card-text">
                  <strong>Project:</strong> ${item.project} <br/>
                  <strong>Security Category:</strong> ${item.securityCategory} <br/>
                  <strong>Status:</strong> ${item.status} <br/>
                  <strong>Vulnerability Probability:</strong> ${item.vulnerabilityProbability} <br/>
                </p>
                <div class="read-more">
                  <strong>Line:</strong> ${item.line} <br/>
                  <strong>Message:</strong> ${item.message} <br/>
                  <strong>Author:</strong> ${item.author} <br/>
                  <strong>Creation Date:</strong> ${item.creationDate} <br/>
                  <strong>Update Date:</strong> ${item.updateDate} <br/>
                  <strong>Text Range:</strong> ${item.textRange.startLine} - ${item.textRange.endLine} (${item.textRange.startOffset} - ${item.textRange.endOffset}) <br/>
                  <strong>Rule Key:</strong> ${item.ruleKey} <br/>
                </div>
                <button class="read-more-btn">Read More</button>
              </div>
            </div>
          `;
            });

            // Assume there is a container to hold tab content
            const tabContainer = document.querySelector(`#A${tabNumber}`);
            tabContainer.innerHTML = tabContent;

            tabContainer.addEventListener('click', function(e) {
                // Check if the event target (the element that was actually clicked) matches '.read-more-btn'
                if (e.target.matches('.read-more-btn')) {
                    const readMoreDiv = e.target.previousElementSibling;
                    readMoreDiv.style.display = readMoreDiv.style.display !== 'block' ? 'block' : 'none';
                    e.target.textContent = e.target.textContent === 'Read More' ? 'Read Less' : 'Read More';
                }
            });
        })
        .catch(error => console.error('There has been a problem with your fetch operation:', error));
}

function fetchChart(){
    fetch('http://localhost:8080/api/v1/repo')
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            drawLineChart(data);
        })
        .catch(error => {
            console.error('There has been a problem with your fetch operation:', error);
        });
}

async function drawLineChart() {
    const response = await fetch('http://localhost:8080/api/v1/repo');
    const data = await response.json();

    const labels = data.map((item, index) => index + 1);  // Generate array of indices [0, 1, 2, ...]

    const datasets = data.map(item => {
        // calculate total count
        let totalCount = 0;
        for (let i = 1; i <= 10; i++) {
            totalCount += Number(item[`owasp${i}_count`]);
        }
        totalCount += Number(item.cest_count) + Number(item.cwe_count);
        return totalCount;
    });

    const ctx = document.getElementById('myChart').getContext('2d');
    const myChart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: labels,
            datasets: [{
                label: '# of Counts',
                data: datasets,
                fill: false,
                borderColor: 'rgb(75, 192, 192)',
                tension: 0.1
            }]
        }
    });
}


