/**
 *  Anonymous Function Wrapper
 */
(function() {
    var type = "PNG_TO_BASE_64";
    document.addEventListener(type, function(img) {
        console.log(img);
        document.body.appendChild(img.images[0]);
    }, true);
    PNG_TO_BASE_64('143', '05', '000', '1');
    PNG_TO_BASE_64('143', '05', '000', '2');
    PNG_TO_BASE_64('143', '05', '000', '3');
    PNG_TO_BASE_64('143', '05', '000', '4');
    PNG_TO_BASE_64('143', '05', '000', '5');
    PNG_TO_BASE_64('143', '05', '000', '6');
})();