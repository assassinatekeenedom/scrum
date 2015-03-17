/**
 *  Anonymous Function Wrapper
 */
(function() {
    var type = "PNG_TO_BASE_64";
    var images = [];
    document.addEventListener(type, function(img) {
        var html = document.createElement("img");
        html.src = img.src;
        images.unshift(html);
        document.body.appendChild(html);
        img.imgages = images;
        console.log(img);
    }, true);

    PNG_TO_BASE_64('143', '05', '000', '1');
    PNG_TO_BASE_64('143', '05', '000', '2');
    PNG_TO_BASE_64('143', '05', '000', '3');
    PNG_TO_BASE_64('143', '05', '000', '4');
    PNG_TO_BASE_64('143', '05', '000', '5');
    PNG_TO_BASE_64('143', '05', '000', '6');
})();