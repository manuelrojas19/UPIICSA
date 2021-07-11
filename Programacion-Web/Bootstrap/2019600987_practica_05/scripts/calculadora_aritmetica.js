let valor_1;
let valor_2;

let state = 0;

let STATE_INIT = 0;
let STATE_CAPTURE = 1;
let STATE_OPERATOR = 2;
let STATE_CALCULATE = 3;

let OPERATION_NUMBER = 0;
let OPERATION_OPERATOR = 1;
let OPERATION_EQUAL = 2;
let OPERATION_RESET = 3;

let operator;

let OPERATOR_SUMA = 0;
let OPERATOR_RESTA = 1;
let OPERATOR_MULTI = 2;
let OPERATOR_DIV = 3;
let OPERATOR_PORCENT = 4;

$(function () {
    initCalculadora();
});

function initCalculadora() {
    valor_1 = null;
    valor_2 = null;
    $("#btn_limpiar").on("click", reset);
    $("#btn_1").on("click", capturando);
    $("#btn_2").on("click", capturando);
    $("#btn_3").on("click", capturando);
    $("#btn_4").on("click", capturando);
    $("#btn_5").on("click", capturando);
    $("#btn_6").on("click", capturando);
    $("#btn_7").on("click", capturando);
    $("#btn_8").on("click", capturando);
    $("#btn_9").on("click", capturando);
    $("#btn_0").on("click", capturando);
    $("#btn_punto").on("click", capturando);
    $("#btn_suma").on("click", operando);
    $("#btn_resta").on("click", operando);
    $("#btn_divs").on("click", operando);
    $("#btn_multi").on("click", operando);
    $("#btn_porcentaje").on("click", operando);
    $("#btn_igual").on("click", getResultado);
}

function actualizarEstado(operation) {
    if (operation === OPERATION_RESET) {
        state = STATE_INIT;
    } else if (state === STATE_INIT && operation === OPERATION_NUMBER
        || state === STATE_OPERATOR && operation === OPERATION_NUMBER
        || state === STATE_CALCULATE && operation === OPERATION_NUMBER) {
        state = STATE_CAPTURE;
    } else if (state === STATE_CAPTURE && operation === OPERATION_OPERATOR
        || state === STATE_CALCULATE && operation === OPERATION_OPERATOR) {
        state = STATE_OPERATOR
    } else if (state === STATE_CAPTURE && operation === OPERATION_EQUAL) {
        state = STATE_CALCULATE;
    }
    console.log("Estado = " + state);
}

function reset() {
    valor_1 = null;
    valor_2 = null;
    $("#txt_display").removeClass("is-invalid error");
    limpiarDisplay();
    actualizarEstado(OPERATION_RESET);
}

function capturando() {
    /*
    * Se necesita esta verificación en caso de que se venga del estado
    * igual, para que se regrese al estado inicial y no se
    * concatene el valor ingresado o se generé alguna operación
    * errónea con el resultado anterior
    * */
    if (state === STATE_CALCULATE) {
        reset();
        actualizarDisplay($(this).val());
        actualizarEstado(OPERATION_NUMBER);
    } else {
        actualizarDisplay($(this).val());
        actualizarEstado(OPERATION_NUMBER);
    }
}

function operando() {
    actualizarEstado(OPERATION_OPERATOR);
    if ($(this).val() === "SUMA") {
        operator = OPERATOR_SUMA;
    } else if ($(this).val() === "RESTA") {
        operator = OPERATOR_RESTA;
    } else if ($(this).val() === "MULTIPLICACION") {
        operator = OPERATOR_MULTI;
    } else if ($(this).val() === "DIVISION") {
        operator = OPERATOR_DIV;
    } else if ($(this).val() === "PORCENTAJE") {
        operator = OPERATOR_PORCENT;
    }
    console.log("Operador = " + operator);
}

function getResultado() {
    actualizarEstado(OPERATION_EQUAL);
    actualizarDisplay();
}

function actualizarDisplay(valor) {
    let display = $("#txt_display");
    if (state === STATE_INIT) {
        display.val(valor);
    } else if (state === STATE_CAPTURE) {
        if ($.isNumeric(display.val() + valor)) {
            display.val(display.val() + valor);
        }
    } else if (state === STATE_OPERATOR) {
        valor_1 = display.val();
        display.val(valor);
        console.log("Valor 1 = " + valor_1);
    } else if (state === STATE_CALCULATE) {
        valor_2 = display.val();
        let resultado;
        try {
            resultado = calcular(operator, valor_1, valor_2);
            console.log("res = " + resultado);
            display.val(resultado);
        } catch (e) {
            if (e instanceof DivByZeroError) {
                display.val("División por cero");
                display.addClass("is-invalid error");
                console.error(e.name + ': ' + e.message);
            } else if (e instanceof SyntaxError) {
                display.val("Syntax error");
                display.addClass("is-invalid error");
                console.error(e.name + ': ' + e.message);
            }
        }
        /*
        * Valor_1 se regresa a nulo para que en caso de que se presione
        * de nuevo la tecla igual no se genere otra operación.
        * */
        valor_1 = null;
    }
}

function limpiarDisplay() {
    $("#txt_display").val("");
}

function calcular(operator, valor_1, valor_2) {
    let res;
    if ($.isNumeric(valor_1) && $.isNumeric(valor_2)) {
        valor_1 = parseFloat(valor_1);
        valor_2 = parseFloat(valor_2);
    }
    if (operator === OPERATOR_SUMA) {
        res = valor_1 + valor_2;
        console.log(valor_1 + "+" + valor_2 + "=" + res);
    } else if (operator === OPERATOR_RESTA) {
        res = valor_1 - valor_2;
        console.log(valor_1 + "-" + valor_2 + "=" + res);
    } else if (operator === OPERATOR_MULTI) {
        res = valor_1 * valor_2;
        console.log(valor_1 + "*" + valor_2 + "=" + res);
    } else if (operator === OPERATOR_DIV) {
        if (!valor_2) {
            throw new DivByZeroError("División por cero");
        }
        res = valor_1 / valor_2;
        console.log(valor_1 + "+" / valor_2 + "=" + res);
    } else if (operator === OPERATOR_PORCENT) {
        res = valor_1 * valor_2 / 100;
        console.log(valor_1 + "%" + valor_2 + "=" + res);
    }
    /*
    * Si algún valor de las dos variables es nulo
    * el resultado será igual a alguna de las dos variables
    * */
    if (valor_1 === null && valor_2) {
        res = valor_2;
    } else if (valor_2 === null && valor_1) {
        res = valor_1;
    }
    /*
    * Si el resultado es de tipo NaN y las variables no son
    * nulas, entonces se lanza un error de sintaxis
    * */
    if (isNaN(res) && valor_1 != null && valor_2 != null) {
        throw new SyntaxError();

    }
    return res;
}

class DivByZeroError extends Error {
    constructor(message) {
        super(message);
        this.name = "DivByZeroError";
    }
}

class SyntaxError extends Error {
    constructor(message) {
        super(message);
        this.name = "SyntaxError";
    }
}



