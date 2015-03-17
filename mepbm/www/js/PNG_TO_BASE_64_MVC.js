/**
 *  Anonymous Function Wrapper
 */
(function() {
    var type = "PNG_TO_BASE_64";
    document.addEventListener(type, function(img) {
        console.log(img);
        var shrink = img.images[0];
        document.body.appendChild(shrink);
        var x = shrink.offsetWidth, y = shrink.offsetHeight;
        var dx = shrink.offsetWidth / window.innerWidth, dy = shrink.offsetHeight / window.innerHeight;
        var refresh = function() {
            console.warn("refresh");
            dx = shrink.offsetWidth / window.innerWidth, dy = shrink.offsetHeight / window.innerHeight;
            document.body.removeChild(shrink);
            shrink.width = parseInt(x / dx);
            shrink.height = parseInt(y / dy);
            console.warn(shrink);
            document.body.appendChild(shrink);
        };
        window.addEventListener("resize", refresh, true);
        shrink.width = parseInt(x / dx);
        shrink.height = parseInt(y / dy);
    }, true);

    var builder = function(game, nation, turn, page) {
        return 'http://localhost/mepbm/' + 'g' + game + 'n' + nation + 't' + turn + '-' + page + '.png';
    }
    PNG_TO_BASE_64(builder('143', '05', '000', '8'));
})();