/**
 *  Anonymous Function Wrapper
 */
(function() {
    var type = "PNG_TO_BASE_64";
    var images = [];
    document.addEventListener(type, function(img) {
        var html = document.createElement("img");
        html.src = img.src;
        html.className = type;
        images.unshift(html);
        img.images = images;
    }, true);
})();