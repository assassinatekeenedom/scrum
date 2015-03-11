html = {
    size: function(element) {
        document.body.appendChild(element);
        var collect = {
            width: element.offsetWidth,
            height: element.offsetHeight,
            element: element
        };
        document.body.removeChild(element);
        return collect;
    }};