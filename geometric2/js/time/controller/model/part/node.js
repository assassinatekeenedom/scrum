(function() {
    var round = function(a, b) {
        a.push(b);
        return a;
    }, square = function(a, b) {
        a.push(Math.pow(b, 2));
        return a;
    }, root = function(n) {
        return t(Math.sqrt(n), true);
    }, t = function(t, r) {
        var b = [t - 2, t - 1, t, t + 1, t + 2].reduce(square, []);
        if (!r) {
            return {
                a: root(b[0]),
                b: root(b[1]),
                c: root(t * t),
                d: root(b[2]),
                e: root(b[3]),
                f: root(b[4])
            };
        }
        var n2 = 2 * t, n4 = 4 * t;
        var a = [-n4 + 4, -n2 + 1, -n2, n2 + 1, n4 + 4].reduce(round, []), c = b[2];
        return {
            a: {
                a: b[0],
                b: a[0],
                c: c
            },
            b: {
                a: b[1],
                b: a[1],
                c: c
            },
            c: {
                a: b[2],
                b: a[2],
                c: a[2] + c
            },
            d: {
                a: b[3],
                b: a[3],
                c: c
            },
            e: {
                a: b[4],
                b: a[4],
                c: c
            }
        };
    }, rest = function(n, a, b, record) {
        var data = t(n), event = script.rest(a, b, record);
        return function(named) {
            event.initEvent(named, true, true);
            event.data.unshift(data);
            document.dispatchEvent(event);
            return event;
        };
    };
    script.node = function(n, na, nb, record) {
        return rest(n, na, nb, record);
    };
})();