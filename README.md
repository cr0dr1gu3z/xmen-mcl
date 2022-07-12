# xmen-servicio-mutantes

xmen-servicio-mutantes es un MS desarrollado en Java el cual valida si una cadena de ADN pertenece a un mutante. 

## Descripcion 

Dentro del MS se encuentran 3 PATH los cuales ayudan a la validación, estadísticas e identificación de los registros sobre la cadena de ADN. 

<sub> /mutant :  Realiza la validación si la cadena de ADN enviada es de un mutante o no, dicho flujo realiza la identificación de dos o mas secuencias de código ADN en al la cadena enviada, posterior a ello identifica la existencia en la DB H2, al encontrar coincidencias sobre la DB se realiza la persistencia de la misma, em caso contrario solo responde con el estatus correspondiente pero no persiste en DB. </sub>

<sub> /stats : Realiza la el count de los registros de mutantes y no-mutantes sobre la DB, posterior a ello se realiza la operación de / sobre los registros asignados y muestra las estadísticas de cada campo en DB. </sub>

<sub> /listar: Realiza consultas a la DB para poder mostrar la lista de datos guardados. </sub>



## Consumo de Servicio

Para el consumo del servicio ser podria colocar el la siguiente url por medio de Postman o SOAPUI:https://xmen-servicio-mutantes.rj.r.appspot.com/[PATH]

De igual forma se podria ingrsar a la siguiente url para ejecutar el Swagger del servicio: https://xmen-servicio-mutantes.rj.r.appspot.com/swagger-ui.html

El servicio solo cuenta con un Path Post el cual es /mutant con el cual se muestra un body del rq

### /mutant

```json
{
    "dna":["AGACGG","ACTAGT","AAAATG"]
}

```

