/**
 *  Anonymous Function Wrapper
 */
(function() {
    var convertImgToBase64URL = function(url, callback, outputFormat) {
        var height = null;
        var canvas = document.createElement('CANVAS'),
                ctx = canvas.getContext('2d'),
                img = new Image;
        img.crossOrigin = 'Anonymous';
        img.onload = function() {
            var dataURL;
            height = img.height;
            canvas.height = height;
            canvas.width = img.width;
            ctx.drawImage(img, 0, 0);
            dataURL = canvas.toDataURL(outputFormat);
            callback(dataURL);
            canvas = null;
        };
        img.src = url;
        img.base64Height = function(){
            return height;
        }
    }, refresh = function(src) {
        img.src = src;
        document.dispatchEvent(img);
    }, type = "PNG_TO_BASE_64", img = document.createEvent("Event");
    img.initEvent(type, true, true);
    PNG_TO_BASE_64 = function(src) {
        console.warn("loading: " + src);
        convertImgToBase64URL(src, refresh, true);
    };
})();