/**
 *  Anonymous Function Wrapper
 */
(function() {
    var images = [];
    document.addEventListener("PNG_TO_BASE_64", function(img) {
        var html = document.createElement("img");
        html.src = img.src;
        images.unshift(html);
        img.images = images;
    }, true);
})();