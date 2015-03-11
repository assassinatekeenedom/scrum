(function() {
    var local = function(data) {
        if (data.x !== undefined) {
            xywall.unshift([data.x, data.y]);
            if (xywall.length === 5) {
                xyevent.data = [].concat(xywall);
                document.dispatchEvent(xyevent);
                xywall = [];
            }
            return;
        }
        xwall.unshift(data);
        if (xwall.length === 5) {
            xevent.data = [].concat(xwall);
            document.dispatchEvent(xevent);
            xwall = [];
        }
    };
    var xwall = [], xywall = [];
    var xevent = document.createEvent("Event"), xyevent = document.createEvent("Event");
    xevent.initEvent('x-options', true, true);
    xyevent.initEvent('xy-options', true, true);
    var mvc = script.builder(), member;
    for (member in mvc) {
        if (member !== 'at') {
            document.addEventListener(mvc[member], function(event) {
                local(event.data);
            }, true);
        }
    }
})();