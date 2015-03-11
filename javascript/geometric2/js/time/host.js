(function() {
    var folder = function(parent) {
        var root = parent;
        var load = function(child) {
            script(load.folder + child);
            return load;
        };
        load.folder = root + "/";
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
    }, client = function(parent, named) {
        var client = server(server(server(parent, 'view'), 'server'), named);
        var local = {
            view: function(named) {
                return server(client, 'view')(named);
            },
            model: function(named) {
                return server(client, 'model')(named);
            },
            controller: function(named) {
                return server(client, 'controller')(named);
            }
        };
        return local;
    };

    var controller = server({folder: 'time/'}, 'controller');
    var gui = client(controller, 'normal');
    server({folder: 'time/'}, 'model')('object')('style')('option')('select');
    server(controller, 'controller')('rest');
    server(server(controller, 'model')('graph'), 'part')('edge')('node');
    gui.controller('builder');
    gui.model('timeline');
    gui.view('select');
    var view = server({folder: 'time/'}, 'view')('timeline');
    server(view, 'controller');
})();