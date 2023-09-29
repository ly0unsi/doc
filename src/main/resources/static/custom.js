// Get a reference to the canvas element
var ctx = document.getElementById('myPieChart').getContext('2d');
var ctx2 = document.getElementById('myPieChart2').getContext('2d');
var ctx3 = document.getElementById('myPieChart3').getContext('2d');

// Define the data for the pie chart
var data = {
    labels: ['Presence', 'Absence'],
    datasets: [{
        data: [80, 20], // Replace with your data values
        backgroundColor: ['#5cb85c', '#d9534f'], // Replace with your desired colors
    }],
};
var data2 = {
    labels: ['Presence', 'Absence'],
    datasets: [{
        data: [90, 10], // Replace with your data values
        backgroundColor: ['#5cb85c', '#d9534f'], // Replace with your desired colors
    }],
};
var data3 = {
    labels: ['Presence', 'Absence'],
    datasets: [{
        data: [65, 35], // Replace with your data values
        backgroundColor: ['#5cb85c', '#d9534f'], // Replace with your desired colors
    }],
};

// Create the pie chart
var myPieChart = new Chart(ctx, {
    type: 'pie',
    data: data,
});
var myPieChart2 = new Chart(ctx2, {
    type: 'pie',
    data: data2,
});
var myPieChart3 = new Chart(ctx3, {
    type: 'pie',
    data: data3,
});
