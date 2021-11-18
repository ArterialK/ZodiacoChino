# ZodiacoChino
Aplicacion Android en lenguaje Kotlin para saber el horoscopo chino segun la fecha de nacimiento

Esta aplicacion solicita el nombre, fecha de nacimiento, numero de cuenta a 9 digitos y correo electronico
Una vez ingresados los datos al presionar el boton la aplicacion verificara si estan bien ingresados para asi
pasar a la siguiente actividad donde muestra esa informacion junto con el horoscopo chino.

Nombre:
El nombre tiene una longitud maxima de 46 caracteres considerando al nombre mas largo del mundo, no permite
caracteres especiales ni numeros, acepta espacios para ingresar apellidos si lo desea.

Fecha:
La fecha de nacimiento sera ingresada por medio del calendario del dispositivo, al tocar el EditableText
se abrira el calendario para ingresar la fecha y se guardara en el formato dd/mm/aaaa

Numero de cuenta:
El numero de cuenta solo acepta digitos numericos y debe ser de una longitud de 9 digitos, no acepta 
longitudes menores a 9 y tiene una restriccion para mayores de 9 caracteres.

Correo electronico:
El correo electronico debe tener '@', el cual no se encuentre al inicio de la cadena o al final de ella,
ademas de un '.', el cual debe estar despues del @ y no puede encontrarse en el caracter siguiente al @
ni al final de la cadena.

La aplicacion contempla 3 idiomas: Español, Ingles y Japones
