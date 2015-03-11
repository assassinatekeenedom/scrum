(function(require) {
    var ol = function(type, parent) {
        var list = document.createElement("ol");
        list.type = type;
        var root = document.body;
        if (parent !== null && parent !== undefined) {
            root = parent;
        }
        return function(l) {
            var temp = document.createElement("li");
            temp.innerHTML = l;
            list.appendChild(temp);
            return function() {
                root.appendChild(list);
                return function() {
                    root.removeChild(table);
                };
            };
        };
    };
    var table = function(parent) {
        var table = document.createElement("table"), tr = document.createElement("tr"), tda = document.createElement("td"), tdb = document.createElement("td"), tdc = document.createElement("td");
        var root = document.body;
        if (parent !== null && parent !== undefined) {
            root = parent;
        }
        return function(a, b, c, html) {
            if (html) {
                tda.innerHTML = a;
                tdb.innerHTML = b;
                tdc.innerHTML = c;
            } else {
                tda.appendChild(a);
                tdb.appendChild(b);
                tdc.appendChild(c);
            }
            tr.appendChild(tda);
            tr.appendChild(tdb);
            tr.appendChild(tdc);
            table.appendChild(tr);
            tr = document.createElement("tr"), tda = document.createElement("td"), tdb = document.createElement("td"), tdc = document.createElement("td");
            return function() {
                root.appendChild(table);
                return function() {
                    root.removeChild(table);
                };
            };
        };
    };
    require.html = {
        ol: function(type, parent) {
            return ol(type, parent);
        },
        table: function(parent) {
            return table(parent);
        }
    };
    require('js/gui/nav.js');

})(require);