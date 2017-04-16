csof5101 - conceptos avanzados en ingenieria de software

Tarea 5 - Program5 PSP2

Nombre: Andrés Felipe García Cifuentes

Fecha de entrega: 03/04/2017

Instrucciones para ejecutar el programa ----->> 
 1. Para descargar el proyecto ejecute la siguiente linea en la terminal ---> git clone https://github.com/andresgarciac2/Program5-PSP2.git
 
 2. HEROKU   --> Para acceder a la aplicacion desplegada en heroku ingrese la siguente URL en un explorador WEB.

			http://tarea5psp2.herokuapp.com
	
  - En esta URL encontrara un enlace que hace referencia a el test propuesto en el enunciado de la tarea
	Test1 --> http://tarea5psp2.herokuapp.com/resultsTest1
  - En la otra url --> http://tarea5psp2.herokuapp.com/results/{:input} podra calcular el resultado con los datos ingresados en el path {:input},
    la estructura de {:input} son los datos requeridos separados por coma primero el numero de secuencia, segundo x y tercero dof
    Ejemplo de {:input} --> 10,1.1,9
    Ejemplo de la URL --> http://tarea5psp2.herokuapp.com/results/10,1.1,9

 3. Para compilarlo y generar el jar ejecute el siguiente comando (dentro de la carpeta que acabo de bajar del repo git)---> mvn install
 4. Para ejecutar el jar use el siguiente comando -----> heroku local
 5. para ver los resultados en su maquina local ingrese la siguente URL en un explorador WEB

		http://localhost:5000
