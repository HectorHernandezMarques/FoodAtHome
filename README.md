# FoodAtHome

FoodAtHome es una web de pedidos de comida a domicilio, en la cual, podrás elaborar tu propio menú combinando los distintos productos disponibles y tenerlos rápidamente en casa para disfrutar de ellos.

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
     
        BBDD: 
     
     
     
     
    
  

   
 
