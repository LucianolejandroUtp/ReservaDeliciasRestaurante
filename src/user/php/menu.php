<?php
header('Content-Type: application/json');

$servername = "localhost";
$username = "root";
$password = "";
$dbname = "delicias_rest";

// Crear conexión
$conn = new mysqli($servername, $username, $password, $dbname);

// Verificar conexión
if ($conn->connect_error) {
    die("Conexión fallida: " . $conn->connect_error);
}

$sql = "SELECT category, name, price, description FROM menu";
$result = $conn->query($sql);

$menu = [];

if ($result->num_rows > 0) {
    while($row = $result->fetch_assoc()) {
        $category = strtolower(str_replace(' ', '-', $row['category']));
        if (!isset($menu[$category])) {
            $menu[$category] = [];
        }
        $menu[$category][] = [
            'name' => $row['name'],
            'price' => $row['price'],
            'description' => $row['description']
        ];
    }
}

$conn->close();

echo json_encode($menu);
?>
