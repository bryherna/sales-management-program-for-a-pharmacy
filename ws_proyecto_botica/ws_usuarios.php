<?php
    include('conexion.php');
    $pdo=new Conexion();


    if($_SERVER['REQUEST_METHOD']=='GET'){

        if(isset($_GET['logearse'])){
            $user = $_GET["nomUsuario"];
            $pass = $_GET["passwordUsuario"];
            $sql=$pdo->prepare("CALL sp_logearse('$user','$pass');");
        }

        if(isset($_GET['listar'])){
            $sql=$pdo->prepare("CALL sp_listarUsuarios(); ");
        }

        if(isset($_GET['listarPorIdUsuario'])){
            $idUsuario = $_GET['idUsu'];

            $sql=$pdo->prepare("CALL spListarDatosUsuariosPorId('$idUsuario'); ");

        }

            $sql->execute();
	        $sql->setFetchMode(PDO::FETCH_ASSOC);
	        echo json_encode($sql->fetchAll());

        

    }

    

    if ($_SERVER['REQUEST_METHOD']=='POST'){
        if(isset($_POST['insertar'])){

            $idUsuario =$_POST['idUsuario'];
            $nombreUsuario = $_POST['nombreUsuario'];
            $idTipoUsuario  = $_POST['idTipoUsuario'];
            $idTrabajador = $_POST['idTrabajador'];
            $password = $_POST['password_usuario'];
            $estado = $_POST['estadoUsuario'];


            $sql=$pdo->prepare("CALL sp_AgregarUsuario('$idUsuario','$nombreUsuario','$idTipoUsuario','$idTrabajador','$password','$estado');");

            $sql->execute();
		
		    echo "usuario registrado correctamente";

        }

        if(isset($_POST['actualizar'])){
            $idUsuario =$_POST['idUsuario'];
            $nombreUsuario = $_POST['nombreUsuario'];
            $idTipoUsuario  = $_POST['idTipoUsuario'];
            $idTrabajador = $_POST['idTrabajador'];
            $password = $_POST['password_usuario'];
            $estado = $_POST['estadoUsuario'];

            $sql=$pdo->prepare("CALL sp_ActualizarUsuario('$idUsuario','$nombreUsuario','$idTipoUsuario','$idTrabajador','$password','$estado');");
            $sql->execute();
		
		    echo "usuario actualizado correctamente";
        }

        if(isset($_POST['eliminar'])){
            
            $id = $_POST['id'];

            $sql = $pdo->prepare("CALL sp_EliminarUsuario('$id');");
            $sql->execute();
		
		    echo "usuario eliminado correctamente";

        }

        if(isset($_POST['valida_login'])){
            $user = $_POST["nomUsuario"];
            $pass = $_POST["passwordUsuario"];
            $sql=$pdo->prepare("CALL sp_logearse('$user','$pass');");
            $sql->execute();
            $sql->setFetchMode(PDO::FETCH_ASSOC);
			$num = $sql->rowCount();
			if($num >=1){
				echo json_encode($sql->fetchAll());
			}
        }
    }


?>