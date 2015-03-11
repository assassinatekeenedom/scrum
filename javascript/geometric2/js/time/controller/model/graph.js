(function() {
    var base = function(a, b, c) {
        return a % 2 !== 0 || b % 2 !== 0 || c % 2 === 0;
    }, id = function(a, b, c) {
        return {x: a, y: b, z: c};
    }, recursive = function(a, b, c) {
        /**
         *
         *  There are always exactly 600 recursive reductions per unit of time.
         *
         */
        return base(a, b, c) ? id(a, b, c) : recursive(a / 2, b / 2, c / 2);
    }, small = function(y) {
        return recursive(y.x, y.y, y.z);
    }, large = function(x) {
        return recursive(x.x, x.y, x.z);
    }, round = function(of) {
        return {x: {x: small(of.x.x), y: small(of.x.y)}, y: {x: small(of.y.x), y: small(of.y.y)}, z: {x: small(of.z.x), y: small(of.z.y)}};
    }, square = function(of) {
        return {x: {x: large(of.x.x), y: large(of.x.y)}, y: {x: large(of.y.x), y: large(of.y.y)}, z: {x: large(of.z.x), y: large(of.z.y)}};
    }, node = function(point) {
        var local = function(event) {
            var data = event.data[0];
            var dx = square(data.x), dy = square(data.y), x = round(data.x), y = round(data.y);
            event.root.unshift({x: {dx: dx, x: x}, y: {dy: dy, y: y}});
        };
        document.addEventListener(nd, local, true);
        var regular = point(nd);
        document.removeEventListener(nd, local, true);
        return regular;
    }, graph = function(root) {
        return {ax: node(root.ax, 'ax'), bx: node(root.bx, 'bx'), c: node(root.x, 'x'), ay: node(root.ay, 'ay'), by: node(root.by, 'by')};
    }, ac = function(a, record) {
        var n = (a - 1) / 2;
        var b = (a - 1) * (n + 1);
        return script.edge(a, b, b + 1, nb, nc, record);
    }, dc = function(a, record) {
        var n = (a - 4) / 4;
        var b = 4 * n * (n + 2) + 3;
        return script.edge(a, b, b + 2, nb, nc, record);
    }, composite = function(t, dt, record) {
        return {ax: dc(t[dt].a.b, record), bx: ac(t[dt].b.b, record), x: dc(t[dt].c.b, record), ay: ac(t[dt].d.b, record), by: dc(t[dt].e.b, record)};
    }, solid = function(t, record) {
        var start = script.node(t, nb, nd, record), local = function(event) {
            var box = event.data[0];
            event.root.unshift({a: composite(box, 'a', record), b: composite(box, 'b', record), c: composite(box, 'c', record), d: composite(box, 'd', record), e: composite(box, 'e', record)});
        };
        document.addEventListener(nc, local, true);
        var regular = start(nc);
        document.removeEventListener(nc, local, true);
        return regular;
    }, linear = function(t, record) {
        var root = solid(t, record);
        var box = root.root[0];
        return {root: root, ax: graph(box.a), bx: graph(box.b), c: graph(box.c), ay: graph(box.d), by: graph(box.e)};
    }, rest = function(n, record) {
        var data = linear(n, record), event = script.rest(nb, na, record);
        return function(named) {
            event.initEvent(named, true, true);
            event.data.unshift(data);
            event.root.unshift(event);
            document.dispatchEvent(event);
            return event;
        };
    }, standard = function(root, graph, edge, node, start) {
        var nna = root, nnb = graph, nnc = edge, nnd = node, nne = start;
        var clone = {
            root: root,
            graph: graph,
            edge: edge,
            node: node,
            start: start,
            at: function(i, record) {
                na = nna, nb = nnb, nc = nnc, nd = nnd, ne = nne;
                record.unshift(rest(i, record)(ne).type);
                return record;
            }
        };
        return clone;
    }, mvc = standard('root', 'graph', 'start', 'node', 'edge'), na, nb, nc, nd, ne;
    script.model = function() {
        return mvc;
    };
})();