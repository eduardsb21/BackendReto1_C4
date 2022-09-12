/**
 * Cargar la libreria de Jquery y ubicar el cursor en el campo de registrar
 */
 $(document).ready(function () {
    estadoInicial()
});

/**
 * Intenta autenticar al usuario en la aplicaciòn
 */
function registrar(){
    //capturar los datos que ingreso el usuario en la pagina
    let name = $("#username").val()
    let email = $("#useremail").val()
    let password = $("#password").val()
    let repeatpassword = $("#passwordrepeat").val()

    let datos={
        email : $("#useremail").val(),
        password : $("#password").val(),
        name : $("#username").val()
    }

    let datosPeticion = JSON.stringify(datos)

    //utilizo la funcion de JQuery $.ajax para hacer un llamado asincrono
    //a un ws
    $.ajax({
        method: "POST",
        //url del servicio
        url: "http://localhost:8083/api/user/new",
        
        //envio datos capturados por el usuario a la peticion
        data: datosPeticion,
        dataType: 'json',
        contentType: "application/JSON",
        
        
        //success: funcion con acciones si todo sale ok
        complete: function (respuesta) {
            //escribe en la consola del desarrollador para efectos de depuración
            console.log(respuesta);
            alert("registrado con exito")
        },
        
    });
   
}


function estadoInicial(){
    $("#username").focus()
}

