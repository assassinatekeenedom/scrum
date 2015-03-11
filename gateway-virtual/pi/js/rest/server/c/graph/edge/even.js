(function(){
document.addEventListener('even-shape-edge', function(event) {
        small.t0 = event.even.t0, small.t1 = event.even.t1.small, small.t2 = event.even.t2.small, small.t3 = event.even.t3.small, large.t0 = event.even.t0, large.t1 = event.even.t1.large, large.t2 = event.even.t2.large, large.t3 = event.even.t3.large;
        document.dispatchEvent(small), document.dispatchEvent(large);
    }, true);
    var small = document.createEvent("Event"), large = document.createEvent("Event");
    small.initEvent('small-even-edge', true, true);
    large.initEvent('large-even-edge', true, true);
})();