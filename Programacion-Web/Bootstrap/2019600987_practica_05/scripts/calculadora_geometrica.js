$(function () {
    initCalculadoraGeometrica();
});

function initCalculadoraGeometrica() {
    $("#btn_perimetro_cuadrado").on("click", calcularPerimetroCuadrado);
    $("#btn_perimetro_rectangulo").on("click", calcularPerimetroRectangulo);
    $("#btn_perimetro_triangulo").on("click", calcularPerimetroTriangulo);
    $("#btn_area_cuadrado").on("click", calcularAreaCuadrado);
    $("#btn_area_rectangulo").on("click", calcularAreaRectangulo);
    $("#btn_area_circulo").on("click", calcularAreaCirculo);
    $("#btn_volumen_cubo").on("click", calcularVolumenCubo);
    $("#btn_volumen_piramide").on("click", calcularVolumenPiramide);
    $("#btn_volumen_esfera").on("click", calcularVolumenEsfera);
}

function calcularPerimetroCuadrado() {
    let lado;
    lado = $("#lado_cuadrado").val();
    if (validacionPerimetroCuadrado(lado)) {
        $("#alert-cuadrado").addClass("d-none");
        $("#res_perimetro_cuadrado").removeClass("d-none");
        lado = parseFloat(lado);
        let res = lado * 4;
        $("#res_perimetro_cuadrado").text("El perímetro del cuadrado es: " + res);
    }
}

function calcularPerimetroRectangulo() {
    let ancho = $("#ancho_rectangulo").val();
    let alto = $("#alto_rectangulo").val();
    if (validacionPerimetroRectangulo(ancho, alto)) {
        $("#alert-rectangulo-perimetro").addClass("d-none");
        $("#res_perimetro_rectangulo").removeClass("d-none");
        ancho = parseFloat(ancho);
        alto = parseFloat(alto);
        let res = (ancho * 2) + (alto * 2);
        $("#res_perimetro_rectangulo").text("El perímetro del rectangulo es: " + res);
    }
}

function calcularPerimetroTriangulo() {
    let lado1 = $("#lado1_triangulo").val();
    let lado2 = $("#lado2_triangulo").val();
    let lado3 = $("#lado3_triangulo").val();
    if (validacionPerimetroTriangulo(lado1, lado2, lado3)) {
        $("#alert-triangulo-perimetro").addClass("d-none");
        $("#res_perimetro_triangulo").removeClass("d-none");
        lado1 = parseFloat(lado1);
        lado2 = parseFloat(lado2);
        lado3 = parseFloat(lado3);
        let res = lado1 + lado2 + lado3;
        $("#res_perimetro_triangulo").text("El perímetro del triángulo es: " + res);
    }
}

function calcularAreaCuadrado() {
    let lado = $("#lado_cuadrado_area").val();
    if (validacionAreaCuadrado(lado)) {
        $("#alert-cuadrado-area").addClass("d-none");
        $("#res_area_cuadrado").removeClass("d-none");
        lado = parseFloat(lado);
        let res = Math.pow(lado, 2);
        $("#res_area_cuadrado").text("El área del cuadrado es: " + res);
    }
}

function calcularAreaRectangulo() {
    let ancho = $("#ancho_rectangulo_area").val();
    let alto = $("#alto_rectangulo_area").val();
    if (validacionAreaRectangulo(ancho, alto)) {
        $("#alert-rectangulo-area").addClass("d-none");
        $("#res_area_rectangulo").removeClass("d-none");
        ancho = parseFloat(ancho);
        alto = parseFloat(alto);
        let res = alto * ancho;
        $("#res_area_rectangulo").text("El área del rectángulo es: " + res);
    }
}

function calcularAreaCirculo() {
    let diametro = $("#diametro_circulo_area").val();
    if (validacionAreaCirculo(diametro)) {
        $("#alert-circulo-area").addClass("d-none");
        $("#res_area_circulo").removeClass("d-none");
        diametro = parseFloat(diametro);
        let radio = diametro / 2;
        let res = Math.PI * Math.pow(radio, 2);
        $("#res_area_circulo").text("El área del circulo es: " + res);
    }
}

