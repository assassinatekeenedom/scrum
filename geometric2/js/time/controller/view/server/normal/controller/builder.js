(function() {
    var root = function(abc, when) {
        if (abc.z !== undefined) {
            return {
                a: root(abc.x, ['x', 'x', 'x']),
                b: root(abc.y, ['y', 'y', 'y']),
                c: root(abc.z, ['z', 'z', 'z'])
            };
        }
        if (abc.x !== undefined) {
            return html.option(when)([abc.x.x, abc.x.y, abc.x.z]);
        }
        return (abc.a - abc.b) === abc.c ? html.option(when)([abc.a, abc.b, abc.c]) : html.option(when)([abc.a, -abc.b, abc.c]);
    }, branch = function(a) {
        return {
            a: root(a.a, ['a', 'a', 'a']),
            b: root(a.b, ['b', 'b', 'b']),
            c: root(a.c, ['c', 'c', 'c']),
            d: root(a.d, ['d', 'd', 'd']),
            e: root(a.e, ['e', 'e', 'e'])
        };
    }, known = function(a, b) {
        return {
            a: root(a),
            b: root(b)
        };
    }, by = function(master) {
        return known(master.x, master.y);
    }, of = function(master) {
        return known(master.x.x, master.y.y);
    }, every = function(details) {
        var wall = [].concat(details), future = [];
        while (wall.length) {
            future.push(by(wall.shift()));
        }
        return future;
    }, other = function(details) {
        var wall = [].concat(details), future = [];
        while (wall.length) {
            future.push(of(wall.shift()));
        }
        return future;
    }, relative = function(trace, at, of) {
        return {
            x: every(trace[at][of].data),
            y: other(trace[at][of].root)
        };
    }, both = function(trace, at) {
        data.at(relative(trace, at, 'ax'), relative(trace, at, 'bx'), relative(trace, at, 'c'), relative(trace, at, 'ay'), relative(trace, at, 'by'));
    }, edges = function(event) {
        var trace = event.data[0];
        both(trace, 'ax');
        both(trace, 'ay');
        both(trace, 'c');
        both(trace, 'bx');
        both(trace, 'by');
    }, nodes = function(event) {
        var trace = event.data[0];
        data.at(branch(trace.a), branch(trace.b), branch(trace.c), branch(trace.e), branch(trace.f));
    }, standard = function(root, graph, edge, node, start) {
        var ax = document.createEvent("Event"), bx = document.createEvent("Event"), cx = document.createEvent("Event"), dx = document.createEvent("Event"), ex = document.createEvent("Event");
        ax.initEvent(root, true, true), bx.initEvent(graph, true, true), cx.initEvent(edge, true, true), dx.initEvent(node, true, true), ex.initEvent(start, true, true);
        var clone = {
            root: root,
            graph: graph,
            edge: edge,
            node: node,
            start: start,
            at: function(root, graph, edge, node, start) {
                ax.data = root, bx.data = graph, cx.data = edge, dx.data = node, ex.data = start;
                document.dispatchEvent(ax);
                document.dispatchEvent(bx);
                document.dispatchEvent(cx);
                document.dispatchEvent(dx);
                document.dispatchEvent(ex);
                return {
                    a: ax.data,
                    b: bx.data,
                    c: cx.data,
                    d: dx.data,
                    e: ex.data
                };
            }
        };
        return clone;
    };
    var graph = script.model();
    document.addEventListener(graph.edge, nodes, true);
    document.addEventListener(graph.start, edges, true);
    var data = standard('(n-2)', '(n-1)', '(n)', '(n+1)', '(n+2)');
    script.builder = function() {
        return data;
    };
})();