(function(){var cats = [
        ["small", "large"],
        ["odd", "even"],
        ["node", "edge"],
        ["t0", "t1", "t2", "t3"]
    ], events = [
        [document.createEvent("Event"), document.createEvent("Event")],
        [document.createEvent("Event"), document.createEvent("Event")],
        [document.createEvent("Event"), document.createEvent("Event")],
        [document.createEvent("Event"), document.createEvent("Event"), document.createEvent("Event"), document.createEvent("Event")]
    ], copy=function(event,named,parent){        event.initEvent(named,true,true),event.root = parent;        document.dispatchEvent(event);}, label = function(a, b, c, d) {
        var cache = [a, b, c, d], xref = [cats[0].indexOf(a), cats[1].indexOf(b), cats[2].indexOf(c), cats[3].indexOf(d)], load = function(event) {
            event.type = [].concat(cache);
            copy(events[0][xref[0]],cats[0][xref[0]],event),            copy(events[1][xref[1]],cats[1][xref[1]],event),            copy(events[2][xref[2]],cats[2][xref[2]],event),             copy(events[3][xref[3]],cats[3][xref[3]],event);
        };
        document.addEventListener(cache.join("-"), load, true);
    }, walla = [].concat(cats[0]), wallb, wallc = [].concat(cats[0]), walld = [].concat(cats[0]), a, b, c, d;
    while (walla.length) {
        a = walla.shift(), wallb = [].concat(cats[1]);
        while (wallb.length) {
            b = wallb.shift(), wallc = [].concat(cats[2]);
            while (wallc.length) {
                c = wallc.shift(), walld = [].concat(cats[3]);
                while (walld.length) {
                    d = walld.shift();
                    label(a, b, c, d);
                }
            }
        }
    }

})();