(function() {
    var stylesheet = function() {
        var style = document.createElement('style');
        var reset = function() {
            document.head.appendChild(style);
        };
        reset();
        var proxy = function(title, element, clean) {
            if (clean) {
                if (element.className.indexOf(title) > 0) {
                    element.className = element.className.replace(' ' + title, '');
                    return;
                }
                if (element.className.indexOf(' ')) {
                    element.className = element.className.replace(title + ' ', '');
                    return;
                }
                element.className = element.className.replace(title + '', '');
            }
            if (element.className.indexOf(title) > -1) {
                return;
            }
            if (element.className.length) {
                element.className += ' ';
            }
            element.className += title;
        };
        var selectors = [[], []];
        var create = function(local) {
            var key = selectors[0].indexOf(local);
            if (key < 0) {
                var name = local,
                        type = '.',
                        properties = [[], []];
                var product = null;
                var promote = function() {
                    var backup = promote;
                    promote = function() {
                        promote = backup;
                        style.removeChild(product);
                        promote();
                    };
                    product = document.createTextNode(type + name + '{' + properties[1].join('') + '}');
                    style.appendChild(product);
                };
                var pattern = function(name, value) {
                    var key = properties[0].indexOf(name);
                    if (key < 0) {
                        properties[0].unshift(name),
                                properties[1].unshift(name + ':' + value + ';');
                        key = 0;
                    }
                    if (value) {
                        properties[1][key] = name + ':' + value + ';';
                    }
                    return function(name, value) {
                        return pattern(name, value);
                    };
                };
                pattern.promote = function() {
                    promote();
                };
                pattern.as = {
                    name: function() {
                        type = '.';
                    },
                    id: function() {
                        type = '#';
                    },
                    i: function() {
                        type = '';
                    }
                };
                pattern.toggle = function(element, clean) {
                    proxy(name, element, clean);
                };
                selectors[0].unshift(name), selectors[1].unshift(pattern), key = 0;
            }
            return selectors[1][key];
        };
        return function(rule) {
            return create(rule);
        };
    };
    var css = stylesheet();
    html.rule = function(named) {
        return css(named);
    };
})();