function calcularVolumenCubo() {
    let lado = $("#lado_cubo_volumen").val();
    if (validacionVolumenCubo(lado)) {
        $("#alert-cubo-volumen").addClass("d-none");
        $("#res_volumen_cubo").removeClass("d-none");
        lado = parseFloat(lado);
        let res = Math.pow(lado, 3);
        $("#res_volumen_cubo").text("El volumen del cubo es: " + res);
    }
}

function calcularVolumenPiramide() {
    let anchoBase = $("#anchobase_piramide_volumen").val();
    let altoBase = $("#altobase_piramide_volumen").val();
    let alturaPiramide = $("#altura_piramide_volumen").val();
    if (validacionVolumenPiramide(anchoBase, altoBase, alturaPiramide)) {
        $("#alert-piramide-volumen").addClass("d-none");
        $("#res_volumen_piramide").removeClass("d-none");
        anchoBase = parseFloat(anchoBase);
        altoBase = parseFloat(altoBase);
        alturaPiramide = parseFloat(alturaPiramide);
        let areaBase = anchoBase * altoBase;
        let res = (areaBase * alturaPiramide) / 3;
        $("#res_volumen_piramide").text("El volumen de la pirámide es: " + res);
    }
}

function calcularVolumenEsfera() {
    let radioEsfera = $("#radio_esfera_volumen").val();
    if (valicacionEsferaVolumen(radioEsfera)) {
        $("#alert-esfera-volumen").addClass("d-none");
        $("#res_volumen_esfera").removeClass("d-none");
        radioEsfera = parseFloat(radioEsfera);
        let res = (4 * Math.PI * Math.pow(radioEsfera, 2)) / 3;
        $("#res_volumen_esfera").text("El volumen de la esfera es: " + res);
    }
}

function validacionPerimetroCuadrado(lado) {
    console.log("Ingresa validación");
    let isValid = true;
    if (lado === null || lado === undefined || lado === "") {
        console.log("Ingresa error");
        isValid = false;
        $("#txtalert-p-cuadrado").text("Por favor ingrese los datos faltantes.");
        $("#lado_cuadrado").addClass("is-invalid");
        $("#alert-cuadrado").removeClass("d-none");
        $("#res_perimetro_cuadrado").addClass("d-none");
    } else if (lado <= 0) {
        console.log("Negative error");
        isValid = false;
        $("#txtalert-p-cuadrado").text("El lado ingresado no puede ser menor o igual a 0 regresate a la primaria.");
        $("#lado_cuadrado").addClass("is-invalid");
        $("#alert-cuadrado").removeClass("d-none");
        $("#res_perimetro_cuadrado").addClass("d-none");
    } else {
        $("#lado_cuadrado").removeClass("is-invalid")
    }
    return isValid;
}

function validacionPerimetroRectangulo(ancho, alto) {
    let isValid = true;
    if (alto === null || alto === undefined || alto === "") {
        console.log("Ingresa error");
        isValid = false;
        $("#alto_rectangulo").addClass("is-invalid");
        $("#txtalert-p-rectangulo").text("Ingrese los datos que faltan");
        $("#alert-rectangulo-perimetro").removeClass("d-none");
        $("#res_perimetro_rectangulo").addClass("d-none");
    } else if (alto <= 0) {
        console.log("Negative error");
        isValid = false;
        $("#alto_rectangulo").addClass("is-invalid");
        $("#txtalert-p-rectangulo").text("Los datos ingresados no pueden ser menores o iguales a 0");
        $("#alert-rectangulo-perimetro").removeClass("d-none");
        $("#res_perimetro_rectangulo").addClass("d-none");
    } else {
        $("#alto_rectangulo").removeClass("is-invalid");
    }
    if (ancho === null || ancho === undefined || ancho === "") {
        console.log("Ingresa error");
        isValid = false;
        $("#ancho_rectangulo").addClass("is-invalid");
        $("#txtalert-p-rectangulo").text("Ingrese los datos que faltan");
        $("#alert-rectangulo-perimetro").removeClass("d-none");
        $("#res_perimetro_rectangulo").addClass("d-none");
    } else if (ancho <= 0) {
        console.log("Negative error");
        isValid = false;
        $("#ancho_rectangulo").addClass("is-invalid");
        $("#txtalert-p-rectangulo").text("Los datos ingresados no pueden ser menores o iguales a 0");
        $("#alert-rectangulo-perimetro").removeClass("d-none");
        $("#res_perimetro_rectangulo").addClass("d-none");
    } else {
        $("#ancho_rectangulo").removeClass("is-invalid");
    }
    return isValid;
}

