(function() {
    var rest = function(parent, child, cache) {
        var i = cache[0].indexOf(parent);
        if (i < 0) {
            i = 0, cache[0].unshift(parent), cache[1].unshift([[], []]);
        }
        var j = cache[1][i][0].indexOf(child);
        if (j < 0) {
            var event = document.createEvent("Event");
            event.data = [];
            event.root = [];
            j = 0, cache[1][i][0].unshift(child), cache[1][i][1].unshift(event);
        }
        return cache[1][i][1][j];
    }, mvc, find = function(xmvc, t) {
        mvc = xmvc;
        return mvc.at(t, [[], []]);
    };
    script.mvc = function() {
        return mvc;
    };
    script.rest = function(parent, child, graph) {
        return rest(parent, child, graph);
    };
    script.server = function(t) {
        find(script.model(), t);
        return t;
    };
})();