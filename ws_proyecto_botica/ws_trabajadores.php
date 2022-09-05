<?php

    include('conexion.php');
    $pdo=new Conexion();

    if($_SERVER['REQUEST_METHOD']=='GET'){

        if(isset($_GET['listar'])){
            $sql=$pdo->prepare("CALL sp_listarTrabajadores();");
        }
        if(isset($_GET['trabajador_por_id'])){
            $idTra = $_GET['idTrabajador'];
            $sql=$pdo->prepare("CALL sp_retornarTrabajadorID('$idTra');");
        }

        if(isset($_GET['trabajador_por_dni'])){
            $perDni = $_GET['perDni'];
            $sql=$pdo->prepare("CALL sp_retornarTrabajadorDNI('$perDni');");
        }
        
	    $sql->execute();
	    $sql->setFetchMode(PDO::FETCH_ASSOC);
	
	    echo json_encode($sql->fetchAll());

    }

    if($_SERVER['REQUEST_METHOD']=='POST'){

        if(isset($_POST['insertar'])){
            $idTrabajador = $_POST['idTrabajador'];
            $idPersona = $_POST['idPersona'];
            $idCargoTrabajador = $_POST['idCargoTrabajador'];
            $idProfesion = $_POST['idProfesion'];
            $idRoles = $_POST['idRoles'];
            $idTurno = $_POST['idTurno'];
            $fechaInicio = $_POST['fechaInicio'];
            $sql=$pdo->prepare("CALL sp_AgregarTrabajador('$idTrabajador','$idPersona','$idCargoTrabajador',
            '$idProfesion','$idRoles','$idTurno','$fechaInicio');");
            $sql->execute();
		
		    echo "trabajador registrado correctamente";
        }

        if(isset($_POST['actualizar'])){
            $idTrabajador = $_POST['idTrabajador'];
            $idPersona = $_POST['idPersona'];
            $idCargoTrabajador = $_POST['idCargoTrabajador'];
            $idProfesion = $_POST['idProfesion'];
            $idRoles = $_POST['idRoles'];
            $idTurno = $_POST['idTurno'];
            $fechaInicio = $_POST['fechaInicio'];

            $sql=$pdo->prepare("CALL sp_ModificarTrabajador('$idTrabajador','$idPersona','$idCargoTrabajador',
            '$idProfesion','$idRoles','$idTurno','$fechaInicio');");
            $sql->execute();
		
		    echo "trabajador actualizado correctamente";
        }
        if(isset($_POST['eliminar'])){
            
            $id = $_POST['id'];

            $sql = $pdo->prepare("CALL sp_eliminarTrabajador('$id');");
            $sql->execute();
		
		    echo "trabajador eliminado correctamente";

        }

    }

?>