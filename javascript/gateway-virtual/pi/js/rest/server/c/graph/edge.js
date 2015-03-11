(function(){
document.addEventListener('shape-edge', function(event) {
        var ab = event.edge.ab, ba = event.edge.ba;
        if (event.edge.odd) {
            odd.odd = ab;
            document.dispatchEvent(odd);
            even.even = ba;
            document.dispatchEvent(even);
        } else {
            odd.odd = ba;
            document.dispatchEvent(odd);
            even.even = ab;
            document.dispatchEvent(even);
        }
    }, true);
    var odd = document.createEvent("Event"), even = document.createEvent("Event");
    odd.initEvent('odd-shape-edge', true, true);
    even.initEvent('even-shape-edge', true, true);
})();