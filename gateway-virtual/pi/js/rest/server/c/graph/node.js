(function(){
document.addEventListener('shape-node', function(event) {
        var ab = event.node.ab, ba = event.node.ba;
        if (event.node.odd) {
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
    odd.initEvent('odd-shape-node', true, true);
    even.initEvent('even-shape-node', true, true);
})();