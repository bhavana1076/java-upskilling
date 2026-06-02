"use strict";

console.log("Welcome to the Community Portal");

window.addEventListener("load", () => {
  alert("The Community Portal page has fully loaded.");
});

const sampleEventName = "Community Cleanup";
const sampleEventDate = "2026-06-20";
let sampleSeats = 20;
console.log(`${sampleEventName} is scheduled for ${sampleEventDate}. Seats available: ${sampleSeats}`);
sampleSeats--;
console.log(`After one sample registration, seats available: ${sampleSeats}`);

class Event {
  constructor(id, name, date, category, location, seats = 0) {
    this.id = id;
    this.name = name;
    this.date = date;
    this.category = category;
    this.location = location;
    this.seats = seats;
    this.registrations = 0;
  }
}

Event.prototype.checkAvailability = function checkAvailability() {
  return isUpcoming(this.date) && this.seats > 0;
};

let events = [
  new Event(101, "Open Mic Evening", "2026-06-30", "music", "Community Hall", 5),
  new Event(102, "Library Coding Workshop", "2026-07-08", "workshop", "Library", 7),
  new Event(103, "Past Garden Talk", "2025-12-01", "workshop", "Central Park", 3),
  new Event(104, "Full Yoga Morning", "2026-07-11", "sports", "Riverfront", 0)
];

const eventsContainer = document.querySelector("#eventsContainer");
const categoryFilter = document.querySelector("#categoryFilter");
const locationFilter = document.querySelector("#locationFilter");
const searchInput = document.querySelector("#searchInput");
const eventSelect = document.querySelector("#eventSelect");
const message = document.querySelector("#message");
const loadingSpinner = document.querySelector("#loadingSpinner");
const registrationForm = document.querySelector("#registrationForm");
const debugOutput = document.querySelector("#debugOutput");

function isUpcoming(dateValue) {
  const today = new Date();
  today.setHours(0, 0, 0, 0);
  return new Date(dateValue) >= today;
}

function addEvent(eventList, eventData) {
  const event = eventData instanceof Event
    ? eventData
    : new Event(
      eventData.id,
      eventData.name,
      eventData.date,
      eventData.category,
      eventData.location,
      eventData.seats
    );

  eventList.push(event);
  return event;
}

function createCategoryRegistrationTracker() {
  const totals = {};

  return function track(category) {
    totals[category] = (totals[category] || 0) + 1;
    return totals[category];
  };
}

const trackCategoryRegistration = createCategoryRegistrationTracker();

function registerUser(eventId, userName = "Guest") {
  try {
    const selectedEvent = events.find((eventItem) => eventItem.id === Number(eventId));

    if (!selectedEvent) {
      throw new Error("Please choose a valid event.");
    }

    if (!selectedEvent.checkAvailability()) {
      throw new Error(`${selectedEvent.name} is not available for registration.`);
    }

    selectedEvent.seats--;
    selectedEvent.registrations++;
    const categoryTotal = trackCategoryRegistration(selectedEvent.category);
    message.textContent = `${userName} registered for ${selectedEvent.name}. ${categoryTotal} ${selectedEvent.category} registration(s) tracked.`;
    console.log("Registration completed", { eventId, userName, selectedEvent });
    renderEvents();
    populateEventOptions();
    return selectedEvent;
  } catch (error) {
    message.textContent = error.message;
    console.error("Registration failed:", error);
    return null;
  }
}

function cancelRegistration(eventId) {
  const selectedEvent = events.find((eventItem) => eventItem.id === Number(eventId));

  if (!selectedEvent || selectedEvent.registrations <= 0) {
    message.textContent = "No registration found to cancel for this event.";
    return;
  }

  selectedEvent.seats++;
  selectedEvent.registrations--;
  message.textContent = `Cancelled one registration for ${selectedEvent.name}.`;
  renderEvents();
  populateEventOptions();
}

function filterEventsByCategory(eventList, category = "all", callback = (eventItem) => eventItem) {
  const clonedEvents = [...eventList];
  const filteredEvents = category === "all"
    ? clonedEvents
    : clonedEvents.filter((eventItem) => eventItem.category === category);

  return filteredEvents.map(callback);
}

function getVisibleEvents() {
  const selectedCategory = categoryFilter.value;
  const selectedLocation = locationFilter.value;
  const searchText = searchInput.value.trim().toLowerCase();

  return filterEventsByCategory(events, selectedCategory, (eventItem) => eventItem)
    .filter((eventItem) => selectedLocation === "all" || eventItem.location === selectedLocation)
    .filter((eventItem) => eventItem.name.toLowerCase().includes(searchText))
    .filter((eventItem) => eventItem.checkAvailability());
}

function formatEventCards(eventList) {
  return eventList.map(({ name, category }) => `${capitalize(category)} on ${name}`);
}

function capitalize(value) {
  return value.charAt(0).toUpperCase() + value.slice(1);
}

