var reportSelect;

$(function() {
    $.post('serve/parse', function(data) {
        $('#gameSelect').html(data);
        makeDraggable();
    });
    $( "#charactergrowth" ).draggable({
	helper: "clone",
	revert: "invalid",
        start: function() {
            reportSelect = this;
        }
    });
    $( "#pcgrowth" ).draggable({
	helper: "clone",
	revert: "invalid",
        start: function() {
            reportSelect = this;
        }
    });
    
    $( "#reportDrop" ).droppable({
        drop: function( event, ui ) {
            loadingScreen();
            $( "#reportDrop" ).attr("class", $("#"+reportSelect.id).attr("class") + " ahighlight");
            $( "#reportDrop" ).html("<br />" + $("#"+reportSelect.id+"Val").html() );
            $( "#reports" ).hide();            
            mapScreen();
            reloadScripts();
        }
    });
});

function makeDraggable(){
    $( ".gameselect").draggable({
	helper: "clone",
	revert: "invalid",
        start: function() {
            reportSelect = this;
        }
    });
}

function revertReportSelection(){    
    $( "#reportDrop" ).attr("class", "reportDrop");
    $( "#reportDrop" ).html( "<br />Report Selection<br /><span class=\"details\">(Drop Here)</span>" );
    $( "#reports" ).show();
    $( "#reportDrop" ).attr("onclick", "");
    reportSelect = null;
    reloadScripts();
}

function runCharacterGrowth(){
    $( "body" ).append("<div id=\"popDisplay\"></div>");
    $("#popDisplay").colorbox({href:"/mepbm/characterGrowth/index.jsp", open: true});
}
function runPCGrowth(){
    $( "body" ).append("<div id=\"popDisplay\"></div>");
    $("#popDisplay").colorbox({href:"/mepbm/pcGrowth/index.jsp", open: true });
}
function loadingScreen(){
    $( "#map" ).attr("class", "loading");
    return false;
}
function mapScreen(){
    $( "#map" ).attr("class", "map");
    return false;
}
function reloadScripts() {
    $.getScript('ogclient/load.js')
}