function validacionPerimetroTriangulo(lado1, lado2, lado3) {
    let isValid = true;
    if (lado1 === null || lado1 === undefined || lado1 === "") {
        console.log("Ingresa error");
        isValid = false;
        $("#lado1_triangulo").addClass("is-invalid");
        $("#txtalert-triangulo-perimetro").text("Ingrese los datos que faltan");
        $("#alert-triangulo-perimetro").removeClass("d-none");
        $("#res_perimetro_triangulo").addClass("d-none");
    } else if (lado1 <= 0) {
        console.log("Negative error");
        isValid = false;
        $("#lado1_triangulo").addClass("is-invalid");
        $("#txtalert-triangulo-perimetro").text("Los datos ingresados no pueden ser menores o iguales a 0");
        $("#alert-triangulo-perimetro").removeClass("d-none");
        $("#res_perimetro_triangulo").addClass("d-none");
    } else {
        $("#lado1_triangulo").removeClass("is-invalid");
    }

    if (lado2 === null || lado2 === undefined || lado2 === "") {
        console.log("Ingresa error");
        isValid = false;
        $("#lado2_triangulo").addClass("is-invalid");
        $("#txtalert-triangulo-perimetro").text("Ingrese los datos que faltan");
        $("#alert-triangulo-perimetro").removeClass("d-none");
        $("#res_perimetro_triangulo").addClass("d-none");
    } else if (lado2 <= 0) {
        console.log("Negative error");
        isValid = false;
        $("#lado2_triangulo").addClass("is-invalid");
        $("#txtalert-triangulo-perimetro").text("Los datos ingresados no pueden ser menores o iguales a 0");
        $("#alert-triangulo-perimetro").removeClass("d-none");
        $("#res_perimetro_triangulo").addClass("d-none");
    } else {
        $("#lado2_triangulo").removeClass("is-invalid");
    }

    if (lado3 === null || lado3 === undefined || lado3 === "") {
        console.log("Ingresa error");
        isValid = false;
        $("#lado3_triangulo").addClass("is-invalid");
        $("#txtalert-triangulo-perimetro").text("Ingrese los datos que faltan");
        $("#alert-triangulo-perimetro").removeClass("d-none");
        $("#res_perimetro_triangulo").addClass("d-none");
    } else if (lado3 <= 0) {
        console.log("Negative error");
        isValid = false;
        $("#lado3_triangulo").addClass("is-invalid");
        $("#txtalert-triangulo-perimetro").text("Los datos ingresados no pueden ser menores o iguales a 0");
        $("#alert-triangulo-perimetro").removeClass("d-none");
        $("#res_perimetro_triangulo").addClass("d-none");
    } else {
        $("#lado3_triangulo").removeClass("is-invalid");
    }
    return isValid;
}

