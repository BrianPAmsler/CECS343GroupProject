const TABLE_HEAD = "<tr><th>Name</th><th>Time</th><th>Group Size</th></tr>"
const API_ADD = "/api/add-reservation";
const API_GET = "/api/get-reservations";

const table = document.getElementById("reservations");
const button = document.getElementById("add");
const nameInput = document.getElementById("name");
const timeInput = document.getElementById("time");
const groupInput = document.getElementById("group");

function drawRow(reservation) {
    if (reservation == null)
        return "<tr><td></td><td></td><td></td></tr>";

    return "<tr><td>" + reservation.customerName + "</td><td>" + reservation.time + "</td><td>" + reservation.groupSize + "</td></tr>";
}

function drawTable(reservations) {
    let t = TABLE_HEAD;

    if (reservations.length == 0)
        t += drawRow(null);

    for (res of reservations) {
        t += drawRow(res);
    }
    
    return t;
}

async function updateTable() {
    let response = null;
    await fetch(API_GET, { method: "GET"})
        .then(async res => { response = await res.json(); });

    if (response == null || response === undefined)
        return;

    table.innerHTML = drawTable(response);
}

function addReservation() {
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
    }).then(res => { updateTable() });

}

updateTable();

button.onclick = addReservation;