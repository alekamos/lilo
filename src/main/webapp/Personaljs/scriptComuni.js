/*
$.datepicker.regional['it'] = {clearText: 'Effacer', clearStatus: '',
    closeText: 'Chiudi', closeStatus: 'Chiudi senza modificare',
    prevText: '<Prec', prevStatus: 'Mese precendente',
    nextText: 'Succ>', nextStatus: 'Mese successivo',
    currentText: 'Courant', currentStatus: 'Voir le mois courant',
    monthNames: ['Gennaio','Febbraio','Marzo','Aprile','Maggio','Giugno',
    'Luglio','Agosto','Settembre','Ottobre','Novembre','Dicembre'],
    monthNamesShort: ['Gen','Feb','Mar','Apr','Mag','Giu',
    'Lug','Ago','Set','Ott','Nov','Dic'],
    monthStatus: 'Scegli un altro mese', yearStatus: 'Scegli un altro anno',
    weekHeader: 'Sm', weekStatus: '',
    dayNames: ['Domenica','Lunedì','Martedì','Mercoledì','Giovedì','Venerdì','Sabato'],
    dayNamesShort: ['Dom','Lun','Mar','Mer','Gio','Ven','Sab'],
    dayNamesMin: ['Do','Lu','Ma','Me','Gi','Ve','Sa'],
    dayStatus: 'Utiliser DD comme premier jour de la semaine', dateStatus: 'Choisir le DD, MM d',
    dateFormat: 'dd/mm/yy', firstDay: 1,
    yearRange: "-100:+0",
    changeMonth: true,
    changeYear: true,
    showButtonPanel: true,
    initStatus: 'Choisir la date', isRTL: false};
 $.datepicker.setDefaults($.datepicker.regional['it']);
*/

 

$(document).ready(function() {


	//Datepicker pronto al caricamento della pagina
	$(".jqDatePicker").datepicker({
		dateFormat: "dd/mm/yy",
		changeMonth: true,
		changeYear: true
	});
	
	//datetimepicker
	$(".jqDateTimePicker").datetimepicker();
	
	//timepicker only
	$(".jqTimePicker").timepicker();


});




function ajaxCall(urlWithParam,divDaAggiornare){
	$("#"+divDaAggiornare).fadeOut( 50 );
	$.ajax({
		type:"GET",
		url: urlWithParam,
		success: function(data){
			// Now you have your HTML in "data", do whatever you want with it here in this function         
			$("#"+divDaAggiornare).html(data).fadeIn( 200 );
		}
	});
}


function ajaxCallWParam(urlWithoutParam,param,divDaAggiornare){
	$("#"+divDaAggiornare).fadeOut( 50 );
	$.ajax({
		type:"GET",
		url: urlWithoutParam+param,
		success: function(data){
			// Now you have your HTML in "data", do whatever you want with it here in this function         
			$("#"+divDaAggiornare).html(data).fadeIn( 200 );
		}
	});
}


function mostraDiv(idElemento){
	$("#"+idElemento).fadeIn( 250 );

}

function nascondiDiv(idElemento){
	$("#"+idElemento).fadeOut( 250 );
}

function fadeinFadeOutDiv(idElemento){

	$( "#"+idElemento ).fadeIn( 500 ).delay( 1500 ).fadeOut( 500 );

}


/* Metodo per mettere un pezzettino di pagina HTML IN UNA JSP formando una jsp
var httpreq = false;
var ruolo = "";
var servizio = "";

if(navigator.appName == 'Microsoft Internet Explorer')
	httpreq = new ActiveXObject('Microsoft.XMLHTTP');
else
	httpreq = new XMLHttpRequest();

/** 
 * Funzione che sostituisce il contenuto HTML di un nodo della pagina. 
 * 
 * @param    nodeId ID del nodo 
 * @param    html   codice HTML da sostituire a quello del nodo 

function updateContent(nodeId, html) { 
    var node = document.getElementById(nodeId); 
    if(null == node) { 
        alert("[ERRORE] L'elemento " + nodeId + " non esiste"); 
        return; 
    } 
    node.innerHTML = html; 
    node.style.visibility = "visible"; 
    node.style.display = "block";
} 

/** 
 * Richiede al web server il contenuto di una pagina (testo o HTML) in maniera asincrona. 
 * @param    nodeId    ID dell'elemento della pagina che conterr� il codice HTML 
 * @param    url       URL della servlet da chiamare  

function showContent(nodeId, url, parametro) { 

    if(!httpreq) { 
        alert("Il browser non supporta l'oggetto httpreqRequest"); 
        return false; 
    } 

    httpreq.open("GET", url+parametro , true); 
    httpreq.onreadystatechange=function() { 
        if (httpreq.readyState==4) { 
            if (httpreq.status==200) { 
                updateContent(nodeId, httpreq.responseText); 
            } else if (httpreq.status==404) { 
                alert("[ERRORE] l'URL "+url+" non esiste!"); 
            } else { 
                //alert("[ERRORE] errore non gestito (" + httpreq.status + ")"); 
            } 
        } 
    }; 

    httpreq.send(null); 
} 

 */