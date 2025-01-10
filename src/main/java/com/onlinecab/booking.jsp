<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cab Booking</title>
</head>
<body>
    <h1>Book a Cab</h1>
    <form action="book" method="POST">
        <label for="pickupLocation">Pickup Location:</label>
        <input type="text" id="pickupLocation" name="pickupLocation" required><br>

        <label for="dropLocation">Drop Location:</label>
        <input type="text" id="dropLocation" name="dropLocation" required><br>

        <label for="cabType">Cab Type:</label>
        <select id="cabType" name="cabType" required>
            <option value="Sedan">Sedan</option>
            <option value="SUV">SUV</option>
            <option value="Mini">Mini</option>
        </select><br>

        <label for="bookingDate">Booking Date:</label>
        <input type="date" id="bookingDate" name="bookingDate" required><br>

        <button type="submit">Book Cab</button>
    </form>

    <p><a href="bookingDetails.jsp">View your bookings</a></p>
</body>
</html>
