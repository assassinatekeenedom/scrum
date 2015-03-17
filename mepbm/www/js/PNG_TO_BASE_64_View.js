/**
 *  Anonymous Function Wrapper
 */
(function() {
    document.addEventListener("PNG_TO_BASE_64", function(img) {
        console.log(img);
        var shrink = img.images[0];
        document.body.appendChild(shrink);
        document.body.style.position = "static";
        document.body.style.overflow = "hidden";
        var x = shrink.offsetWidth, y = shrink.offsetHeight;
        var dx = shrink.offsetWidth / window.innerWidth, dy = shrink.offsetHeight / window.innerHeight;
        var refresh = function() {
            dx = x / window.innerWidth, dy = y / window.innerHeight;
            document.body.removeChild(shrink);
            shrink.width = parseInt(x / dx);
            shrink.height = parseInt(y / dy);
            document.body.appendChild(shrink);
        };
        window.addEventListener("resize", refresh, true);
        shrink.width = parseInt(x / dx);
        shrink.height = parseInt(y / dy);
    }, true);
})();