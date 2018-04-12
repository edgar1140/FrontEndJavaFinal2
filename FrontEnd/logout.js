$('#logout').on('click', function(event) {
    event.preventDefault();
    $.ajax({
        url:
            'http://localhost:8080/logout/' + window.localStorage.getItem('id'),
        type: 'DELETE',
        crossDomain: true,
        success: function(result) {
            window.localStorage.removeItem('sessionKey');
            window.location.replace(
                'file:///home/basecamp/projects/DailyExercises/March/Remade-Java-Final/FrontEnd/signup.html'
            );
        }
    });
});