function validacionAreaCuadrado(lado) {
    let isValid = true;
    if (lado === null || lado === undefined || lado === "") {
        console.log("Ingresa error");
        isValid = false;
        $("#lado_cuadrado_area").addClass("is-invalid");
        $("#txtalert-cuadrado-area").text("Ingrese los datos que faltan");
        $("#alert-cuadrado-area").removeClass("d-none");
        $("#res_area_cuadrado").addClass("d-none");
    } else if (lado <= 0) {
        console.log("Negative error");
        isValid = false;
        $("#lado_cuadrado_area").addClass("is-invalid");
        $("#txtalert-cuadrado-area").text("Los datos ingresados no pueden ser menores o iguales a 0");
        $("#alert-cuadrado-area").removeClass("d-none");
        $("#res_area_cuadrado").addClass("d-none");
    } else {
        $("#lado_cuadrado_area").removeClass("is-invalid");
    }
    return isValid
}

function validacionAreaRectangulo(ancho, alto) {
    let isValid = true;
    if (alto === null || alto === undefined || alto === "") {
        console.log("Ingresa error");
        isValid = false;
        $("#alto_rectangulo_area").addClass("is-invalid");
        $("#txtalert-rectangulo-area").text("Ingrese los datos que faltan");
        $("#alert-rectangulo-area").removeClass("d-none");
        $("#res_area_rectangulo").addClass("d-none");
    } else if (alto <= 0) {
        console.log("Negative error");
        isValid = false;
        $("#alto_rectangulo_area").addClass("is-invalid");
        $("#txtalert-rectangulo-area").text("Los datos ingresados no pueden ser menores o iguales a 0");
        $("#alert-rectangulo-area").removeClass("d-none");
        $("#res_area_rectangulo").addClass("d-none");
    } else {
        $("#alto_rectangulo_area").removeClass("is-invalid");
    }
    if (ancho === null || ancho === undefined || ancho === "") {
        console.log("Ingresa error");
        isValid = false;
        $("#ancho_rectangulo_area").addClass("is-invalid");
        $("#txtalert-rectangulo-area").text("Ingrese los datos que faltan");
        $("#alert-rectangulo-area").removeClass("d-none");
        $("#res_area_rectangulo").addClass("d-none");
    } else if (ancho <= 0) {
        console.log("Negative error");
        isValid = false;
        $("#ancho_rectangulo_area").addClass("is-invalid");
        $("#txtalert-rectangulo-area").text("Los datos ingresados no pueden ser menores o iguales a 0");
        $("#alert-rectangulo-area").removeClass("d-none");
        $("#res_area_rectangulo").addClass("d-none");
    } else {
        $("#ancho_rectangulo_area").removeClass("is-invalid");
    }
    return isValid;
}

function validacionAreaCirculo(diametro) {
    let isValid = true;
    if (diametro === null || diametro === undefined || diametro === "") {
        console.log("Ingresa error");
        isValid = false;
        $("#diametro_circulo_area").addClass("is-invalid");
        $("#txtalert-circulo-area").text("Ingrese los datos que faltan");
        $("#alert-circulo-area").removeClass("d-none");
        $("#res_area_circulo").addClass("d-none");
    } else if (diametro <= 0) {
        console.log("Negative error");
        isValid = false;
        $("#diametro_circulo_area").addClass("is-invalid");
        $("#txtalert-circulo-area").text("Los datos ingresados no pueden ser menores o iguales a 0");
        $("#alert-circulo-area").removeClass("d-none");
        $("#res_area_circulo").addClass("d-none");
    } else {
        $("#diametro_circulo_area").removeClass("is-invalid");
    }
    return isValid;
}

function validacionVolumenCubo(lado) {
    let isValid = true;
    if (lado === null || lado === undefined || lado === "") {
        console.log("Ingresa error");
        isValid = false;
        $("#lado_cubo_volumen").addClass("is-invalid");
        $("#txtalert-cubo-volumen").text("Ingrese los datos que faltan");
        $("#alert-cubo-volumen").removeClass("d-none");
        $("#res_volumen_cubo").addClass("d-none");
    } else if (lado <= 0) {
        console.log("Negative error");
        isValid = false;
        $("#lado_cubo_volumen").addClass("is-invalid");
        $("#txtalert-cubo-volumen").text("Los datos ingresados no pueden ser menores o iguales a 0");
        $("#alert-cubo-volumen").removeClass("d-none");
        $("#res_volumen_cubo").addClass("d-none");
    } else {
        $("#lado_cubo_volumen").removeClass("is-invalid");
    }
    return isValid;
}

