/**
 *  Anonymous Function Wrapper
 */
(function() {
    var convertImgToBase64URL = function(url, callback, outputFormat) {
        var canvas = document.createElement('CANVAS'),
                ctx = canvas.getContext('2d'),
                img = new Image;
        img.crossOrigin = 'Anonymous';
        img.onload = function() {
            var dataURL;
            canvas.height = img.height;
            canvas.width = img.width;
            ctx.drawImage(img, 0, 0);
            dataURL = canvas.toDataURL(outputFormat);
            callback(dataURL);
            canvas = null;
        };
        img.src = url;
    }, refresh = function(src) {
        img.src = src;
        document.dispatchEvent(img);
    }, type = "PNG_TO_BASE_64", img = document.createEvent("Event");
    img.initEvent(type, true, true);
    PNG_TO_BASE_64 = function(game, nation, turn, page) {
        var convert = 'http://localhost/mepbm/'
        convert += 'g' + game;
        convert += 'n' + nation;
        convert += 't' + turn;
        convert += '-' + page + '.png';
        console.warn("loading: " + convert);
        convertImgToBase64URL(convert, refresh, true);
    };
})();