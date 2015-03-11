(function(){
var x = [
        [2, 1, 1],
        [2, 2, 2],
        [2, 1, 3]
    ], y = [
        [1, 2, 2],
        [2, 1, 2],
        [2, 2, 3]
    ], chaos = function(dx, dy, dz) {
        return {
            t0: {a: dx, b: dy, c: dz},
            t1: {large: {a: x[0][0] * dx + x[0][1] * dy + x[0][2] * -1 * dz, b: x[1][0] * -1 * dx + x[1][1] * dy + x[1][2] * dz, c: x[2][0] * -1 * dx + x[2][1] * dy + x[2][2] * dz}, small: {a: y[0][0] * -1 * dx + y[0][1] * dy + y[0][2] * dz, b: y[1][0] * -1 * dx + y[1][1] * dy + y[1][2] * dz, c: y[2][0] * -1 * dx + y[2][1] * dy + y[2][2] * dz}},
            t2: {large: {a: x[0][0] * dx + x[0][1] * dy + x[0][2] * dz, b: x[1][0] * dx + x[1][1] * -1 * dy + x[1][2] * dz, c: x[2][0] * dx + x[2][1] * -1 * dy + x[2][2] * dz}, small: {a: y[0][0] * dx + y[0][1] * dy + y[0][2] * dz, b: y[1][0] * dx + y[1][1] * dy + y[1][2] * dz, c: y[2][0] * dx + y[2][1] * dy + y[2][2] * dz}},
            t3: {large: {a: x[0][0] * dx + x[0][1] * -1 * dy + x[0][2] * dz, b: x[1][0] * dx + x[1][1] * dy + x[1][2] * dz, c: x[2][0] * dx + x[2][1] * dy + x[2][2] * dz}, small: {a: y[0][0] * dx + y[0][1] * -1 * dy + y[0][2] * dz, b: y[1][0] * dx + y[1][1] * -1 * dy + y[1][2] * dz, c: y[2][0] * dx + y[2][1] * -1 * dy + y[2][2] * dz}}
        };
    }, commit = function(shape) {
        notify.shape = shape;
        document.dispatchEvent(notify);
        notify.shape.ba = null, delete notify.shape.ba, notify.shape.ab = null, delete notify.shape.ab, notify.shape.n = null, delete notify.shape.n, notify.shape.odd = null, delete notify.shape.odd, notify.shape = null, delete notify.shape, a = null, delete a;
    }, root = function(i, n) {
        var a = 2 * n * (n + 1);
        commit({odd: true, n: n, ab: chaos(i, a, a + 1), ba: chaos(a, i, a + 1)});
        a = null, delete a;
    }, leaf = function(i, n) {
        var a = n * (n + 4);
        commit({odd: false, n: n / 2, ab: chaos(i, a + 3, a + 5), ba: chaos(a + 3, i, a + 5)});
        a = null, delete a;
    }, branch = function(n) {
        var minus = -2 * n, plus = 2 * n;
        leaf(-4 * n + 4, minus), root(minus + 1, -n), leaf(4 * n + 4, plus), root(plus + 1, n);
        plus = null, delete plus, delete minus, minus = null;
    }, relative = function(i) {
        var c = i * i, ax = i * 2, bx = i * 4;
        var a = c - bx + 4, b = c - ax + 1, d = c + bx + 4, e = c + ax + 1;
        branch(a, i - 2), branch(b, i - 1), branch(d, i + 1), branch(e, i + 2);
        a = null, delete a, ax = null, delete ax, bx = null, delete bx, c = null, delete c, d = null, delete d;
    }, tree = function(n) {
        relative(n - 2), relative(n - 1), relative(n + 1), relative(n + 2);
    }, pivot = function(a, b, c) {
        var odd = a % 2 === 1;
        var n = odd ? (a - 1) / 2 : (a - 4) / 4;
        commit({odd: odd, n: n, ab: chaos(a, b, c), ba: chaos(b, a, c)});
        odd = null, delete odd, n = null, delete n;
    }, qed = function(dx) {
        c = Math.pow(dx, Math.pow(dx, 2));
        a = Math.pow(c, c);
        b = Math.pow(a, c);
    }, round = function(shape) {
        if(shape!==null && shape!==undefined){        var a = shape.a, b = shape.b, c = shape.c;
        return {
            a: a - c,
            b: a - b,
            c: c - b,
            d: a,
            e: 2 * a,
            f: b - a,
            g: c - a,
            h: b,
            i: c,
            j: a + b,
            k: a + c,
            l: 2 * b,
            m: b + c,
            n: 2 * c
        };
     }
     return null;
;
    }, a, b, c, notify = document.createEvent("Event");
    notify.initEvent('shape', true, true);
    qed(2);
    script = {
        shape: function(time) {
            tree(time);
        },
        square: function(shape) {
            return round(shape);
        },
        truth: function(shape) {
            return truth(shape);
        },
        chaos: function(a, b, c) {
            if (b !== null && b !== undefined) {
                return pivot(a, b, c);
            }
            pivot(a.b, a.d, a.e);
        }
    };
})();