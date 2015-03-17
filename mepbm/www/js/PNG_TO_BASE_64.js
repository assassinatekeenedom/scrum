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
    };
    var img = document.createEvent("Event");
    img.initEvent("PNG_TO_BASE_64", true, true);
    convertImgToBase64URL('http://localhost/mepbm/g143n05t000-1.png', function(base64Img) {
        img.src = base64Img;
        document.dispatchEvent(img);
    });
})();