function renderEvents() {
  eventsContainer.innerHTML = "";

  const visibleEvents = getVisibleEvents();
  const musicEvents = events.filter((eventItem) => eventItem.category === "music");
  console.log("Music events:", musicEvents);
  console.log("Formatted cards:", formatEventCards(visibleEvents));

  if (visibleEvents.length === 0) {
    const emptyMessage = document.createElement("p");
    emptyMessage.textContent = "No upcoming events with open seats match your filters.";
    eventsContainer.appendChild(emptyMessage);
    return;
  }

  visibleEvents.forEach((eventItem) => {
    const card = document.createElement("article");
    card.className = "event-card";

    const title = document.createElement("h3");
    title.textContent = eventItem.name;

    const details = document.createElement("p");
    details.className = "event-meta";
    details.innerHTML = `
      Date: ${eventItem.date}<br>
      Category: ${capitalize(eventItem.category)}<br>
      Location: ${eventItem.location}<br>
      Seats: ${eventItem.seats}<br>
      Registered from this page: ${eventItem.registrations}
    `;

    const objectInfo = document.createElement("p");
    objectInfo.className = "event-meta";
    objectInfo.textContent = Object.entries(eventItem)
      .map(([key, value]) => `${key}: ${value}`)
      .join(" | ");

    const actions = document.createElement("div");
    actions.className = "event-actions";

    const registerButton = document.createElement("button");
    registerButton.type = "button";
    registerButton.textContent = "Register";
    registerButton.onclick = () => registerUser(eventItem.id);

    const cancelButton = document.createElement("button");
    cancelButton.type = "button";
    cancelButton.className = "secondary";
    cancelButton.textContent = "Cancel";
    cancelButton.onclick = () => cancelRegistration(eventItem.id);

    actions.append(registerButton, cancelButton);
    card.append(title, details, objectInfo, actions);
    eventsContainer.appendChild(card);
  });

  if (window.jQuery) {
    $(".event-card").hide().fadeIn(300);
  }
}

function populateEventOptions() {
  eventSelect.innerHTML = "";

  events
    .filter((eventItem) => eventItem.checkAvailability())
    .forEach((eventItem) => {
      const option = document.createElement("option");
      option.value = eventItem.id;
      option.textContent = `${eventItem.name} (${eventItem.seats} seats)`;
      eventSelect.appendChild(option);
    });
}

function clearErrors() {
  document.querySelector("#nameError").textContent = "";
  document.querySelector("#emailError").textContent = "";
  document.querySelector("#eventError").textContent = "";
}

function validateRegistrationForm(form) {
  clearErrors();

  const { name, email, eventId } = form.elements;
  let isValid = true;

  if (!name.value.trim()) {
    document.querySelector("#nameError").textContent = "Name is required.";
    isValid = false;
  }

  if (!email.value.trim() || !email.value.includes("@")) {
    document.querySelector("#emailError").textContent = "Enter a valid email address.";
    isValid = false;
  }

  if (!eventId.value) {
    document.querySelector("#eventError").textContent = "Select an available event.";
    isValid = false;
  }

  return isValid;
}

function postRegistration(userData) {
  console.log("Submitting registration payload:", userData);
  debugOutput.textContent = JSON.stringify(userData, null, 2);

  return new Promise((resolve) => {
    setTimeout(resolve, 1200);
  }).then(() => fetch("https://jsonplaceholder.typicode.com/posts", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(userData)
  }));
}

registrationForm.addEventListener("submit", (event) => {
  event.preventDefault();
  console.log("Form submit started.");

  if (!validateRegistrationForm(registrationForm)) {
    console.warn("Form validation failed.");
    return;
  }

  const { name, email, eventId } = registrationForm.elements;
  const payload = {
    name: name.value.trim(),
    email: email.value.trim(),
    eventId: Number(eventId.value)
  };

  postRegistration(payload)
    .then((response) => {
      if (!response.ok) {
        throw new Error("Server rejected the registration.");
      }
      return response.json();
    })
    .then((data) => {
      console.log("Server response:", data);
      registerUser(payload.eventId, payload.name);
      registrationForm.reset();
      message.textContent += " Server submission succeeded.";
    })
    .catch((error) => {
      message.textContent = "Registration could not be sent. Check Console and Network tabs.";
      console.error("Fetch request failed:", error);
    });
});

categoryFilter.onchange = renderEvents;
locationFilter.onchange = renderEvents;
searchInput.addEventListener("keydown", () => {
  setTimeout(renderEvents, 0);
});

function fetchEventsWithThen() {
  return fetch("events.json")
    .then((response) => {
      if (!response.ok) {
        throw new Error("Could not load local event data.");
      }
      return response.json();
    })
    .then((eventData) => {
      console.log("Events loaded with .then():", eventData);
      return eventData;
    })
    .catch((error) => {
      console.error("Fetch with .then() failed:", error);
      return [];
    });
}

async function fetchEventsWithAsyncAwait() {
  loadingSpinner.classList.add("visible");

  try {
    const response = await fetch("events.json");

    if (!response.ok) {
      throw new Error("Could not load local event data.");
    }

    const eventData = await response.json();
    eventData.forEach((eventItem) => addEvent(events, eventItem));
    message.textContent = "Upcoming events loaded.";
  } catch (error) {
    message.textContent = "Using built-in sample events because the mock API could not be loaded.";
    console.error("Async/await fetch failed:", error);
  } finally {
    loadingSpinner.classList.remove("visible");
    renderEvents();
    populateEventOptions();
  }
}

if (window.jQuery) {
  $("#registerBtn").click(() => {
    $("#message").fadeOut(100).fadeIn(200);
  });
}

console.log("Benefit of React or Vue: component-based state management makes larger event portals easier to maintain.");

fetchEventsWithThen().then(() => fetchEventsWithAsyncAwait());
