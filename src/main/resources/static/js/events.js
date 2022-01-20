$(document).ready(function () {
    loadEvents();
});

async function loadEvents() {
    const request = await fetch('http://localhost:8081/events/list', {
        method: 'GET',
        headers: {
            Accept: 'application/json',
            'Content-Type': 'application/json',
        },
    });

    const events = await request.json();

    let listHtml = '';

    for (let event of events) {
        let eventHtml =
            '<tr><td id="eventId">' +
            event.eventId +
            '</td><td>' +
            event.eventName +
            '</td><td>' +
            event.eventDescription +
            '</td><td>' +
            event.eventStartDate +
            '</td><td>' +
            event.eventEndDate +
            '</td><td>' +
            event.eventStatus +
            '</td><td>' +
            event.eventStatus +
            '</td><td><a class="btn btn-warning">Edit</a><a class="btn btn-danger">Delete</a></td></tr>';

        listHtml += eventHtml;
    }

    console.log(events);

    document.querySelector('#eventsTable tbody').outerHTML = listHtml;
}
