$('#signup-form').on('submit', function(event) {
    console.log('AHHHHHHHHH real monsters');
    event.preventDefault();
    $.ajax({
        url: 'http://localhost:8080/signup',
        method: 'POST',
        crossDomain: true,
        contentType: 'application/json',
        mimetype: 'application/json',
        data: JSON.stringify({
            username: $('#name-input').val(),
            password: $('#password-input').val()
        })
    })
        .then(function successulSignup(response) {
            console.log(response.sessionKey);
        })
        .catch(function unsuccessfulSignup(response) {
            console.log('Unable to sign up');
            console.log(response.statusText);
        });
});

function main() {}

$(main);
