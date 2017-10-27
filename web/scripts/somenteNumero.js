
// Script para o usuario digitar somente numeros no input

function SomenteNumeroPonto(e) {
    var tecla = (window.event) ? event.keyCode : e.which;
    if ((tecla > 47 && tecla < 58 || tecla === 46)) {
        return true;
    } else {
        if (tecla === 8 || tecla === 0)
            return true;
        else
            return false;
    }
}

function SomenteNumero(e) {
    var tecla = (window.event) ? event.keyCode : e.which;
    if ((tecla > 47 && tecla < 58 || tecla === 45)) {
        return true;
    } else {
        if (tecla === 8 || tecla === 0)
            return true;
        else
            return false;
    }
}

//Não funcionou no js??
function SomenteNumeroPositivo(e) {
    var tecla = (window.event) ? event.keyCode : e.which;
    if ((tecla > 47 && tecla < 58)) {
        return true;
    } else {
        if (tecla === 8 || tecla === 0)
            return true;
        else
            return false;
    }
}

// USAR NO ONBLUR
// Não funciona no js, colocar na página
function valorMaximo(input){
    if (input.value > 10 || input.value < 0) {
        input.value = "";
    }
}

function numero1A10(input){
    if (input.value < 1 || input.value > 10) {
        alert("Somente números de 1 a 10!");
        input.value = "";
    }
}
