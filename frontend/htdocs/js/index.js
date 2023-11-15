const TABLE_HEAD = '<tr><th style="width:33%">Name</th><th style="width:34%">Time</th><th style="width:33%">Group Size</th></tr>'

// API calls
const API_ADD = "/api/add-reservation";
const API_GET = "/api/get-reservations";

// Elements of webpage
const table = document.getElementById("reservations");
const button = document.getElementById("add");
const nameInput = document.getElementById("name");
const timeInput = document.getElementById("time");
const groupInput = document.getElementById("group");

// Convert a Reservation object into a single row of an html table
function drawRow(reservation) {
    // Empty row
    if (reservation == null)
        return "<tr><td></td><td></td><td></td></tr>";

    return "<tr><td>" + reservation.customerName + "</td><td>" + reservation.time + "</td><td>" + reservation.groupSize + "</td></tr>";
}

// Takes an array of Reservation objects and turns it into a string with html to display those objects in a table
function drawTable(reservations) {
    let t = TABLE_HEAD;

    // If the array is empty, draw a single empty row
    if (reservations.length == 0)
        t += drawRow(null);

    // Draw each row one at a time
    for (res of reservations) {
        t += drawRow(res);
    }
    
    return t;
}

async function updateTable() {
    let response = null;
    // Call the api with a GET request to get a list of reservations.
    await fetch(API_GET, { method: "GET"})
        .then(async res => { response = await res.json(); });

    // Don't do anything if there is no response or an invalid response
    if (response == null || response === undefined)
        return;

    // Modify the html between the table tag
    table.innerHTML = drawTable(response);
}

function addReservation() {
    // Call the api with a POST request. The body is the JSON repesentation of a Reservation object from the java code.
    fetch(API_ADD, {
        method: 'POST',
        body: JSON.stringify({
            customerName: nameInput.value,
            time: timeInput.value,
            groupSize: parseInt(groupInput.value)
        }),
        headers: {
          'Content-type': 'application/json; charset=UTF-8',
        }
    }).then(res => { updateTable() }); // Redraw the table upon recieving a response
}

// Update the table on page load
updateTable();

// Set the button's onclick action to the addReservation function
button.onclick = addReservation;