function validateX() {
    const radios = document.querySelectorAll('input[type=radio]');
    for (let radio of radios) {
        if (radio.checked) {
            return true;

        }
    }
    radios[7].setCustomValidity("Please choose X");
    radios[7].reportValidity();
    return false;
}

function validateY() {
    let elementY = document.getElementById("Y_input");
    let y = parseFloat(elementY.value.replace(',', '.'));

    if (!isNumeric(y) || y > 5 || y < -5) {
        elementY.setCustomValidity("Please enter an real between -5 and 5");
        elementY.reportValidity();
        return false;
    }
    return true;
}

function validateR() {
    let elementR = document.getElementById("R_input");
    let r = parseFloat(elementR.value.replace(',', '.'));

    if (!isNumeric(r) || r > 5 || r < 2) {
        elementR.setCustomValidity("Please enter an real between 2 and 5");
        elementR.reportValidity();
        return false;
    }
    return true;
}
function isNumeric(n) {
    return !isNaN(parseFloat(n)) && isFinite(n);
}
function validateAll(){
    return (validateR() & validateY() & validateX())
}