var baseUrl = window.location.protocol + "//" + window.location.host;
var droneURL = baseUrl + "/drones";




// On initialise la latitude et la longitude de Paris (centre de la carte)
var lat = 44.8645645;
var lon = -0.5590135;
// var latDrone1 = drones[0].posX;
// var lonDrone1 = drones[0].posY;
// var latDrone2 = drones[1].posX;
// var lonDrone2 = drones[1].posY;

var macarte = null;

var myIconDrone = L.icon({
	iconUrl: "./images/drone.png",
	iconSize: [20, 20],
	iconAnchor: [25, 50],
	popupAnchor: [-3, -76],
});

var entrepriseMarker = L.marker([lat, lon]);

// var drone1 = L.marker([latDrone1, lonDrone1], { icon: myIconDrone });
// drone1.bindPopup('drone 1');

// var drone2 = L.marker([latDrone2, lonDrone2], { icon: myIconDrone });
// drone2.bindPopup('drone 2');

// Fonction d'initialisation de la carte
function initMap() {
	// Créer l'objet "macarte" et l'insèrer dans l'élément HTML qui a l'ID "map"
	macarte = L.map('map').setView([lat, lon], 15);
	// Leaflet ne récupère pas les cartes (tiles) sur un serveur par défaut. Nous devons lui préciser où nous souhaitons les récupérer. Ici, openstreetmap.fr
	L
		.tileLayer(
			'https://{s}.tile.openstreetmap.fr/osmfr/{z}/{x}/{y}.png',
			{
				// Il est toujours bien de laisser le lien vers la source des données
				attribution: 'données © <a href="//osm.org/copyright">OpenStreetMap</a>/ODbL - rendu <a href="//openstreetmap.fr">OSM France</a>',
				minZoom: 1,
				maxZoom: 20
			}).addTo(macarte);
	entrepriseMarker.addTo(macarte);
	// Nous ajoutons un marqueur

	ajaxGet(droneURL, function (reponse) {
		// Transforme la réponse en un tableau drones
		drones = JSON.parse(reponse);
		drones.forEach(function (drone) {
		//	console.log(drones[0].posX);
		droneMarker= L.marker([drone.posX, drone.posY], { icon: myIconDrone });
		droneMarker.bindPopup(drone.nom);	
		droneMarker.addTo(macarte);
		});
	});
	// drone1.addTo(macarte);
	// drone2.addTo(macarte);
}
window.onload = function () {
	// Fonction d'initialisation qui s'exécute lorsque le DOM est chargé
	initMap();
};
function afficherLaDrone() {

}

function afficherLesDrone() {
	afficheDrone = document.getElementById('les-drones');
	localiserDrone = document.getElementById('localiser-drone');
	localiserDrone.style.display = 'none';
	if (afficheDrone.style.display == 'block')
		afficheDrone.style.display = 'none';

	else
		afficheDrone.style.display = 'block';
}

function localiserUneDrone() {
	afficheDrone = document.getElementById('les-drones');
	localiserDrone = document.getElementById('localiser-drone');
	afficheDrone.style.display = 'none';
	if (localiserDrone.style.display == 'block')
		localiserDrone.style.display = 'none';
	else
		localiserDrone.style.display = 'block';
}

function afficherInfoDrone(idDiv) {
	infoDrone = document.getElementById(idDiv);
	if (infoDrone.style.display == 'block')
		infoDrone.style.display = 'none';
	else
		infoDrone.style.display = 'block';
}
