/**
 * 
 */

function validateQty(event) {
	var key = window.event ? event.keyCode : event.which;

	if (event.keyCode == 8 || event.keyCode == 46 || event.keyCode == 37
			|| event.keyCode == 39) {
		return true;
	} else if (event.ctrlKey && key == 118) {
		return true;
	} else if (event.ctrlKey && key == 120) {
		return true;
	} else if (event.ctrlKey && key == 99) {
		return true;
	} else if (key < 48 || key > 57) {
		return false;
	} else
		return true;
};

function validateIdent(event) {
	var key = window.event ? event.keyCode : event.which;
	if (event.keyCode == 8 || event.keyCode == 46 || event.keyCode == 37
			|| event.keyCode == 39 || key == 97 || key == 98 || key == 65
			|| key == 66) {
		return true;
	} else if (event.ctrlKey && key == 118) {
		return true;
	} else if (event.ctrlKey && key == 120) {
		return true;
	} else if (event.ctrlKey && key == 99) {
		return true;
	} else if (key < 48 || key > 57) {
		return false;
	} else
		return true;
};

function validateNom(event) {
	var key = window.event ? event.keyCode : event.which;
	if (event.keyCode == 8 || event.keyCode == 46 || event.keyCode == 37
			|| event.keyCode == 39 || key == 45) {
		return true;
	} else if (key == 95) {
		return false;
	} else if (event.ctrlKey && key == 120) {
		return true;
	} else if (event.ctrlKey && key == 99) {
		return true;
	} else if (key < 65 || key > 122) {
		console.log(key);
		return false;
	} else
		return true;
};

function validateNomSociete(event) {
	var key = window.event ? event.keyCode : event.which;
	if (event.keyCode == 8 || event.keyCode == 46 || event.keyCode == 37
			|| event.keyCode == 39 || key == 46 || key == 45 || key == 32) {
		return true;
	} else if (key == 95) {
		return false;
	} else if (event.ctrlKey && key == 120) {
		return true;
	} else if (event.ctrlKey && key == 99) {
		return true;
	} else if (key < 48 || key > 57 && key < 65 || key > 122) {
		console.log(key);
		return false;
	} else
		return true;
};

function validateIndu(event) {
	var key = window.event ? event.keyCode : event.which;
	if (event.keyCode == 8 || event.keyCode == 46 || event.keyCode == 37
			|| event.keyCode == 39) {
		return true;
	} else if (event.ctrlKey && key == 118) {
		return true;
	} else if (event.ctrlKey && key == 120) {
		return true;
	} else if (event.ctrlKey && key == 99) {
		return true;
	} else if (key < 48 || key > 57) {
		return false;
	} else
		return true;
};