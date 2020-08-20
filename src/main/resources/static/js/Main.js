function loadCategories() {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var categories = JSON.parse(this.responseText);
			var html = '';
			for (var i = 0; i < categories.length; i++) {
				var category = categories[i];
				html = html + '<option value = ' + category.categoryId + '>'
						+ category.categoryName + '</option>';
			}
			document.getElementById("categories-selector").innerHTML = html;
		}
	};
	xhttp.open("GET", "http://localhost:8080/categories", true);
	xhttp.send();
}

function loadRegions() {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var regions = JSON.parse(this.responseText);
			var html = '';
			for (var i = 0; i < regions.length; i++) {
				var region = regions[i];
				html = html + '<option value = ' + region.regionId + '>'
						+ region.regionName + '</option>';
			}
			console.log(html);
			document.getElementById("regions-selector").innerHTML = html;
		}
	};
	xhttp.open("GET", "http://localhost:8080/regions", true);
	xhttp.send();
}

loadRegions();
loadCategories();

function updateCities(regionId) {
	var xhttp = new XMLHttpRequest();
	xhttp.open("POST", "http://localhost:8080/cities/" + regionId, true);
	xhttp.send();

	setTimeout(loadCities, 1000, regionId);
}

function loadCities(regionId) {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var cities = JSON.parse(this.responseText);
			var html = '';
			for (var i = 0; i < cities.length; i++) {
				var city = cities[i];
				if (city.regionId.regionId == regionId){
					html = html + '<option value = ' + city.cityId + '>'
							+ city.cityName + '</option>';
				}
			}
			document.getElementById("cities-selector").innerHTML = html;
		}
	};
	xhttp.open("GET", "http://localhost:8080/cities", true);
	xhttp.send();
}
