<?php

class Conexion extends PDO{
	private $dbhost='localhost';
	private $bd='bd_boticacedhyfarma';
	private $usuario='root';
	private $clave='';
	
	public function __construct(){
		
		try{
			
			parent::__construct('mysql:host='.$this->dbhost.';dbname='.$this->bd.';charset=utf8',$this->usuario,$this->clave);
			
		}catch(PDOException $e){
			echo 'Error '.$e->getMessage();
		}
		
		
	}
	
}

?>