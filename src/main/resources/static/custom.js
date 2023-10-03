// Get a reference to the canvas element
// var ctx = document.getElementById('myPieChart').getContext('2d');
// var ctx2 = document.getElementById('myPieChart2').getContext('2d');
// var ctx3 = document.getElementById('myPieChart3').getContext('2d');

// // Define the data for the pie chart
// var data = {
//     labels: ['Presence', 'Absence'],
//     datasets: [{
//         data: [80, 20], // Replace with your data values
//         backgroundColor: ['#5cb85c', '#d9534f'], // Replace with your desired colors
//     }],
// };
// var data2 = {
//     labels: ['Presence', 'Absence'],
//     datasets: [{
//         data: [90, 10], // Replace with your data values
//         backgroundColor: ['#5cb85c', '#d9534f'], // Replace with your desired colors
//     }],
// };
// var data3 = {
//     labels: ['Presence', 'Absence'],
//     datasets: [{
//         data: [65, 35], // Replace with your data values
//         backgroundColor: ['#5cb85c', '#d9534f'], // Replace with your desired colors
//     }],
// };

// // Create the pie chart
// var myPieChart = new Chart(ctx, {
//     type: 'pie',
//     data: data,
// });
// var myPieChart2 = new Chart(ctx2, {
//     type: 'pie',
//     data: data2,
// });
// var myPieChart3 = new Chart(ctx3, {
//     type: 'pie',
//     data: data3,
// });

$(document).ready(function () {

});
const loadAbsence = (docid) => {
    $.ajax({
        type: "GET",
        url: "/api/v1/doctorants/absence/" + docid,
        dataType: "json",
        success: function (response) {
            // Handle the successful response here
            // $("#spinner").hide();
            // $("#mychartContainer").show();

            console.log(response);
            const template = $("#chart-template").html();
            let html = '';
            response.map((absence, index) => {
                // console.log(index, absence);

                const rendered = Mustache.render(template, absence);
                console.log("rendered", rendered);
                html += rendered
                $("#mychartContainer").html(html);
                var ctx = document.getElementById('myPieChart' + absence.date).getContext('2d');
                const totalAbsence = absence.absences
                const totalPresence = absence.total - totalAbsence
                console.log(totalPresence, totalAbsence);
                var data = {
                    labels: ['Presence', 'Absence'],
                    datasets: [{
                        data: [totalAbsence, totalPresence], // Replace with your data values
                        backgroundColor: ['#5cb85c', '#d9534f'], // Replace with your desired colors
                    }],
                };
                new Chart(ctx, {
                    type: 'pie',
                    data: data,
                });
            })

            response.map((absence, index) => {
                // console.log(index, absence);


                var ctx = document.getElementById('myPieChart' + absence.date).getContext('2d');
                const totalAbsence = absence.absences
                const totalPresence = absence.total - totalAbsence
                console.log(totalPresence, totalAbsence);
                var data = {
                    labels: ['Presence', 'Absence'],
                    datasets: [{
                        data: [totalAbsence, totalPresence], // Replace with your data values
                        backgroundColor: ['#5cb85c', '#d9534f'], // Replace with your desired colors
                    }],
                };
                new Chart(ctx, {
                    type: 'pie',
                    data: data,
                });
            })

            // Define the data for the pie chart

        },
        error: function (error) {
            // Handle any errors here
            console.error("Error:", error);
        }
    });

}

const loadAvancement = (docid) => {
    $.ajax({
        type: "GET",
        url: "/api/v1/doctorants/avancement/" + docid,
        dataType: "json",
        success: function (response) {
            console.log(response);
            const template = $("#card-template").html();
            let html = '';
            response.map(item => {
                const rendered = Mustache.render(template, item);
                console.log("rendered", rendered);
                html += rendered
                $("#cardsContainer").html(html);
            })

            var months = response.map(item => item.date);
            var evs = response.map(item => item.evaluation);
            console.log("evs", evs);

            var ctx = document.getElementById('barChart').getContext('2d');
            var myBarChart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: months,
                    datasets: [{
                        label: "evaluation",

                        data: evs,
                        backgroundColor: [
                            'rgba(255, 99, 132, 0.2)',
                            'rgba(255, 159, 64, 0.2)',
                            'rgba(255, 205, 86, 0.2)',
                            'rgba(75, 192, 192, 0.2)',
                            'rgba(54, 162, 235, 0.2)',
                            'rgba(153, 102, 255, 0.2)',
                            'rgba(201, 203, 207, 0.2)'
                        ],
                        borderColor: [
                            'rgb(255, 99, 132)',
                            'rgb(255, 159, 64)',
                            'rgb(255, 205, 86)',
                            'rgb(75, 192, 192)',
                            'rgb(54, 162, 235)',
                            'rgb(153, 102, 255)',
                            'rgb(201, 203, 207)'
                        ],
                        borderWidth: 1,
                        datalabels: {
                            labels: {
                                title: { // Add a title to the label
                                    display: true,
                                    font: {
                                        weight: 'bold'
                                    },
                                    formatter: function (context) {
                                        var index = context.dataIndex;
                                        return `${response[index].title} - ${response[index].desc}`;
                                    }
                                }
                            }
                        },
                    }]
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true
                        }
                    }
                }
            });


            console.log(response);


        }
    })
}



