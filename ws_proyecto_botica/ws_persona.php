<?php
    include('conexion.php');
    $pdo=new Conexion();

    if($_SERVER['REQUEST_METHOD']=='GET'){

        if(isset($_GET['persona_id_trabajador'])){
            $idTra = $_GET['idTrabajador'];
            
            $sql=$pdo->prepare("CALL sp_retornarPersonaIDTrabajador('$idTra');");

        }

        if(isset($_GET['maximo_id_persona'])){

            $sql=$pdo->prepare("SELECT MAX(idPersona) as mayorID from persona");
        }

        $sql->execute();
	    $sql->setFetchMode(PDO::FETCH_ASSOC);
	
	    echo json_encode($sql->fetchAll());
    }

    if($_SERVER['REQUEST_METHOD']=='POST'){
        if(isset($_POST['insertar'])){
            $idPersona = $_POST['idPersona'];
            $idPais  = $_POST['idPais'];
            $perApellidosNombres  = $_POST['perApellidosNombres'];
            $perFechaNac  = $_POST['perFechaNac'];
            $perDni  = $_POST['perDni'];
            $perEstado  = $_POST['perEstado'];
            $perTelefono  = $_POST['perTelefono'];
            $perDireccion  = $_POST['perDireccion'];
            $perSexo  = $_POST['perSexo'];
            $perCorreo  = $_POST['perCorreo'];


            $sql=$pdo->prepare("CALL sp_AgregarPersona('$idPersona','$idPais','$perApellidosNombres','$perFechaNac','$perDni','$perEstado','$perTelefono','$perDireccion',
        '$perSexo','$perCorreo');");

            $sql->execute();
		
		    echo "persona registrado correctamente";
            
        }

        if(isset($_POST['actualizar'])){
            $idPersona = $_POST['idPersona'];
            $idPais  = $_POST['idPais'];
            $perApellidosNombres  = $_POST['perApellidosNombres'];
            $perFechaNac  = $_POST['perFechaNac'];
            $perDni  = $_POST['perDni'];
            $perEstado  = $_POST['perEstado'];
            $perTelefono  = $_POST['perTelefono'];
            $perDireccion  = $_POST['perDireccion'];
            $perSexo  = $_POST['perSexo'];
            $perCorreo  = $_POST['perCorreo'];

            $sql=$pdo->prepare("CALL sp_ModificarPersona('$idPersona','$idPais','$perApellidosNombres','$perFechaNac','$perDni','$perEstado','$perTelefono','$perDireccion',
            '$perSexo','$perCorreo');");

            $sql->execute();
		
		    echo "persona actualizado correctamente";
        }

    }


?>