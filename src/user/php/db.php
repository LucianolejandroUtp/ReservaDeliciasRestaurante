<?php
// Conectar a la base de datos
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "delicias_rest";

$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: ". $conn->connect_error);
}

// Consulta SQL para seleccionar los datos de la tabla menu_items
$sql = "SELECT * FROM menu_items";
$result = $conn->query($sql);

// Crear un array para almacenar los datos, organizados por categoría
$menu_items = array(
    'entradas' => array(),
    'platos_fuertes' => array(),
    'postres' => array(),
    'bebidas' => array()
);

if ($result->num_rows > 0) {
    while($row = $result->fetch_assoc()) {
        $category = $row['category']; // asumo que la columna se llama "category"
        $menu_items[$category][] = $row;
    }
}

$conn->close();

?>