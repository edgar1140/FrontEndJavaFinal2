$('#signup-form').on('submit', function(event) {
    event.preventDefault();
    $.ajax({
        url: 'http://localhost:8080/signup',
        method: 'POST',
        crossDomain: true,
        contentType: 'application/json',
        mimeType: 'application/json',
        data: JSON.stringify({
            name: $('#name-input').val(),
            password: $('#password-input').val()
        })
    })
        .then(function successulSignup(data) {
            console.log(data);
            alert('It Worked');
        })
        .catch(function unsuccessfulSignup(response) {
            console.log(response.status);
            console.log(response.response.JSON);
        });
});

function main() {
    // postServer();
}

$(main);
