<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Hotel Service Portal</title>
<style>
*{box-sizing:border-box;margin:0;padding:0}
body{font-family:Arial,Helvetica,sans-serif;background:linear-gradient(135deg,#f5f7fa,#e8edf3);min-height:100vh;color:#222}
header{background:#1f2937;color:white;padding:28px 20px;text-align:center}
header h1{font-size:32px;margin-bottom:8px}
header p{color:#d1d5db}
.container{width:90%;max-width:1000px;margin:40px auto}
.intro{text-align:center;margin-bottom:30px}
.intro h2{color:#1f2937;margin-bottom:10px}
.intro p{color:#6b7280}
.services{display:grid;grid-template-columns:repeat(auto-fit,minmax(200px,1fr));gap:20px;margin-bottom:35px}
.service-card{background:white;border-radius:12px;padding:25px;text-align:center;box-shadow:0 5px 15px rgba(0,0,0,.08);transition:transform .2s}
.service-card:hover{transform:translateY(-5px)}
.service-card h3{margin-bottom:10px;color:#111827}
.service-card p{color:#6b7280;font-size:14px}
.form-container{background:white;padding:35px;border-radius:12px;box-shadow:0 5px 20px rgba(0,0,0,.1)}
.form-container h2{margin-bottom:25px;color:#1f2937}
label{display:block;margin-bottom:7px;font-weight:bold}
input,select{width:100%;padding:13px;margin-bottom:20px;border:1px solid #d1d5db;border-radius:7px;font-size:15px}
input:focus,select:focus{outline:none;border-color:#2563eb}
button{width:100%;padding:14px;border:none;border-radius:7px;background:#2563eb;color:white;font-size:16px;font-weight:bold;cursor:pointer}
button:hover{background:#1d4ed8}
footer{text-align:center;padding:25px;color:#6b7280;font-size:14px}
</style>
</head>
<body>
<header>
<h1>Hotel Service Portal</h1>
<p>Comfort, convenience and quality service</p>
</header>

<div class="container">
<div class="intro">
<h2>Welcome to Our Hotel</h2>
<p>Select a service and submit your request.</p>
</div>

<div class="services">
<div class="service-card"><h3>Room Booking</h3><p>Request a comfortable room for your stay.</p></div>
<div class="service-card"><h3>Room Service</h3><p>Order food and other services directly to your room.</p></div>
<div class="service-card"><h3>Housekeeping</h3><p>Request room cleaning and housekeeping assistance.</p></div>
<div class="service-card"><h3>Restaurant Reservation</h3><p>Reserve a table at our hotel restaurant.</p></div>
</div>

<div class="form-container">
<h2>Submit Hotel Service Request</h2>
<form action="service-request" method="post">
<label for="service">Select Service</label>
<select id="service" name="service" required>
<option value="">-- Select a Service --</option>
<option value="Room Booking">Room Booking</option>
<option value="Room Service">Room Service</option>
<option value="Housekeeping">Housekeeping</option>
<option value="Restaurant Reservation">Restaurant Reservation</option>
</select>

<label for="name">Customer Name</label>
<input type="text" id="name" name="name" placeholder="Enter your name" required>

<label for="contact">Contact Number</label>
<input type="tel" id="contact" name="contact" placeholder="Enter your 10-digit contact number" pattern="[0-9]{10}" required>

<button type="submit">Submit Service Request</button>
</form>
</div>
</div>

<footer>Hotel Service Portal &copy; 2026</footer>
</body>
</html>
