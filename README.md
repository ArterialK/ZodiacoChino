# ZodiacoChino
Aplicación Android en lenguaje Kotlin para saber el horóscopo chino según la fecha de nacimiento

Esta aplicación solicita el nombre, fecha de nacimiento, número de cuenta a 9 dígitos y correo electrónico Una vez ingresados los datos al presionar el botón la aplicación verifica si están bien ingresados para así pasar a la siguiente activity donde muestra esa información junto con el horóscopo chino.

Si los datos son ingresados incorrectamente habrá un mensaje de error, ya sea en el EditableText o en un mensaje emergente (en el caso del calendario.)

Nombre: El nombre tiene una longitud máxima de 46 caracteres considerando al nombre más largo del mundo, no permite caracteres especiales ni números, acepta espacios para ingresar apellidos si lo desea.

Fecha: La fecha de nacimiento será ingresada por medio del calendario del dispositivo, al tocar el EditableText se abrirá el calendario para ingresar la fecha y se guardará en el formato dd/mm/aaaa. No se puede ingresar una fecha mayor a la fecha actual en la que se corre la aplicación.

Número de cuenta: El número de cuenta solo acepta dígitos numéricos y debe ser de una longitud de 9 dígitos, no acepta longitudes menores a 9 y tiene una restricción para mayores de 9 caracteres.

Correo electrónico: El correo electrónico debe tener '@', el cual no se encuentre al inicio de la cadena o al final de ella, además de un '.', el cual debe estar después del @ y no puede encontrarse en el carácter siguiente al @ ni al final de la cadena.

La aplicación contempla 3 idiomas: Español, Ingles y Japones
