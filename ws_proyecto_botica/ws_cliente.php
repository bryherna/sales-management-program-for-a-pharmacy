<?php
    include('conexion.php');
    $pdo=new Conexion();

    if($_SERVER['REQUEST_METHOD']=='GET'){
        if(isset($_GET['buscarClienteDni'])){
            $dni = $_GET['dni'];
            $sql=$pdo->prepare("CALL sp_buscarClienteDNI('$dni');");


        }
        if(isset($_GET['listaClientesGeneral'])){
            $sql=$pdo->prepare("CALL spListaClientesGeneral();");

        }
        $sql->execute();
        $sql->setFetchMode(PDO::FETCH_ASSOC);
        echo json_encode($sql->fetchAll());

    }

    if ($_SERVER['REQUEST_METHOD']=='POST'){
        if(isset($_POST['insertar'])){
            $idCliente = $_POST['idCliente'];
            $idPersona = $_POST['idPersona'];
            $fechaInicio = $_POST['fechaInicio'];

            $sql=$pdo->prepare("CALL sp_AgregarCliente('$idCliente','$idPersona','$fechaInicio');");
            $sql->execute();
		
		    echo "cliente registrado correctamente";
        }
    }

    


?>