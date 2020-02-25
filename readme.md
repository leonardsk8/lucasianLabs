#Prerequisiros
* Maven
* Git

* Intellij Idea (No obligatorio)

##Consideraciones
El proyecto utilizo una instancia de oracle Database desde AWS, las credenciales se encuentran en el archivo de 
configuración de hibernate, en cualquier caso desde este mismo archivo se puede configurar las credenciales para 
apuntar a otra base de datos, para este caso ejecutar el archivo DDL que se encuentra en la raiz del proyecto.

En caso de que se quiera cambiar el datasource se debe hacer mediante el archivo hibernate.cfg.xml de nuevo ejecutar el
archivo DDL con el código SQL

## Instalando dependencias en repositorio local
Se debe tener encuenta que el driver de oracle para conección a base de datos no esta disponible en el repositorio 
central y debe ser instalado en el repositorio local, el archivo .jar se encuentra en la raiz del proyecto para ser 
instalado: 
 1) Abrir una consola
 2) Ejecutar el siguiente comando, teniendo en cuenta reemplazar la ruta del jar  
  "mvn install:install-file -Dfile=LA\RUTA\DEL\JAR\ojdbc8.jar -DgroupId=com.oracle -DartifactId=ojdbc8 -Dversion=19.3 -Dpackaging=jar"
## Ejecutando el proyecto
 1) Desde una consola en la carpeta raiz del proyecto ejecutar:
  mvn exec:java -Dexec.mainClass="com.labs.lucasian.main.ApplicationRun".
  
### Entrada
El archivo llamado admin.csv(ubicado en raiz) es el documento en cuestión, puesto que se cargara y
validara los datos ingresados, este archivo puede ser modificado o remplazado 
(recordar mantener la ruta y el nombre exacto admin.csv).

### Proceso
Para el proceso se utilizo la libreria org.apache.commons la cual ayudo en el procesamiento del archivo CSV, e Hibernate
para la conección y persistencia de los datos. 

### Salida
En caso de que ocurra algún error en la validación de los datos, se creara un archivo 
txt llamado logErrores.txt (ubicado en la raiz del proyecto) especificando el registro y el error encontrado
Si no hubo ningun error se imprimira por consola el mensaje "PERSISTIENDO INFORMACIÓN" y terminara la ejecución
del programa, en el cual ya se podra consultar la tabla para verificar el guardado de los datos en la tabla.

#### IDE 
El IDE utilizado fue Intellij Idea el proyecto puede ser ejecutado desde este IDE o como se menciona mas arriba desde 
consola.
