function deleteAccount()
$.ajax({
    url: "http://localhost:8080/delete/" + window.localStorage.getItem("id"),
    type: 'DELETE',
    crossDomain: true,
    success: function(result) {
        window.location.replace("file:///home/basecamp/projects/DailyExercises/March/Remade-Java-Final/FrontEnd/signup.html")
    }
});
