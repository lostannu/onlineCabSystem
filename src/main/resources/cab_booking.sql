-- Users table
CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(15),
    role ENUM('customer', 'driver', 'admin') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Cabs table
CREATE TABLE cabs (
    cab_id INT PRIMARY KEY AUTO_INCREMENT,
    license_plate VARCHAR(20) UNIQUE NOT NULL,
    cab_type ENUM('sedan', 'suv', 'hatchback', 'mini') NOT NULL,
    capacity INT NOT NULL,
    status ENUM('available', 'busy', 'maintenance') NOT NULL
);

-- Drivers table
CREATE TABLE drivers (
    driver_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    cab_id INT,
    license_number VARCHAR(50) UNIQUE NOT NULL,
    rating DECIMAL(3,2) DEFAULT 0,
    status ENUM('active', 'inactive') NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (cab_id) REFERENCES cabs(cab_id)
);

-- Bookings table
CREATE TABLE bookings (
    booking_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT,
    driver_id INT,
    cab_id INT,
    pickup_location VARCHAR(255) NOT NULL,
    dropoff_location VARCHAR(255) NOT NULL,
    pickup_time DATETIME NOT NULL,
    dropoff_time DATETIME,
    status ENUM('pending', 'completed', 'canceled') NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES users(user_id),
    FOREIGN KEY (driver_id) REFERENCES drivers(driver_id),
    FOREIGN KEY (cab_id) REFERENCES cabs(cab_id)
);

-- Payments table
CREATE TABLE payments (
    payment_id INT PRIMARY KEY AUTO_INCREMENT,
    booking_id INT,
    amount DECIMAL(10,2) NOT NULL,
    payment_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status ENUM('paid', 'failed', 'pending') NOT NULL,
    method ENUM('credit_card', 'debit_card', 'cash', 'digital_wallet') NOT NULL,
    FOREIGN KEY (booking_id) REFERENCES bookings(booking_id)
);

-- Feedback table (optional)
CREATE TABLE feedback (
    feedback_id INT PRIMARY KEY AUTO_INCREMENT,
    booking_id INT,
    customer_id INT,
    driver_id INT,
    rating INT CHECK (rating >= 1 AND rating <= 5),
    comments TEXT,
    feedback_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (booking_id) REFERENCES bookings(booking_id),
    FOREIGN KEY (customer_id) REFERENCES users(user_id),
    FOREIGN KEY (driver_id) REFERENCES drivers(driver_id)
);
