<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Booking Details</title>
</head>
<body>
    <h1>Your Bookings</h1>
    <p>Here are your current bookings:</p>

    <!-- Example static booking details (In a real application, you would fetch these from a database) -->
    <table border="1">
        <tr>
            <th>Pickup Location</th>
            <th>Drop Location</th>
            <th>Cab Type</th>
            <th>Booking Date</th>
        </tr>
        <tr>
            <td>New York</td>
            <td>Boston</td>
            <td>SUV</td>
            <td>2025-01-15</td>
        </tr>
    </table>

    <p><a href="booking.jsp">Book another cab</a></p>
    <p><a href="logout.jsp">Logout</a></p>
</body>
</html>
