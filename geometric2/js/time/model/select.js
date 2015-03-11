(function() {
    html.select = function(all) {
        var wall = [], awall = [].concat(all), select, selected;
        while (awall.length) {
            select = document.createElement('select');
            var xref = awall.pop();
            select.name = xref;
            selected = document.createElement('option');
            selected.value = xref;
            selected.appendChild(document.createTextNode(xref));
            selected.selected = true;
            select.appendChild(selected);
            wall.unshift(select);
        }
        return function(all) {
            var awall = [].concat(all), wwall = [].concat(wall), results = [], prep;
            while (awall.length) {
                prep = wwall.pop();
                prep.appendChild(awall.shift());
                results.unshift(prep);
            }
            return results;
        };
    };
})();