/**
 *  Anonymous Function Wrapper
 */
(function() {
    var pdf = function(game, nation, turn, page) {
        return PNG_TO_BASE_64('http://localhost/mepbm/' + 'g' + game + 'n' + nation + 't' + turn + '-' + page + '.png');
    };
    console.log(pdf('143', '05', '000', '8'));
})();