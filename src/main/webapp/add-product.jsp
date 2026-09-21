<!DOCTYPE html>
<html>
<head>
    <title>MalarMart - Add Product</title>
</head>
<body>

    <h1>Add Product</h1>

    <form action="add-product" method="post">

        <label>Product Name:</label><br>
        <input type="text" name="name" required><br><br>

        <label>Description:</label><br>
        <textarea name="description" required></textarea><br><br>

        <label>Price:</label><br>
        <input type="number" name="price" step="0.01" required><br><br>

        <label>Quantity:</label><br>
        <input type="number" name="quantity" min="1" required><br><br>

        <label>Category:</label><br>
        <select name="category" required>
            <option value="Electronics">Electronics</option>
            <option value="Fashion">Fashion</option>
            <option value="Home">Home</option>
            <option value="Beauty">Beauty</option>
        </select><br><br>

        <button type="submit">Add Product</button>

    </form>

</body>
</html>