function validacionVolumenPiramide(anchoBase, altoBase, alto) {
    let isValid = true;
    if (anchoBase === null || anchoBase === undefined || anchoBase === "") {
        console.log("Ingresa error");
        isValid = false;
        $("#anchobase_piramide_volumen").addClass("is-invalid");
        $("#txtalert-piramide-volumen").text("Ingrese los datos que faltan");
        $("#alert-piramide-volumen").removeClass("d-none");
        $("#res_volumen_piramide").addClass("d-none");
    } else if (anchoBase <= 0) {
        console.log("Negative error");
        isValid = false;
        $("#anchobase_piramide_volumen").addClass("is-invalid");
        $("#txtalert-piramide-volumen").text("Los datos ingresados no pueden ser menores o iguales a 0");
        $("#alert-piramide-volumen").removeClass("d-none");
        $("#res_volumen_piramide").addClass("d-none");
    } else {
        $("#anchobase_piramide_volumen").removeClass("is-invalid");
    }

    if (altoBase === null || altoBase === undefined || altoBase === "") {
        console.log("Ingresa error");
        isValid = false;
        $("#altobase_piramide_volumen").addClass("is-invalid");
        $("#txtalert-piramide-volumen").text("Ingrese los datos que faltan");
        $("#alert-piramide-volumen").removeClass("d-none");
        $("#res_volumen_piramide").addClass("d-none");
    } else if (altoBase <= 0) {
        console.log("Negative error");
        isValid = false;
        $("#altobase_piramide_volumen").addClass("is-invalid");
        $("#txtalert-piramide-volumen").text("Los datos ingresados no pueden ser menores o iguales a 0");
        $("#alert-piramide-volumen").removeClass("d-none");
        $("#res_volumen_piramide").addClass("d-none");
    } else {
        $("#altobase_piramide_volumen").removeClass("is-invalid");
    }

    if (alto === null || alto === undefined || alto === "") {
        console.log("Ingresa error");
        isValid = false;
        $("#altura_piramide_volumen").addClass("is-invalid");
        $("#txtalert-piramide-volumen").text("Ingrese los datos que faltan");
        $("#alert-piramide-volumen").removeClass("d-none");
        $("#res_volumen_piramide").addClass("d-none");
    } else if (alto <= 0) {
        console.log("Negative error");
        isValid = false;
        $("#altura_piramide_volumen").addClass("is-invalid");
        $("#txtalert-piramide-volumen").text("Los datos ingresados no pueden ser menores o iguales a 0");
        $("#alert-piramide-volumen").removeClass("d-none");
        $("#res_volumen_piramide").addClass("d-none");
    } else {
        $("#altura_piramide_volumen").removeClass("is-invalid");
    }
    return isValid;
}

function valicacionEsferaVolumen(radio) {
    let isValid = true;
    if (radio === null || radio === undefined || radio === "") {
        console.log("Ingresa error");
        isValid = false;
        $("#radio_esfera_volumen").addClass("is-invalid");
        $("#txtalert-esfera-volumen").text("Ingrese los datos que faltan");
        $("#alert-esfera-volumen").removeClass("d-none");
        $("#res_volumen_esfera").addClass("d-none");
    } else if (radio <= 0) {
        console.log("Negative error");
        isValid = false;
        $("#radio_esfera_volumen").addClass("is-invalid");
        $("#txtalert-esfera-volumen").text("Los datos ingresados no pueden ser menores o iguales a 0");
        $("#alert-esfera-volumen").removeClass("d-none");
        $("#res_volumen_esfera").addClass("d-none");
    } else {
        $("#radio_esfera_volumen").removeClass("is-invalid");
    }
    return isValid;
}