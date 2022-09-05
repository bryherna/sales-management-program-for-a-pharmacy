<?php
    include('conexion.php');
    $pdo=new Conexion();

    if($_SERVER['REQUEST_METHOD']=='GET'){

        if(isset($_GET['listar'])){
            $sql=$pdo->prepare("SELECT * FROM tipousuario");
        }
        if(isset($_GET['tipo_usuario_id'])){
            $idTu = $_GET['idTipoUsuario'];
            
            $sql=$pdo->prepare("CALL sp_retornarTipoUsuarioID('$idTu');");

        }

        
	    $sql->execute();
	    $sql->setFetchMode(PDO::FETCH_ASSOC);
	
	    echo json_encode($sql->fetchAll());
    }


?>