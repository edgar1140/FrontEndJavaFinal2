function getServer() {
    $('#login-form').on('submit', function(event) {
        event.preventDefault();
        var username = $('#name-input').val();
        var password = $('#password-input').val();
        fetch('http://localhost:8080/login', {
            method: 'post',
            mode: 'cors',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                username: username,
                password: password
            })
        })
            .then(function successfulLogin(response) {
                return response.json();
            })
            .then(function(data) {
                console.log(data.key);
                window.localStorage.setItem('id', data.id);
                window.localStorage.setItem('name', data.name);
                window.localStorage.setItem('sessionKey', data.sessionKey);
                window.location = './index.html';
            })
            .catch(function unsuccessfulLogin(err) {
                // bad user/pw
                console.log(err);
            });
    });
}

function main() {
    getServer();
}

$(main);
