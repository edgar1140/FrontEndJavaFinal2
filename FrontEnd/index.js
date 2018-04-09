function showPasswordErrors(password) {
    if (password === '') {
        $('.password-error')
            .show()
            .html('<li>Password must be filled</li>');
        return false;
    } else {
        $('.password-error').hide();
        return true;
    }
}
function addPasswordValidation() {
    const input = $('#password-input');
    input.on('input', function(event) {
        showPasswordErrors(event.currentTarget.value);
        enableButton();
    });
}

//name error//

function showNameErrors(name) {
    if (name === '') {
        $('.name-error')
            .show()
            .html('<li>Name must be filled</li>');
        return false;
    } else {
        $('.name-error').hide();
        return true;
    }
}
function addnameValidation() {
    const input = $('#name-input');
    input.on('input', function(event) {
        showNameErrors(event.currentTarget.value);
        enableButton();
    });
}

//last name error//

function showLastNameErrors(name) {
    if (name === '') {
        $('.last-name-error')
            .show()
            .html('<li>Last name must be filled</li>');
        return false;
    } else {
        $('.last-name-error').hide();
        return true;
    }
}

function addLastNameValidation() {
    const input = $('#last-name-input');
    input.on('input', function(event) {
        showNameErrors(event.currentTarget.value);
        enableButton();
    });
}

// email error //

function showEmailErrors(name) {
    if (name === '') {
        $('.email-error')
            .show()
            .html('<li>Email must be filled</li>');
        return false;
    } else {
        $('.email-error').hide();
        return true;
    }
}

function addemailValidation() {
    const input = $('#email-input');
    input.on('input', function(event) {
        showNameErrors(event.currentTarget.value);
        enableButton();
    });
}

function checkName() {
    return showNameErrors($('#name-input').val()) === true;
}
function checkPassword() {
    return showPasswordErrors($('#password-input').val()) === true;
}
function checkLastname() {
    return showLastNameErrors($('#last-name-input').val()) === true;
}
function checkemail() {
    return showEmailErrors($('#email-input').val()) === true;
}

function enableButton() {
    if (checkName() && checkLastname() && checkPassword() && checkemail()) {
        $('.btn').attr('disabled', false);
    } else {
        $('.btn').attr('disabled', true);
    }
}

function main() {
    addPasswordValidation();
    addemailValidation();
    addnameValidation();
    addLastNameValidation();
    enableButton();
}
$(main);
