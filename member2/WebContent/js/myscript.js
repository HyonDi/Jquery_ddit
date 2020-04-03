/**
 * 
 */

function proc2() {
	/*외부 스타일*/
	area = document.getElementsByTagName("textarea")[0];
	
	r = parseInt(Math.random() * 255);
	g = parseInt(Math.random() * 255);
	b = parseInt(Math.random() * 255);
	
	area.style.border = '10px solid rgb(' + r + ',' + g + ',' + b + ')';
	
}