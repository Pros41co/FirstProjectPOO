# PRIMER PROYECTO DE POO: FERIA EMPRESARIAL Y HERENCIA CON EJEMPLO DE PARQUEADERO

## Propósito.

El proyecto presentado a continuación, tiene como objetivo afianzar las bases de la Programación Orientada a Objetos, mediante la construcción de un sistema que permita administrar a los usuarios, empresas y stands en una ferie empresarial. Para este objetivo,
se construyeron las clases pertinentes, de tal manera que éstas puedan interactuar entre sí, a través de sus diferentes métodos.

### Clases Asignadas.

Para el proyecto, se manejan tres objetos fundamentales, que constituyen el pilar del modelo de negocio:
 * Clase Empresa
 * Clase Stand
 * Clase Visitante

Sin embargo, también se crearon clases adicionales que, en conjunto con las principales, forman todo el esquema de negocio y da funcionalidad a las interacciones entre las clases principales
* Clase Comentario
* Clase AdministratorMenu
* Clase UserMenu
Estas últimas clases son el nexo entre las anteriores, y son las encargadas de desplegar los menús mediante los cuales el usuario final interactúa a través de consola.
Finalmente, se tiene la clase Consultor, cuya responsabilidad radica en almacenar los diferentes objetos en memoria, mientras el programa se encuentra activo.
* Clase Consultor

## Clases

* Clase Empresa

  La clase empresa es la encargada de moldear a todas las empresas que el sistema maneja. Es capaz de almacenar el nombre de cada empresa, su identificación y correo. Mediante el uso de getters y setters dichos parámetros pueden ser modificados.

* Clase Stand

  La clase Stand representa el sitio en donde cada empresa debe ubicarse en la feria, contiene, por tanto, un identificador, una ubicación, un tamaño y un nombre de la empresa que lo contiene.
  Es importante aclarar que, para cada empresa, es necesario un objeto Stand, pues de otro modo dicha empresa no podría estar en la Feria.

* Clase Visitante
  Clase encargada de representar a cada persona que visita la feria empresarial, contiene el nombre de la persona, identificación y correo electrónico.

* Clase Comentario
  Clase almacenada mediante una lista dentro de la clase Stand. Representa cada comentario que dejan en un Stand, almacenando un texto y una calificación.

* Clase AdministratorMenu
  Clase encargada de consultar visitantes, empresas y stands. Es capaz de crear visitantes y empresas, así como de consultar stands vacíos, ocupados o todos. Genera reportes y es la clase principal en la gestión empresarial.

* Clase UserMenu
  Es la clase destinada para ser usada por el usuario, mediante el cual éste puede visitar stands, dejar comentarios, registrarse y logearse.

* Clase Consultor
  Clase que tiene funciones similares a una base de datos, encargado de generar consultas de todas los visitantes, empresas y stands, editarlos y modificarlos, así como de indicar si un Stand está disponible o no.

## How to use

Inicialmente se inicia el programa con tres opciones.

1. Panel de usuario
2. Panel de Administrador
3. Salir del programa
Se debe seleccionar, colocando cualquiera de los números que indica el programa, en este caso, un número del 1 al 3.

### Panel de usuario.
El panel de usuario presenta ciertas opciones y, aunque parezca contraintuitivo los números disponibles para elegir, es debido a que muchas opciones se habilitan después de que un usuario se haya logeado.

- Logeo

Para usar el panel de usuario, cada persona debe estar registrada. Dicho registro se puede hacer desde este mismo panel o desde el panel de administración.
Una vez registrada, el usuario puede logearse con su número de identificación, de tal manera que se habilitan las opciones para visitar Stands y posteriormente dejar los comentarios que éste desee.

[Nota] El programa presenta fallas cuando se colocan carácteres especiales como el punto.

- Dejar comentarios

Dejar los comentarios simplemente consta de colocar un texto y posteriormente una calificación numérica. Cada comentario es anónimo, es decir, no cuenta con una relación hacia el usuario que ha escrito el comentario.

### Panel de Administrador

Es capaz de crear empresas y crear usuarios, de la misma manera que en el registro de usuarios del panel anterior.
De manera adicional, es capaz de mostrar dos submenús para la gestión de empresas y visitantes.

### ¿Cómo consultar todas las empresas registradas?

Para realizar esto, simplemente se debe acceder al menú del administrador y posteriormente al submenú para empresas. Siempre y cuando haya empresas, se puede seleccionar la opción que indica [Consultar todas las empresas], y 
se presentará un listado con las empresas registradas.

### ¿Cómo elegir un Stand?
Al momento de crear una empresa, se le pedirá al usuario que elija un Stand; sin embargo, sólo se presentarán los usuarios que en ese momento estén disponibles.

### ¿Cómo consultar todos los Stand?

La consulta de Standas se puede hacer desde el menú de administrador, entrando a la opción de consulta de STANDS. Aparecerá un registro con todos los Stands, indicando si están ocupados o no.

### ¿Cómo se ve la calificación promedio de cada Stand?

Es importante saber que la calificación promedio de cada Stand aparece de la misma forma en que se consultan todos los Stands, sin embargo, sólo aparecerá siempre y cuando un Stand determinado tenga comentarios, de lo contrario,
no aparecerán.

### ¿Cómo consultar los Visitantes?
Desde el menú de visitantes, en el panel de Administrador, se encuentra la opción [1], la cual permite listar a todos los visitantes, seleccionarlos y posteriormente consultar su correo electrónico, modificar su nombbre o eliminarlo.



