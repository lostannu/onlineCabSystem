document.getElementById('bookingForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const pickup = document.getElementById('pickup').value;
    const dropoff = document.getElementById('dropoff').value;
    const date = document.getElementById('date').value;
    const time = document.getElementById('time').value;

    // Simulate fetching available cabs
    const availableCabs = [
        { id: 1, type: 'Sedan', price: '$20' },
        { id: 2, type: 'SUV', price: '$30' },
        { id: 3, type: 'Luxury', price: '$50' }
    ];

    displayAvailableCabs(availableCabs);
    showConfirmation(pickup, dropoff, date, time);
});

function displayAvailableCabs(cabs) {
    const cabList = document.getElementById('cabList');
    cabList.innerHTML = '';

    cabs.forEach(cab => {
        const li = document.createElement('li');
        li.textContent = `${cab.type} - ${cab.price}`;
        cabList.appendChild(li);
    });

    document.getElementById('availableCabs').classList.remove('hidden');
}

function showConfirmation(pickup, dropoff, date, time) {
    const confirmationMessage = document.getElementById('confirmationMessage');
    confirmationMessage.textContent = `Your cab from ${pickup} to ${dropoff} is booked for ${date}



// script.js

// Simulated user data (for demonstration purposes)
const users = [
    { username: "user1", password: "password1" },
    { username: "user2", password: "password2" }
];

// Function to check if the user is logged in
function checkLogin() {
    // Simulate checking for a logged-in user (replace this with actual logic)
    const isLoggedIn = sessionStorage.getItem("loggedIn") === "true"; // Check session storage

    if (!isLoggedIn) {
        alert("You are not logged in!");
        // Optionally redirect to the login page
        window.location.href = "login.html"; // Uncomment this line to redirect
    }
}

// Function to log in the user
function login(username, password) {
    const user = users.find(user => user.username === username && user.password === password);
    if (user) {
        sessionStorage.setItem("loggedIn", "true"); // Set login status in session storage
        alert("Login successful!");
        window.location.href = "booking.html"; // Redirect to booking page
    } else {
        alert("Invalid username or password.");
    }
}

// Function to log out the user
function logout() {
    sessionStorage.removeItem("loggedIn"); // Remove login status from session storage
    alert("You have been logged out.");
    window.location.href = "login.html"; // Redirect to login page
}

// Call the checkLogin function when the page loads
window.onload = checkLogin;

// Example usage of the login function (you can call this from your login form)
function handleLoginForm(event) {
    event.preventDefault(); // Prevent form submission
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    login(username, password);
}

// Example usage of the logout function (you can call this from your logout button)
function handleLogout() {
    logout();
}
