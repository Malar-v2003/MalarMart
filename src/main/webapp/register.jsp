<!DOCTYPE html>
<html>
<head>
    <title>MalarMart - Register</title>
</head>
<body>

    <h1>MalarMart Registration</h1>

    <form action="register" method="post">

        <label>Name:</label><br>
        <input type="text" name="name" required><br><br>

        <label>Email:</label><br>
        <input type="email" name="email" required><br><br>

        <label>Password:</label><br>
        <input type="password" name="password" required><br><br>

        <label>Role:</label><br>
        <select name="role" required>
            <option value="BUYER">Buyer</option>
            <option value="SELLER">Seller</option>
        </select><br><br>

        <button type="submit">Register</button>

    </form>

    <br>

    <a href="login.jsp">Already have an account? Login</a>

</body>
</html>