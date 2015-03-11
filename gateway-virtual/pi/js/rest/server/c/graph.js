(function(){
var time = document.createElement("input"), restart = document.createElement("input");
    var graph = [[], [], []];
    document.addEventListener('shape', function(event) {
        var data = event.shape;
        var key = graph[0].indexOf(data.n);
        if (key < 0) {
            graph[0].unshift(data.n), graph[1].unshift([]), graph[2].unshift([]);
            node.node = data;
            document.dispatchEvent(node);
        }
        graph[1].unshift(data.ab), graph[2].unshift(data.ab);
        edge.edge = data;
        document.dispatchEvent(edge);
    }, true);
    time.addEventListener('change', function() {
        var c=parseInt(time.value);        script.shape(c);
        document.dispatchEvent(ready);
    }, true);
    var refresh = function() {
        graph = [[], [], []];
        document.dispatchEvent(reset);
    };
    var edge = document.createEvent("Event"), node = document.createEvent("Event"), ready = document.createEvent("Event"), reset = document.createEvent("Event");
    edge.initEvent('shape-edge', true, true),
    node.initEvent('shape-node', true, true),
    ready.initEvent('ready', true, true),
    reset.initEvent('reset', true, true);
    restart.type = 'button';
    restart.value = ' Reset Timeline ';
    restart.addEventListener('mouseup', refresh, true);
    document.body.appendChild(time);
    document.body.appendChild(restart);
})();