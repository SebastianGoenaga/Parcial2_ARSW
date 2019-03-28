function getWeather(city) {
    axios.get('/clima/' + city).then(function (response) {
        var par = document.getElementById("Data");
        par.innerHTML = "";
        for (c in response.data) {
            if (c == "main") {
                for (m in response.data[c]) {
                    par = document.getElementById("Data");
                    var fila = document.createElement("P");
                    fila.setAttribute("class", "lead text-muted");
                    fila.innerHTML = m + ": " + response.data[c][m];
                    par.appendChild(fila);
                    console.log(response.data[c][m]);
                }
            }
        }
    }).catch(function (error) {
        console.log(error);
        alert("Ciudad no valida");
    });
}