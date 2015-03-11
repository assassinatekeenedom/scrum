(function() {
    var wrapper = document.createElement('div');
    var memory = function(relative) {
        wrapper.appendChild(relative);
    };
    var process = function(whole) {
        document.body.removeChild(wrapper);
        wrapper = document.createElement('div');
        quadratic.toggle(wrapper);
        var data = whole[0];
        memory(data.shift(), wrapper);
        memory(data.shift(), wrapper);
        memory(data.shift(), wrapper);
        memory(data.shift(), wrapper);
        memory(data.shift(), wrapper);

        wrapper.appendChild(prev);
        wrapper.appendChild(time);
        wrapper.appendChild(next);
        document.body.appendChild(wrapper);
    }, rules = function(style, x, y) {
        style('left', x + 'px');
        style('top', y + 'px');
        style.promote();
    }, stop = function() {
        prev.disabled = true, next.disabled = true, time.disabled = true, next.removeEventListener('mousedown', plus, true), prev.removeEventListener('mousedown', minus, true), time.removeEventListener('change', manual, true);
    }, start = function() {
        next.addEventListener('mousedown', plus, true), prev.addEventListener('mousedown', minus, true), time.addEventListener('change', manual, true), prev.disabled = false, next.disabled = false, time.disabled = false;
    }, reload = function(a) {
        time.value = script.server(a);
        window.setTimeout(start, 33);
    }, update = function(t) {
        stop();
        window.setTimeout(reload, 10, t);
    }, manual = function() {
        update(parseInt(time.value));
    }, plus = function() {
        update(parseInt(time.value) + 1);
    }, minus = function() {
        update(parseInt(time.value) - 1);
    }, load = function() {
        next.type = 'button';
        prev.type = 'button';
        next.value = ' >> ';
        prev.value = ' << ';
        time.maxWidth = 15;
        time.size = 17;
        time.value = -1;
        time.style.textAlign = 'center';
        var body = html.rule('body');
        body('position', 'static');
        body('top', 0);
        body('left', 0);
        body('overflow', 'hidden');
        body('width', window.innerWidth + 'px');
        body('height', window.innerHeight + 'px');
        window.addEventListener('resize', function() {
        }, true);
        body.as.i();
        body.promote();

        sMinusTwo('position', 'fixed');
        sMinusOne('position', 'fixed');
        sPlusMinus('position', 'fixed');
        sPlusOne('position', 'fixed');
        sPlusTwo('position', 'fixed');
        quadratic('position', 'fixed');

        rules(sMinusTwo, parseInt(window.innerWidth * .15), 75);
        rules(sMinusOne, parseInt(window.innerWidth * .30), 75);
        rules(sPlusMinus, parseInt(window.innerWidth * .45), 75);
        rules(sPlusOne, parseInt(window.innerWidth * .60), 75);
        rules(sPlusTwo, parseInt(window.innerWidth * .75), 75);

        window.addEventListener('resize', function() {
            rules(sMinusTwo, parseInt(window.innerWidth * .15), 75);
            rules(sMinusOne, parseInt(window.innerWidth * .30), 75);
            rules(sPlusMinus, parseInt(window.innerWidth * .45), 75);
            rules(sPlusOne, parseInt(window.innerWidth * .60), 75);
            rules(sPlusTwo, parseInt(window.innerWidth * .75), 75);
        }, true);
        var info = [html.size(prev), html.size(time), html.size(next)];
        var half = parseInt((info[0].width + info[1].width + info[2].width) / 2);
        wrapper.appendChild(prev);
        wrapper.appendChild(time);
        wrapper.appendChild(next);
        document.body.appendChild(wrapper);
        var refresh = function() {
            document.body.removeChild(wrapper);
            body('width', window.innerWidth + 'px');
            body('height', window.innerHeight + 'px');
            body.promote();
            quadratic.toggle(wrapper);
            rules(quadratic, parseInt(window.innerWidth / 2) - half, 25);
            document.body.appendChild(wrapper);
        };
        window.addEventListener('resize', refresh, true);
        document.body.appendChild(wrapper);
        refresh();
        start();
    }, quadratic = html.rule('nQuadratic'), sMinusTwo = html.rule('nMinusTwo'), sMinusOne = html.rule('nMinusOne'), sPlusMinus = html.rule('nPlusMinus'), sPlusOne = html.rule('nPlusOne'), sPlusTwo = html.rule('nPlusTwo'), time = document.createElement("input"), next = document.createElement("input"), prev = document.createElement("input");
    load();
    script.time = function(i) {
        update(i);
    };
    document.addEventListener('xyz-selects', function(event) {
        process(event.data);
    }, true);
})();