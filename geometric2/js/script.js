(function() {
    var load = function(src) {
        var script = document.createElement("script");
        script.type = 'text/javascript';
        script.src = 'js/' + src + '.js';
        script.async = true;
        document.head.appendChild(script);
        document.head.removeChild(script);
    };
    window.setTimeout(function() {
        script = function(src) {
            window.setTimeout(function(src) {
                load(src);
            }, 0, src);
        };
        load('time/host');
    }, 0);
})();