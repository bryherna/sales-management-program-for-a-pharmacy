<?php
    include('conexion.php');
    $pdo=new Conexion();

    if($_SERVER['REQUEST_METHOD']=='GET'){

    }
    if($_SERVER['REQUEST_METHOD']=='POST'){
        if(isset($_POST['insertar'])){
            $idDetalleVenta = $_POST['idDetalleVenta'];
            $idProducto = $_POST['idProducto'];
            $idVenta = $_POST['idVenta'];
            $precioProducto = $_POST['precioProducto'];
            $cantidad = $_POST['cantidad'];

            $sql=$pdo->prepare("CALL sp_AgregarDetalleVenta('$idDetalleVenta','$idProducto','$idVenta',
            '$precioProducto','$cantidad');");
            $sql->execute();
		
		    echo "detalle venta registrado correctamente";

        }
    }

?>