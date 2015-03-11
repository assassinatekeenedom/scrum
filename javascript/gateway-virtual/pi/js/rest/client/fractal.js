(function(){
     var show = function(event) {
        var t = event.timeLine;
        console.table({x0: t.x0[0], x1: t.x1[0], x2: t.x2[0]});
        all(t.x0, "x0");
        all(t.x1, "x1");
        all(t.x2, "x2");
    }, all = function(ct, named) {
        console.groupCollapsed("%s", named);
        console.table(ct[2]);
        var wall = [].concat(ct[1]), info;
        while (wall.length) {
            info = wall.pop();
            console.groupCollapsed("at %i", wall.length);
            console.table(info);
            console.groupEnd();
        }
        console.groupEnd();
    };
    document.addEventListener("ready", show, true);
})();