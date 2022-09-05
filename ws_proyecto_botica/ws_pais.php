<?php
    include('conexion.php');
    $pdo=new Conexion();

    if($_SERVER['REQUEST_METHOD']=='GET'){
        $sql=$pdo->prepare('SELECT * FROM pais');
	    $sql->execute();
	    $sql->setFetchMode(PDO::FETCH_ASSOC);
	
	    echo json_encode($sql->fetchAll());

    }

?>