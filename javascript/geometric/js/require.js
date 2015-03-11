(function() {
    require = function(src) {
        var script = document.createElement("script");
        script.type = 'text/javascript';
        script.src = src;
        script.async = true;
        document.head.appendChild(script);
        document.head.removeChild(script);
    };
    window.addEventListener('load', function() {
        require('js/logic/style.js');
        require('js/logic/greek.js');
        
        require('js/gui/html.js');
    }, true);
})();