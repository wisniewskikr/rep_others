$(function() {
	$( document ).tooltip();
});

function add(a, b) {
	var result = a + b;

	if (result >= 1000000) {
		return NaN;
	}

	return result;
}

function subtract(a, b) {
	var result = a - b;

	if (result <= -1000000) {
		return NaN;
	}

	return result;
}

function tmp() {
	alert("aaa");
}