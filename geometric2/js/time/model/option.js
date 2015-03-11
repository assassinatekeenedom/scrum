(function() {
    html.option = function(all) {
        var wall = [], awall = [].concat(all), option;
        while (awall.length) {
            option = document.createElement('option');
            option.value = awall.shift();
            wall.unshift(option);
        }
        return function(all) {
            var awall = [].concat(all), wwall = [].concat(wall), results = [], prep;
            while (awall.length) {
                prep = wwall.pop();
                prep.appendChild(document.createTextNode(awall.shift()));
                results.unshift(prep);
            }
            return results;
        };
    };
})();