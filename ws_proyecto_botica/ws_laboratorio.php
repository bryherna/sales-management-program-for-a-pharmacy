<?php

include('conexion.php');
$pdo=new Conexion();
if($_SERVER['REQUEST_METHOD']=='GET'){

    if(isset($_GET['listar'])){
        $sql=$pdo->prepare("SELECT * FROM laboratorio");
    }


    
    $sql->execute();
    $sql->setFetchMode(PDO::FETCH_ASSOC);

    echo json_encode($sql->fetchAll());
}



?>