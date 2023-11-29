# CONSIDERACIONES PREVIAS

Para iniciarla aplicación solo deben correr el proyecto asegurandose que este corriendo con Java 17 u OpenJDK17.

Cuanto inicie, este por defecto levantará una base de datos H2 con un usuario creado por defecto. 

Para probar el funcionamiento de la aplicación pueden cargar el siguiente curl en postman. Así tendrán un POST para realizar la prueba de creación de nuevos usuarios.

curl --location 'http://localhost:8080/users' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=FD7F44A8FEE0446160C4CC91A79B6461' \
--data-raw '{
"name": "Cristian Ortega",
"email": "asd@cristianortega.com",
"password": "Kea8VJITeQL4tTW",
"phones": [
{
"number": "996436811",
"cityCode": "9",
"countryCode": "56"
}
]
}'