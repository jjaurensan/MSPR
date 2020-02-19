// On initialise la latitude et la longitude de Paris (centre de la carte)
var lat = 44.8645645;
var lon = -0.5590135;
var latDrone1 = 44.86382829664125;
var lonDrone1 = -0.5539287092459722;
var latDrone2 = 44.85829503973355;
var lonDrone2 = -0.5685285098797044;
var drone1= L.marker([ latDrone1, lonDrone1 ]).bindPopup('drone 1');
var drone2= L.marker([ latDrone2, lonDrone2 ]).bindPopup('drone 2');
var macarte = null;
// Fonction d'initialisation de la carte
function initMap() {
	// Créer l'objet "macarte" et l'insèrer dans l'élément HTML qui a l'ID "map"
	macarte = L.map('map').setView([ lat, lon ], 15);
	// Leaflet ne récupère pas les cartes (tiles) sur un serveur par défaut. Nous devons lui préciser où nous souhaitons les récupérer. Ici, openstreetmap.fr
	L
			.tileLayer(
					'https://{s}.tile.openstreetmap.fr/osmfr/{z}/{x}/{y}.png',
					{
						// Il est toujours bien de laisser le lien vers la source des données
						attribution : 'données © <a href="//osm.org/copyright">OpenStreetMap</a>/ODbL - rendu <a href="//openstreetmap.fr">OSM France</a>',
						minZoom : 1,
						maxZoom : 20
					}).addTo(macarte);
	var circle = L.circle([ lat, lon ], {
		color : 'red',
		fillColor : '#f03',
		fillOpacity : 0.5,
		radius : 50
	}).addTo(macarte);
	// Nous ajoutons un marqueur
	
	drone1.addTo(macarte);
	drone2.addTo(macarte);
}
window.onload = function() {
	// Fonction d'initialisation qui s'exécute lorsque le DOM est chargé
	initMap();
};
function afficherLaDrone(){
	
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
