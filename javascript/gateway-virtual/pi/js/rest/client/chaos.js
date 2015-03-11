(function(){
    var sort = function(a, b) {
        if (a < b)
            return 1;
        else if (a > b)
            return -1;
        return 0;
    }, resolve = function(xi, yi, zi) {
        var relative = [].concat(xi).sort(sort);
        var xref = {a: xi.reverse(), b: relative.reverse(), c: zi.reverse()};
        var wall = [].concat(xref.b), last = [[], [], []], key;
        while (wall.length) {
            key = xref.a.indexOf(wall.shift());
            last[0].push(yi[0][key]), last[1].push(yi[1][key]), last[2].push(xref.c[key]);
        }
        return last;
    }, unique = function(cache) {
        var wall = [].concat(cache[1]), c = [], d = [];
        while (wall.length) {
            var i = wall.shift()[0]
            c.unshift(i.d), d.unshift(i);
        }
        return resolve(c, cache, d);
    }, learn = function(c) {
        var cache = [[], []], wall = [].concat(c), key;
        while (wall.length) {
            var key = cache[0].indexOf(wall[0].d);
            if (key < 0) {
                key = 0, cache[0].unshift(wall[0].d), cache[1].unshift([]);
            }
            cache[1][key].unshift(wall.shift());
        }
        return cache;
    }, load = function(event) {
        var cache = [learn(c[0]), learn(c[1]), learn(c[2])];
        event.timeLine = {
            ab: [].concat(abba[0]),
            ba: [].concat(abba[1]),
            dc: [].concat(order[0]),
            fe: [].concat(order[1]),
            abc: [].concat(order[2]),
            t0: [].concat(details[0]),
            t1: [].concat(details[1]),
            t2: [].concat(details[2]),
            t3: [].concat(details[3]),
            small: [].concat(details[4]),
            large: [].concat(details[5]),
            odd: [].concat(details[6]),
            even: [].concat(details[7]),
            node: [].concat(details[8]),
            edge: [].concat(details[9]),
            regular: [].concat(c),
            x0: unique(cache[0]),
            x1: unique(cache[1]),
            x2: unique(cache[2])
        };
    }, process = function(event) {
        var timeline = event.root.timeLine, key = xref.indexOf(event.type);
        if (timeline.c > timeline.d) {
            order[0].indexOf(timeline) < 0 ? order[0].push(timeline) : null;
        } else if (timeline.e > timeline.f) {
            order[1].indexOf(timeline) < 0 ? order[1].push(timeline) : null;
        } else {
            order[2].indexOf(timeline) < 0 ? order[2].push(timeline) : null;
            if (c[timeline.c] === null || c[timeline.c] === undefined) {
                c[timeline.c] = [];
            }
            c[timeline.c].indexOf(timeline) < 0 ? c[timeline.c].push(timeline) : null;
        }
        timeline.d < timeline.h ? abba[0].push(timeline) : abba[1].push(timeline), details[key].push(timeline);
    }, reset = function() {
        abba = [[], []], c = [[], [], []], order = [[], [], []], details = [[], [], [], [], [], [], [], [], [], []];
    }, abba = [[], []], c = [[], [], []], order = [[], [], []], details = [[], [], [], [], [], [], [], [], [], []], xref = ['t0', 't1', 't2', 't3', 'small', 'large', 'odd', 'even', 'node', 'edge'];
    document.addEventListener("ready", load, true);
    document.addEventListener("small", process, true);
    document.addEventListener("large", process, true);
    document.addEventListener("odd", process, true);
    document.addEventListener("even", process, true);
    document.addEventListener("node", process, true);
    document.addEventListener("edge", process, true);
    document.addEventListener("t0", process, true);
    document.addEventListener("t1", process, true);
    document.addEventListener("t2", process, true);
    document.addEventListener("t3", process, true);
    document.addEventListener("reset", reset, true);
})();