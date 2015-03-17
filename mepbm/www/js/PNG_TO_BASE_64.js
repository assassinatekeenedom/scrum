/**
 *  Anonymous Function Wrapper
 */
(function() {
    /**
     * Convert an image 
     * to a base64 url
     * @param  {String}   url         
     * @param  {Function} callback    
     * @param  {String}   [outputFormat=image/png]           
     */

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
    mepbm = function(game, nation, turn, page) {
        var convert = 'http://localhost/mepbm/'
        convert += 'g' + game;
        convert += 'n' + nation;
        convert += 't' + turn;
        convert += '-' + page + '.png';
        console.warn("loading: " + convert);
        convertImgToBase64URL(convert, refresh, true);
    };
    mepbm('143', '05', '000', '1');
})();