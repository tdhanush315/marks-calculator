
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Marks Calculator</title>
</head>
<body>
    <h2>Student Marks and Grade Calculator</h2>

    <form action="calculate" method="post">
        <label>Subject 1:</label>
        <input type="number" name="m1"
               min="0" max="100" step="1" required>
        <br><br>

        <label>Subject 2:</label>
        <input type="number" name="m2"
               min="0" max="100" step="1" required>
        <br><br>

        <label>Subject 3:</label>
        <input type="number" name="m3"
               min="0" max="100" step="1" required>
        <br><br>

        <button type="submit">Calculate Grade</button>
    </form>
</body>
</html>
