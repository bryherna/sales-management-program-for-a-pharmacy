<?php
    include('conexion.php');
    $pdo=new Conexion();

    if($_SERVER['REQUEST_METHOD']=='GET'){
        if(isset($_GET['maximo_id_venta'])){
           

            $sql=$pdo->prepare("SELECT MAX(idVenta) as mayorID from venta");
        }
        $sql->execute();
	    $sql->setFetchMode(PDO::FETCH_ASSOC);
	
	    echo json_encode($sql->fetchAll());

    }
    if($_SERVER['REQUEST_METHOD']=='POST'){
        if(isset($_POST['insertar'])){
            $idVenta = $_POST['idVenta'];
            $idCliente = $_POST['idCliente'];
            $idTrabajador = $_POST['idTrabajador'];
            $idComprobanteVenta = $_POST['idComprobanteVenta'];
            $totalVenta = $_POST['totalVenta'];
            $fechaVenta = $_POST['fechaVenta'];
            $idModoPago = $_POST['idModoPago'];

            $sql=$pdo->prepare("CALL sp_AgregarVenta('$idVenta','$idCliente','$idTrabajador',
            '$idComprobanteVenta','$totalVenta','$fechaVenta','$idModoPago');");
            $sql->execute();
		
		    echo "venta registrado correctamente";
        }
    }



?>