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
    addPasswordValidation();
    addemailValidation();
    addnameValidation();
    addLastNameValidation();
    enableButton();
    showGames();
}
$(main);
