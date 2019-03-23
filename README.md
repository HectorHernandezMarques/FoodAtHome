## Despliegue en Minikube

- Desplegar

    - `$ minkube start`
    - `$ kubectl create -f secret.yaml`
    - `$ kubectl create -f mysql.yaml`
    - `$ kubectl create -f internal.yaml`
    - `$ kubectl create -f food-at-home.yaml`

- Obtener ip y puerto para acceder a la web.

    - `$ minikube ip`
    - `$ kubectl get service hectorh-food-at-home-service --output='jsonpath={.spec.ports[0].nodePort}'`


- Eliminar

    - `$ minkube start`
    - `$ kubectl delete -f secret.yaml`
    - `$ kubectl delete -f mysql.yaml`
    - `$ kubectl delete -f internal.yaml`
    - `$ kubectl delete -f food-at-home.yaml`


# FoodAtHome

FoodAtHome es una web de pedidos de comida a domicilio, en la cual, podrás elaborar tu propio menú combinando los distintos productos disponibles y tenerlos rápidamente en casa para disfrutar de ellos
  
  [Video Demostracion](https://www.youtube.com/watch?v=FBojux0yztQ&feature=youtu.be)

# Funciones de la web
- Función Pública: Se podrá elegir un menú personalizado consultando la carta de productos y este, será enviado a la dirección que indique  el cliente, sin necesidad de loguearse, además el cliente podrá valorar el servicio y calidad de su pedido.
- Función Privada: el cliente, una vez haya iniciado sesión, podrá realizar su pedido, modificar su perfil (dirección de entrega, método de pago...). Además, podrá guardar su pedido como favorito. El empleado y el repartidor también se comunicarán, haciendole saber el pedido, la dirección de entrega y el importe que debe cobrar al Cliente.

# Entidades
- Cliente: el cliente puede realizar pedidos personalizados, dejar valoraciones dependiendo del servicio. Además, si accede con su cuenta podrá modificar su perfil, cambiar sus metodos de pago, direcciones, etc.
- Empleado: encargado de llevar a cabo los pedidos y entregarseos al repartidor para su posterior entrega.
- Repartidor: se encarga de llevar el pedido a la dirección facilitada por el Cliente y cobrarle.
- Opiniones: el cliente podrá dejar su valoración acerca del pedido, tanto de la calidad de un producto como la velocidad y estado de la entrega.

# Servicio Interno
- El cliente recibirá un correo con el desglose de su pedido, el importe y su numero de pedido. Opcionalmente podrá contestar a dicho email aportando su valoración como hemos mencionado antes.

# Componentes del grupo
- Daniel Montero García
  - dn.montero@alumnos.urjc.es
  - https://github.com/DanielMonteroGarcia
 
- Daniel Díaz Romo de Arce
  - d.diazro@alumnos.urjc.es
  
- Miguel Angel Huerta Rodriguez
  - ma.huerta@alumnos.urjc.es
  
# FASE 2

  # Navegación de la pagina web
  
   - Inicio: muestra la descripción de la empresa y lo que ofrece.
    ![imagen](https://github.com/pracDAD2018/FoodAtHome/blob/master/EjemploparaDAD/Screenshots/Inicio.png)
    
    
   - Ofertas: despliega un submenu con las ofertas disponibles. Pinchar en una oferta la añade al pedido.   
    ![imagen](https://github.com/pracDAD2018/FoodAtHome/blob/master/EjemploparaDAD/Screenshots/Ofertas.png)
    
    
   - Productos: lista de los productos disponibles para pedido.
   
   - Contacto: formulario de contacto para los clientes.   
    ![imagen](https://github.com/pracDAD2018/FoodAtHome/blob/master/EjemploparaDAD/Screenshots/Contacto.png)
    
    
   
   
   # Diagrama de navegacion
   
   ![imagen](https://github.com/pracDAD2018/FoodAtHome/blob/master/EjemploparaDAD/Screenshots/Diagrama%20de%20navegacion.png)
   
# FASE  3
  En la siguiente fase, mostraremos los cambios realizados en el diagrama de navegación de web y además un diagrama de clases y       templates. Pero, en primer lugar indicamos paso por paso las instrucciones necesarias para desplegar nuestra aplicación.
  
   -En primer lugar, una vez tenemos concluida nuestra interfaz web y funcionado en un servidor local, generamos los archivos .jar que en nuestro caso se engloban en dos, aplicación principal y servicio interno:
   
   Dentro de STS, elegimos "Run as" y seguidamente "Build Maven Project", esto nos depliega una nueva ventana.
   En la propia ventana en el apartado "Goals" escribiremos "Clean package", con lo que se nos genera el .jar en la carpeta "target"         (debemos repetir esta acción para el servicio interno.)       
    
   - En segundo lugar, una vez generados los .jar, podremos probar su correcto funcionamiento:    
       Abrimos la consola de nuestro sistema operativo (en nuestro caso, hemos usado 3 distintos ya que los encargados de la práctica           contábamos en nuestros equipos con Windows, Linux y MAC, respectivamente) con la siguiente instrucción en uno de nuestros casos 
        "**java -jar nombredelarchivo.jar**". Teniendo encuenta que previamente hemos instalado java y mysql, con los siguiente comandos:
       
        JAVA: **sudo apt-get install default-jre
              sudo apt-get install default-jdk**
        MYSQL: **sudo apt-get install mysql-server mysql-client
               sudo mysql_secure_installation **  
               
     - En tercer lugar y como paso más largo, crearemos todas las máquinas virtuales necesarias, en nuestro caso 6 : el Host y su correspondiente réplica, Database y su réplica, servicio interno y el balanceador.
     
     Para agilizar este proceso, hemos creado un archivo "Vagrantfile" en el cual hemos adjuntado todas las instrucciones necesarias      para montar la 6 máquinas de forma secuencial, sin tener que hacer una por una. Adjuntamos el archivo:
     
     https://drive.google.com/file/d/1SFCC8rlTEJWeC84kx6aeVcJF5FjuSktB/view?usp=sharing
     
     Con el comando "**Vagrant up**" conseguiremos ejecutar este archivo que creará las máquinas virtuales, cada una de ellas, ya sean  bases de datos o host tendrán una configuración distinta:
     
     ![imagen](https://github.com/pracDAD2018/FoodAtHome/blob/master/EjemploparaDAD/Screenshots/vagrant%20up.jpg)
     
        MAQUINAS VIRTUALES BASES DE DATOS
      
      Situandonos con vagrant ssh en la maquina virtual de la base de datos, en nuestro caso database, debemos dirigirnos al arxhivo de configuracion en la ruta /vagrant/etc/mysql. Una vez situados aqui y concediendo los permisos con sudo chmod +rwx my.cnf.
      Una vez concedidos los permisos, accedemos a my.cnf con el editor mediante el comando sudo nano my.cnf. Unicamente camnbiaremos la linea bind address, escribiendo la IP de la maquina virtual en cuestion (192.168.10.23)
      
     ![imagen](https://github.com/pracDAD2018/FoodAtHome/blob/master/EjemploparaDAD/Screenshots/BD%20config.png)
      
      
      Una vez guardados todos los cambios, arrancaremos el servicio mysql y accedemos a la consola. Vamos a crear un usuario, la propia base de datos y añadirle los permisos correspondientes. Procedemos a introducir los siguientes comandos:
        . create user root@192.168.10.23 identified by 'roto2';
        . create dataase foodathome;
        . grant all privileges on foodathome.* to root@192.168.10.23;
        . flush privileges;
      
        BASES DE DATOS MAESTRO-ESCLAVO
     
     Pars que la base de datos sea consistente, vamos a establecer una jerarquía de maestro-esclavo, de forma que una base de datos escuche a la otra. Las IPs correspondientes son 192.168.10.23 para el Maestro y 192.168.10.25 para el Esclavo.
     
      - Maestro
      
      Lo primero a realizar es modificar el fichero de configuracion, situado en /vagrant/etc/mysql. En el aplicamos todos los permisos y añadimos o descomentamos las siguientes lineas:
      
          . server-id = 1
          . sync_binlog = 1
          . log_bin = /var/log/mysql/mysql-bin.log
          . binlog_do_db = foodathome
     
     Una vez guardados los cambios reiniciamos el servicio mysql y volvemos a acceder a la consola. Ahora, vamos a crear un usuario esclavo y garantizarle todos los permisos. En la consola introducimos:
        - create user 'host'@'%' identified by 'roto2';
        - grant replication slave on *.* TO 'host'@'%' identified by 'roto2';
        - flush privileges;
        
     Ahora simplemente replicamos la BD introduciendo:
     
        - use foodathome;
        - flush tables woth read lock;
        - show master status;
        
     Mostrando lo siguiente:
     
     ![imagen](https://github.com/pracDAD2018/FoodAtHome/blob/master/EjemploparaDAD/Screenshots/Show%20master%20status.png)
     
     
      Ahora unicamente debemos guardar la BD con mysqldump-u root -p foodathome > foodathome.sql
      
        - Esclavo
        
        Similar a como realizamos el maestro, debemos añadir en my.cnf las siguientes lineas:
        
          . server-id = 2
          . relay-log = /var/log/mysql/mysql-relay-bin.log
          . log_bin = var/log/mysql/mysql-bin.log
          . binlog_do_db = foodathome
          
        Ahora debemos identificar el usuario host. En la consola de mysql introducimos:
        
           - create user 'host'@'%' identified by 'roto2';
           - grant replication slave on *.* TO 'host'%' identified by 'roto2';
           -  flush privileges;
           
        Por ultimo configuramos la máquina que actua como esclavo (importante recoger en el maestro su posicion, en este caso 927):
        
           -  change master to master_host = '192.168.10.23',
           -  master_user = 'slave',
           -  master_password = 'roto2',
           -  master_log_pos = '927',
           -  master_log_file = 'mysql-bin.000001',
           
        HOST Y REPLICA DEL HOST
        
        Debemos acceder a ambas introduciendo vagrant ssh. Simplemento debemos instalar el cliente de mysql con sudo apt-get mysql cliente y a continuacion ejecutar el jar con todas las opciones de configuracion.
        
        BALANCEADOR DEL HOST
        
        - Primero, instalamos el PPA para poder utilizar HAProxy con add-apt.repository ppa:vbernat/haproxy-1.5
        - A continuacion instalamos haproxy apt-get install haproxy
        
        Debido a que nuestros servidores emplean certificado, debemos general el certificado SSL:
        
        - sudo mkdir /etc/ssl/xip.io
        - cd xip.io
        - sudo openssl genrsa -out xip.io.key 1024
        - sudo openssl req -new -key xip.io.key \-out xip.io.csr
        
        Debemos rellenar el formulario y a continuacion crear un segundo certificado. Ahora que tenemos los certificados podemos pasar a configurar el HAProxy.
        
        con sudo nano haproxy.cfg nos debe quedar un archivo de esta forma:
        
        ![imagen](https://github.com/pracDAD2018/FoodAtHome/blob/master/EjemploparaDAD/Screenshots/haproxycfg.png)
        
        Por ultimo ejecutamos sudo service haproxy restart para reiniciar el servicio y a continuacion sudo service haproxy start.
     
     -  Diagrama de clases y templates                  
                            
       ![imagen](https://github.com/pracDAD2018/FoodAtHome/blob/master/EjemploparaDAD/Screenshots/diagrama%20de%20clases%20y%20tamplates.jpg)
       
       
      - Diagrama de navegacion actualizado
      
      ![imagen](https://github.com/pracDAD2018/FoodAtHome/blob/master/EjemploparaDAD/Screenshots/diagrama%20de%20navegacion.JPG)
        
          
  

   
 
