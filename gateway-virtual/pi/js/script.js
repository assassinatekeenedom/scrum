(function(){var aware = function(global, script, key) {
        var time = Date.now();
        return require.src('http://localhost/io/'+global+'/write/' + ((time - 2) * qed) + '-' + ((time - 1) * qed) + '-' + ((time + 1) * qed) + '-' + ((time + 2) * qed) + '.js?name=' + key + '&path=' + encodeURIComponent('NIO.root+/www/js') + '&content=' + encodeURIComponent(script));
    }, linear = function(script, global) {
        return aware(global, script);
    }, future = function(script, global) {
        return linear(script, global);
    }, require = document.createEvent('Event'), qed = 299792458;
    require.initEvent('script', true, true);
    document.dispatchEvent(require);
    require.src('js/event.js');
    document.addEventListener('future',function(event){
        event.script = function(source, named){
            return future(source, named);
        };
    },true);
})();