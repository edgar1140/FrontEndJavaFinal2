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

function checkName() {
    return showNameErrors($('#name-input').val()) === true;
}
function checkPassword() {
    return showPasswordErrors($('#password-input').val()) === true;
}

function enableButton() {
    if (checkName() && checkPassword()) {
        $('.btn').attr('disabled', false);
    } else {
        $('.btn').attr('disabled', true);
    }
}

function game(games) {
    var gameStructure = games
        .map(function(game) {
            return [
                // "div class='row'",
                "<div class='SoccerTables' col-lg-6 col-md-8 col-sm-5",
                "<tr id='all-games' class='card text-white bg-dark mb-3' style='max-width: 20rem;'>",
                '<td>' +
                    '<img src=' +
                    game.home_img_url +
                    '>' +
                    '<p> Team Name: ' +
                    game.home_team +
                    ' </p>' +
                    '<p> Goals: ' +
                    game.home_score +
                    '</p>' +
                    '</td>',
                '<td>' +
                    '<img src=' +
                    game.away_img_url +
                    '>' +
                    '<p> Team Name: ' +
                    game.away_team +
                    ' </p>' +
                    '<p> Goals: ' +
                    game.away_score +
                    '</p>' +
                    '</td>' +
                    '</tr>',
                '</div>',
                '</div>'
            ].join('');
        })
        .join('');

    return '<h3>Matches:</h3>' + '<table>' + gameStructure + '</table>';
}

function initializeExistingGamesView(games) {
    $('#games').html(game(games));
}
function showGames() {
    fetch('http://localhost:8080/games')
        .then(response => response.json())
        .then(initializeExistingGamesView);
}

function main() {
    var key = window.localStorage.getItem('sessionKey');
    if (key) {
        $.ajax({
            url: 'http://localhost:8080/account/' + key,
            method: 'GET',
            crossDomain: true,
            success: function(response) {
                console.log(response);
                window.localStorage.setItem('id', response.id);
                window.localStorage.setItem('name', response.name);
                addPasswordValidation();
                addnameValidation();
                enableButton();
                showGames();
            },
            error: function() {
                console.log('invalid key');
                console.log(arguments);
                window.localStorage.removeItem('sessionKey');
                window.location = 'signup.html';
            }
        });
    } else {
        window.location = 'signup.html';
    }
    $('#logout').on('click', function(event) {
        event.preventDefault();
        $.ajax({
            url:
                'http://localhost:8080/logout/' +
                window.localStorage.getItem('id'),
            type: 'DELETE',
            crossDomain: true,
            success: function(result) {
                window.localStorage.removeItem('sessionKey');
                window.localStorage.removeItem('username');
                window.location.replace(
                    'file:///home/basecamp/projects/DailyExercises/March/Remade-Java-Final/FrontEnd/login.html'
                );
            }
        });
    });

    $('#delete').on('click', function(event) {
        event.preventDefault();
        $.ajax({
            url:
                'http://localhost:8080/delete/' +
                window.localStorage.getItem('id'),
            type: 'DELETE',
            crossDomain: true,
            success: function(result) {
                window.location.replace(
                    'file:///home/basecamp/projects/DailyExercises/March/Remade-Java-Final/FrontEnd/signup.html'
                );
            }
        });
    });
}
$(main);
