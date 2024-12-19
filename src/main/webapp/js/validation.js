// Function to validate form input
function validateForm() {
    let isValid = true;

    // Clear previous error messages
    clearErrors();

    // Get form values
    const pickupLocation = document.forms["bookingForm"]["pickupLocation"].value;
    const dropoffLocation = document.forms["bookingForm"]["dropoffLocation"].value;
    const pickupTime = document.forms["bookingForm"]["pickupTime"].value;
    const contactNumber = document.forms["bookingForm"]["contactNumber"].value;

    // Validate Pickup Location
    if (pickupLocation === "") {
        document.getElementById("pickupError").innerText = "Pickup location is required.";
        isValid = false;
    }

    // Validate Drop-off Location
    if (dropoffLocation === "") {
        document.getElementById("dropoffError").innerText = "Drop-off location is required.";
        isValid = false;
    }

    // Validate Pickup Time
    if (pickupTime === "") {
        document.getElementById("pickupTimeError").innerText = "Pickup time is required.";
        isValid = false;
    }

    // Validate Contact Number (Basic validation: 10 digits)
    const phonePattern = /^[0-9]{10}$/;
    if (!phonePattern.test(contactNumber)) {
        document.getElementById("contactNumberError").innerText = "Enter a valid 10-digit contact number.";
        isValid = false;
    }

    // If form is valid, display success message
    if (isValid) {
        document.getElementById("successMessage").innerText = "Booking successful!";
    }

    return isValid;  // Prevent form submission if not valid
}

// Function to clear previous error messages
function clearErrors() {
    document.getElementById("pickupError").innerText = "";
    document.getElementById("dropoffError").innerText = "";
    document.getElementById("pickupTimeError").innerText = "";
    document.getElementById("contactNumberError").innerText = "";
    document.getElementById("successMessage").innerText = "";
}
