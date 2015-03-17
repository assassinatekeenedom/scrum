/**
 *  Anonymous Function Wrapper
 */
(function() {
    var type = "PNG_TO_BASE_64";
    document.addEventListener(type, function(img) {
        console.log(img);
        var html = document.createElement("img");
        html.src = img.src;
        document.body.appendChild(html);
    }, true);
})();