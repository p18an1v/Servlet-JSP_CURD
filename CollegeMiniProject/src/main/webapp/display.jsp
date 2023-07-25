<%@ page import="java.util.List" %>
<%@ page import="entity.Book" %>
<html>
<head>
    <!-- Add your CSS styles here -->
    <style>
        /* CSS styles for the table */
        table {
            border-collapse: collapse;
            width: 100%;
            background-color: #f2f2f2;
            animation: fadeIn 1s ease-in-out;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #ff7200;
            color: white;
        }
        @keyframes fadeIn {
            from {
                opacity: 0;
            }
            to {
                opacity: 1;
            }
        }
        /* CSS styles for the container */
        body {
            background-color: #FFFD75;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: #B2EA70;
            width: 500px;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            animation: slideIn 1s ease-in-out;
        }
        @keyframes slideIn {
            from {
                transform: translateX(-50px);
                opacity: 0;
            }
            to {
                transform: translateX(0);
                opacity: 1;
            }
        }
        h1 {
            text-align: center;
            color: #AA2EE6;
            margin-top: 0;
        }
        p {
            text-align: center;
            margin-top: 10px;
            color: #666;
        }
    </style>
</head>
<body>
    <% 
        List<Book> bookList = (List<Book>) request.getAttribute("bookList");
    %>
    <div class="container">
        <h1>Library Books</h1>
        <p>This table displays the list of books available in the library.</p>
        <table>
            <thead>
                <tr>
                    <th>Book ID</th>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Publication</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <% for (Book book : bookList) { %>
                    <tr>
                        <td><%= book.getBookId() %></td>
                        <td><%= book.getTitle() %></td>
                        <td><%= book.getAuthor() %></td>
                        <td><%= book.getPublication() %></td>
                        <td><%= book.isAvailable() ? "Available" : "Not Available" %></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
