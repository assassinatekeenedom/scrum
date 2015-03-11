(function(){
document.addEventListener('large-odd-edge', function(event) {
        t0.t0 = event.t0, t1.t1 = event.t1, t2.t2 = event.t2, t3.t3 = event.t3;
        document.dispatchEvent(t0), document.dispatchEvent(t1), document.dispatchEvent(t2), document.dispatchEvent(t3);
    }, true);
    document.addEventListener('large-even-edge', function(event) {
        et0.t0 = event.t0, et1.t1 = event.t1, et2.t2 = event.t2, et3.t3 = event.t3;
        document.dispatchEvent(et0), document.dispatchEvent(et1), document.dispatchEvent(et2), document.dispatchEvent(et3);
    }, true);
    var t0 = document.createEvent("Event"), t1 = document.createEvent("Event"), t2 = document.createEvent("Event"), t3 = document.createEvent("Event"), et0 = document.createEvent("Event"), et1 = document.createEvent("Event"), et2 = document.createEvent("Event"), et3 = document.createEvent("Event");
    t0.initEvent('large-odd-edge-t0', true, true), t1.initEvent('large-odd-edge-t1', true, true), t2.initEvent('large-odd-edge-t2', true, true), t3.initEvent('large-odd-edge-t3', true, true), et0.initEvent('large-even-edge-t0', true, true), et1.initEvent('large-even-edge-t1', true, true), et2.initEvent('large-even-edge-t2', true, true), et3.initEvent('large-even-edge-t3', true, true);
})();