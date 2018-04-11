function getServer() {
    $('#login-form').on('submit', function(event) {
        event.preventDefault();
        $.post(
            'http://localhost:8080/login',
            JSON.stringify({
                username: $('#name-input').val(),
                password: $('#password-input').val()
            })
        )
            .then(function successfulLogin(data) {
                console.log(data.key);
                window.localStorage.setItem('key', data.key);
                window.location = 'page.html?user=' + $('#name-input').val();
            })
            .catch(function unsuccessfulLogin(response) {
                console.log(response.status);
                console.log(response.response.JSON);
            });
    });
}

function main() {
    getServer();
}

$(main);
