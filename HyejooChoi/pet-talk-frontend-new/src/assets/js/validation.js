// 숫자 Validation
function validateNumber(value) {
    if(validateSpace){ // 공백이 없으면
        var numReg = /^[0-9]*$/;
        return numReg.test(String(value)); // 숫자 체크
    }else{
        return false;
    }
}

// 이메일 Validation
function validateEmail(value) {
    if(validateSpace){ // 공백이 없으면
        var emailReg = /^[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
        return emailReg.test(String(value)); // 이메일형식 체크
    }else{
        return false;
    }
}

// 공백 Validation
function validateSpace(value) {
    var spaceReg = /\s/g;
    return (value.match(spaceReg)) ? false : true;
}

// 사업자번호 Validation
function validateBizNo(value) {
    if(validateSpace){
        var bizNoReg = /^[0-9]{10}$/;
        return bizNoReg.test(String(value));
    }
}

// 전화번호 Validation
function validateTelNo(value) {
    if(validateSpace){
        var telNoReg = /^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})?[0-9]{3,4}?[0-9]{4}$/;
        return telNoReg.test(String(value));
    }
}

export {
    validateNumber,
    validateEmail,
    validateSpace,
    validateBizNo,
    validateTelNo,
};
