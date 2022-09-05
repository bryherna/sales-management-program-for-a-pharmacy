<?php
    include('conexion.php');
    $pdo=new Conexion();
    
    if($_SERVER['REQUEST_METHOD']=='GET'){
        if(isset($_GET['listar'])){
            $sql=$pdo->prepare("SELECT * FROM producto");
        }

        if(isset($_GET['producto_por_id'])){
            $idPro = $_GET['idPro'];

            $sql=$pdo->prepare("CALL sp_retornarProductoPorID('$idPro');");

        }
        if(isset($_GET['reporte_productos'])){
            $sql=$pdo->prepare(" CALL sp_reporteProductos(); ");
        }

        if(isset($_GET['producto_por_nombre'])){
            $nom = $_GET['nomPro'];
            $sql=$pdo->prepare("CALL sp_retornarProductoPorNombre('$nom');");

        }
        $sql->execute();
	    $sql->setFetchMode(PDO::FETCH_ASSOC);
	
	    echo json_encode($sql->fetchAll());
    }

    if($_SERVER['REQUEST_METHOD']=='POST'){
        if(isset($_POST['insertar'])){
            $idProducto = $_POST['idProducto'];
            $idPresentacion = $_POST['idPresentacion'];
            $idLaboratorio = $_POST['idLaboratorio'];
            $nomProducto = $_POST['nomProducto'];
            $precioVenta = $_POST['precioVenta'];
            $descripcion = $_POST['descripcion'];
            $stock = $_POST['stock'];
            $caducidad = $_POST['caducidad'];
            $lote = $_POST['lote'];
            $sql=$pdo->prepare("CALL sp_registrarProducto('$idProducto','$idPresentacion','$idLaboratorio',
            '$nomProducto','$precioVenta','$descripcion','$stock','$caducidad','$lote');");
            $sql->execute();
		
		    echo "producto registrado correctamente";
        }

        if(isset($_POST['actualizar'])){
            $idProducto = $_POST['idProducto'];
            $idPresentacion = $_POST['idPresentacion'];
            $idLaboratorio = $_POST['idLaboratorio'];
            $nomProducto = $_POST['nomProducto'];
            $precioVenta = $_POST['precioVenta'];
            $descripcion = $_POST['descripcion'];
            $stock = $_POST['stock'];
            $caducidad = $_POST['caducidad'];
            $lote = $_POST['lote'];
            $sql=$pdo->prepare("CALL sp_modificarProducto('$idProducto','$idPresentacion','$idLaboratorio',
            '$nomProducto','$precioVenta','$descripcion','$stock','$caducidad','$lote');");
            $sql->execute();
		
		    echo "producto modificado correctamente";


        }
        if(isset($_POST['eliminar'])){
            $idProducto = $_POST['idPro'];

            $sql = $pdo->prepare("CALL spEliminarProducto('$idProducto');");
            $sql->execute();

            echo "producto eliminado correctamente";

        }

    }


?>