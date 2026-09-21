<%@ page import="com.malar.MalarMart.model.Product" %>
<%@ page import="com.malar.MalarMart.service.ProductService" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <title>MalarMart - Seller Products</title>
</head>
<body>

    <h1>My Products</h1>

    <%
        long sellerId = 1;

        ProductService productService = new ProductService();
        List<Product> products = productService.getProductsBySeller(sellerId);
    %>

    <% if (products.isEmpty()) { %>

        <p>No products found.</p>

    <% } else { %>

        <table border="1" cellpadding="10">

            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Category</th>
                <th>Action</th>
            </tr>

            <% for (Product product : products) { %>

                <tr>
                    <td><%= product.getId() %></td>
                    <td><%= product.getName() %></td>
                    <td><%= product.getDescription() %></td>
                    <td><%= product.getPrice() %></td>
                    <td><%= product.getQuantity() %></td>
                    <td><%= product.getCategory() %></td>

                   <td>

    <form action="edit-product.jsp" method="get" style="display:inline;">
        <input type="hidden"
               name="productId"
               value="<%= product.getId() %>">

        <button type="submit">Edit</button>
    </form>

    <form action="delete-product" method="post" style="display:inline;">
        <input type="hidden"
               name="productId"
               value="<%= product.getId() %>">

        <button type="submit">Delete</button>
    </form>

</td>
                </tr>

            <% } %>

        </table>

    <% } %>

</body>
</html>