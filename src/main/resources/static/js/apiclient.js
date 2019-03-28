apiclient = (function() {

	return {
		getWeather : function(city, callback) {
			axios.get("/weather/" + city, function(response) {
				callback(data);
			});
		}
	}

})();