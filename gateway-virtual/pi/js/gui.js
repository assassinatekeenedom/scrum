(function(){
    var folder = function(parent) {
        var load = function(child) {
            require.src('js/' + load.folder + child + '.js');
            document.dispatchEvent(require);
            return load;
        };
        load.folder = parent + "/";
        return load;
    }, host = function(parent) {
        var origin = folder(parent);
        var mask = function(named) {
            origin(named);
            return mask;
        };
        mask.folder = origin.folder;
        return mask;
    }, server = function(server, client) {
        return host(server.folder + client);
    }, prepare = function(large, small) {
        server(large, 'even')('at'), server(large, 'odd')('at'), server(small, 'even')('at'), server(small, 'odd')('at');
    }, basis = function(part) {
        prepare(server(part, 'small'), server(part, 'large'));
    }, chart = function(t) {
        basis(server(t, 'edge')), basis(server(t, 'node'));
    }, faces = function(faces) {
        chart(server(faces, 't0')), chart(server(faces, 't1')), chart(server(faces, 't2')), chart(server(faces, 't3'));
    }, rest = function(root, parent) {
        var controller = server({folder: root + '/'}, parent);
        var model = server(server(controller, 'c')('graph'), 'graph')('edge')('node');
        server(controller, 'm')('shape');
        server(server(model, 'edge')('even')('odd'), 'size')('small')('large');
        server(server(model, 'node')('even')('odd'), 'size')('small')('large');
        faces(server(controller, 'v'));
    }, require = document.createEvent("Event");
    require.initEvent("script", true, true);
    document.dispatchEvent(require);
    rest('rest', 'server');
    require.src('pi/js/rest/client/cycle.js'),    require.src('pi/js/rest/client/chaos.js');    require.src('pi/js/rest/client/fractal.js');})();