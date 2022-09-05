<?php

    include('conexion.php');
    $pdo=new Conexion();

    if($_SERVER['REQUEST_METHOD']=='GET'){

        if(isset($_GET['roles_trabajador'])){
            $rol = $_GET['idRol'];
            $sql=$pdo->prepare("CALL sp_retornarRolesTrabajador('$rol');");

        }

        if(isset($_GET['listar'])){
            $sql = $pdo->prepare("SELECT * FROM roles");

        }
        $sql->execute();
	    $sql->setFetchMode(PDO::FETCH_ASSOC);
	
	    echo json_encode($sql->fetchAll());
    }



?>