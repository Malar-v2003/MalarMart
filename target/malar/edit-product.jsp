<%@ page import="com.malar.MalarMart.model.Product" %>
<%@ page import="com.malar.MalarMart.service.ProductService" %>

<%
    long productId = Long.parseLong(request.getParameter("productId"));

    ProductService productService = new ProductService();

    // Temporary seller ID for testing
    long sellerId = 1;

    Product product = null;

    for (Product p : productService.getProductsBySeller(sellerId)) {
        if (p.getId() == productId) {
            product = p;
            break;
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>MalarMart - Edit Product</title>
</head>

<body>

<h1>Edit Product</h1>

<% if (product == null) { %>

    <p>Product not found.</p>

<% } else { %>

<form action="edit-product" method="post">

    <input type="hidden"
           name="productId"
           value="<%= product.getId() %>">

    <label>Product Name:</label><br>
    <input type="text"
           name="name"
           value="<%= product.getName() %>"
           required>
    <br><br>

    <label>Description:</label><br>
    <textarea name="description"
              required><%= product.getDescription() %></textarea>
    <br><br>

    <label>Price:</label><br>
    <input type="number"
           name="price"
           step="0.01"
           value="<%= product.getPrice() %>"
           required>
    <br><br>

    <label>Quantity:</label><br>
    <input type="number"
           name="quantity"
           min="1"
           value="<%= product.getQuantity() %>"
           required>
    <br><br>

    <label>Category:</label><br>
    <select name="category" required>

        <option value="Electronics"
            <%= "Electronics".equals(product.getCategory()) ? "selected" : "" %>>
            Electronics
        </option>

        <option value="Fashion"
            <%= "Fashion".equals(product.getCategory()) ? "selected" : "" %>>
            Fashion
        </option>

        <option value="Home"
            <%= "Home".equals(product.getCategory()) ? "selected" : "" %>>
            Home
        </option>

        <option value="Beauty"
            <%= "Beauty".equals(product.getCategory()) ? "selected" : "" %>>
            Beauty
        </option>

    </select>
    <br><br>

    <button type="submit">Update Product</button>

</form>

<% } %>

</body>
</html>