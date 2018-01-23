<html>
<style>
    body, input {
        font-family: Calibri, Arial;
        margin: 0px;
        padding: 0px;
    }

    #header h2 {
        color: white;
        background-color: #3275A8;
        height: 50px;
        padding: 5px 0 0 5px;
        font-size: 20px;
    }

    .datatable {
        margin-bottom: 5px;
        border: 1px solid #eee;
        border-collapse: collapse;
        width: 400px;
        max-width: 100%;
        font-family: Calibri
    }

    .datatable th {
        padding: 3px;
        border: 1px solid #888;
        height: 30px;
        background-color: #B2D487;
        text-align: center;
        vertical-align: middle;
        color: #444444
    }

    .datatable tr {
        border: 1px solid #888
    }

    .datatable tr.odd {
        background-color: #eee
    }

    .datatable td {
        padding: 2px;
        border: 1px solid #888
    }

    #content {
        padding 5px;
        margin: 5px;
        text-align: center
    }

    fieldset {
        width: 300px;
        padding: 5px;
        margin-bottom: 0px;
    }

    legend {
        font-weight: bold;
    }
</style>
<body>
<div id="header">
    <h2>Book Shop</h2>
</div>
<div id="content">
    <fieldset>
        <legend>Add Book</legend>
        <form name="book" action="add" method="post">
            Author : <input type="text" name="author"/><br/>
            Title: <input type="text" name="title"/><br/>
            Price: <input type="text" name="price"/><br/>
            <input type="submit" value="Save"/>
        </form>
    </fieldset>
    <br/>
    <table class="datatable">
        <tr>
            <th>Author</th>
            <th>Title</th>
            <th>Price</th>
        </tr>
    <#list model["books"] as book>
        <tr>
            <td>${book.bookId}
            <td>${book.author.name}</td>
            <td>${book.title}</td>
            <td>${book.price}</td>
            <td>
                <form name="buyBook" action="buy" method="post">
                    <input type="hidden" value=${book.bookId}/>
                    <input type="submit" value="Buy"/>
                </form>
            </td>
        </tr>
    </#list>
    </table>
</div>
</body>
</html>