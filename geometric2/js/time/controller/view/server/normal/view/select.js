(function() {
    var timeline = function(data, a, b, c) {
        var track = [], nodes = [].concat(data), when, node, select;
        while (nodes.length) {
            when = nodes.length;
            node = nodes.shift();
            select = html.select([a, b, c]);
            select(node.a);
            select(node.b);
            select(node.c);
            select(node.d);
            track.unshift(select(node.e));
        }
        return track;
    }, alias = function(nodes) {
        all = [].concat(nodes);
    }, prepare = function(event, a, b, c) {
        return [].concat(timeline(event.data, a, b, c));
    }, address = function(value, parallel, when, key) {
        var wall = [].concat(parallel[0]), as = [], bs = [], cs = [];
        while (wall.length) {
            wall.shift().value = value;
            as.unshift(parseInt(parallel[0][key].options[wall.length + 1].innerHTML));
        }
        wall = [].concat(parallel[1]);
        while (wall.length) {
            wall.shift().value = value;
            bs.unshift(parseInt(parallel[1][key].options[wall.length + 1].innerHTML));
        }
        wall = [].concat(parallel[2]);
        while (wall.length) {
            wall.shift().value = value;
            cs.unshift(parseInt(parallel[2][key].options[wall.length + 1].innerHTML));
        }
        switch (value) {
            case "a":
                value = -2;
                break;
            case "b":
                value = -1;
                break;
            case "c":
                value = 0;
                break;
            case "d":
                value = 1;
                break;
            case "e":
                value = 2;
                break;
        }
        switch (key + 1) {
            case 1:
                key = -2;
                break;
            case 2:
                key = -1;
                break;
            case 3:
                key = 0;
                break;
            case 4:
                key = 1;
                break;
            case 5:
                key = 2;
                break;
        }
        return {
            a: as,
            b: bs,
            c: cs,
            x: key,
            y: value,
            z: parallel.indexOf(when) - 1
        };
    }, resolve = function(event, a, b, c) {
        var data = prepare(event, a, b, c), div, wall, divs = [], parallel = [[], [], [], []];
        while (data.length) {
            div = document.createElement('div');
            switch (data.length) {
                case 1:
                    nMinusTwo.toggle(div);
                    break;
                case 2:
                    nMinusOne.toggle(div);
                    break;
                case 3:
                    nPlusMinus.toggle(div);
                    break;
                case 4:
                    nPlusOne.toggle(div);
                    break;
                case 5:
                    nPlusTwo.toggle(div);
                    break;
            }
            wall = data.pop();
            var as = wall.shift();
            var bs = wall.shift();
            var cs = wall.shift();
            parallel[0].unshift(as), parallel[1].unshift(bs), parallel[2].unshift(cs);
            var done = false;
            var go = function(event, n) {
                if (!done) {
                    abcevent.root = [].concat(last);
                    done = true;
                }
                abcevent.data = address(event.target.value, parallel, parallel[n], parallel[n].indexOf(event.target));
                document.dispatchEvent(abcevent);
            };
            as.addEventListener('change', function(event) {
                go(event, 0);
            }, true);
            bs.addEventListener('change', function(event) {
                go(event, 1);
            }, true);
            cs.addEventListener('change', function(event) {
                go(event, 2);
            }, true);
            div.appendChild(as);
            div.appendChild(document.createTextNode(' - '));
            div.appendChild(cs);
            div.appendChild(document.createTextNode(' = '));
            div.appendChild(bs);
            divs.push(div);
        }
        return divs;
    }, history = [], counter = 4, nMinusTwo = html.rule('nMinusTwo'), nMinusOne = html.rule('nMinusOne'), nPlusMinus = html.rule('nPlusMinus'), nPlusOne = html.rule('nPlusOne'), nPlusTwo = html.rule('nPlusTwo'), all = [], any = [], last = [];
    var xyzevent = document.createEvent("Event"), abcevent = document.createEvent("Event"), sxevent = document.createEvent("Event"), syevent = document.createEvent("Event"), szevent = document.createEvent("Event");
    xyzevent.initEvent('xyz-selects', true, true), abcevent.initEvent('abc-event', true, true);
    sxevent.initEvent('x-select', true, true), syevent.initEvent('y-select', true, true), szevent.initEvent('z-select', true, true);
    document.addEventListener('x-options', function(event) {
        any.push(resolve(event, 'i', 'i', 'i'));
    }, true);
    document.addEventListener('xy-options', function(event) {
        alias([].concat(event.data));
        switch (counter--) {
            case 3:
                last = [];
                break;
            case 0:
                xyzevent.data = [].concat(any);
                last = [].concat(all);
                document.dispatchEvent(xyzevent);
                counter = 4, any = [];
                break;
        }
    }, true);

    var toggle = function(at) {
        switch (at) {
            case 'x':
                document.dispatchEvent(sxevent);
                break;
            case 'y':
                document.dispatchEvent(syevent);
                break;
            case 'z':
                document.dispatchEvent(szevent);
                break;
        }
    };
    var listen = function(event) {
        toggle(event.target.value);
    };
    var decorate = function(turn, left, top) {
        turn.style.position = 'absolute';
        turn.style.top = top + 'px';
        turn.style.left = left + 'px';
        turn.style.width = 215 + 'px';
        turn.style.height = 200 + 'px';
        turn.style.overflow = 'auto';
    }, first = function(details) {
        var data, data, left, right, abc, xyz, wrapper, at;
        while (details.length) {
            at = details.length % 5;
            data = details.shift();
            left = html.select(['a', 'b', 'c']), right = html.select(['a', 'b', 'c']), abc, xyz;
            left(data.a.a);
            left(data.a.b);
            abc = left(data.a.c);
            right(data.b.a);
            right(data.b.b);
            xyz = right(data.b.c);
            abc[0].addEventListener('change', listen, true);
            abc[1].addEventListener('change', listen, true);
            abc[2].addEventListener('change', listen, true);
            xyz[0].addEventListener('change', listen, true);
            xyz[1].addEventListener('change', listen, true);
            xyz[2].addEventListener('change', listen, true);
            history.unshift(abc[0]);
            history.unshift(abc[1]);
            history.unshift(abc[2]);
            history.unshift(xyz[0]);
            history.unshift(xyz[1]);
            history.unshift(xyz[2]);
            wrapper = document.createElement('div');
            wrapper.appendChild(abc[0]);
            wrapper.appendChild(abc[1]);
            wrapper.appendChild(abc[2]);
            turns[0][at].appendChild(wrapper);
            wrapper = document.createElement('div');
            wrapper.appendChild(xyz[0]);
            wrapper.appendChild(xyz[1]);
            wrapper.appendChild(xyz[2]);
            turns[1][at].appendChild(wrapper);
        }

    }, second = function(details) {
        var data, data, left, right, abc, xyz, wrapper, at;
        while (details.length) {
            at = details.length % 5;
            data = details.shift();
            left = html.select(['a', 'b', 'c']), right = html.select(['a', 'b', 'c']), abc, xyz;
            left(data.a.a);
            left(data.a.b);
            abc = left(data.a.c);
            right(data.b.a);
            right(data.b.b);
            xyz = right(data.b.c);
            abc[0].addEventListener('change', listen, true);
            abc[1].addEventListener('change', listen, true);
            abc[2].addEventListener('change', listen, true);
            xyz[0].addEventListener('change', listen, true);
            xyz[1].addEventListener('change', listen, true);
            xyz[2].addEventListener('change', listen, true);
            history.unshift(abc[0]);
            history.unshift(abc[1]);
            history.unshift(abc[2]);
            history.unshift(xyz[0]);
            history.unshift(xyz[1]);
            history.unshift(xyz[2]);
            wrapper = document.createElement('div');
            wrapper.appendChild(abc[0]);
            wrapper.appendChild(abc[1]);
            wrapper.appendChild(abc[2]);
            turns[0][at].appendChild(wrapper);
            wrapper = document.createElement('div');
            wrapper.appendChild(xyz[0]);
            wrapper.appendChild(xyz[1]);
            wrapper.appendChild(xyz[2]);
            turns[1][at].appendChild(wrapper);
        }
    }, derive = function(root) {
        turns[0][0] = document.createElement('div');
        turns[0][1] = document.createElement('div');
        turns[0][2] = document.createElement('div');
        turns[0][3] = document.createElement('div');
        turns[0][4] = document.createElement('div');
        turns[1][0] = document.createElement('div');
        turns[1][1] = document.createElement('div');
        turns[1][2] = document.createElement('div');
        turns[1][3] = document.createElement('div');
        turns[1][4] = document.createElement('div');
        decorate(turns[0][0], parseInt(window.innerWidth * .15), 110);
        decorate(turns[0][1], parseInt(window.innerWidth * .3), 110);
        decorate(turns[0][2], parseInt(window.innerWidth * .45), 110);
        decorate(turns[0][3], parseInt(window.innerWidth * .6), 110);
        decorate(turns[0][4], parseInt(window.innerWidth * .75), 110);
        decorate(turns[1][0], parseInt(window.innerWidth * .15), 375);
        decorate(turns[1][1], parseInt(window.innerWidth * .3), 375);
        decorate(turns[1][2], parseInt(window.innerWidth * .45), 375);
        decorate(turns[1][3], parseInt(window.innerWidth * .6), 375);
        decorate(turns[1][4], parseInt(window.innerWidth * .75), 375);
        var wall = [].concat(root[0]), details;
        while (wall.length) {
            details = wall.shift();
            first(details);
            second(details);
        }
        document.addEventListener(sxevent.type, function() {
            var wall = [].concat(history);
            while (wall.length) {
                wall.shift().value = 'x';
            }
        }, true);
        document.addEventListener(syevent.type, function() {
            var wall = [].concat(history);
            while (wall.length) {
                wall.shift().value = 'y';
            }
        }, true);
        document.addEventListener(szevent.type, function() {
            var wall = [].concat(history);
            while (wall.length) {
                wall.shift().value = 'z';
            }
        }, true);
        return [].concat(root);
    }, update = function() {
        var wall = [].concat(turns[0]), turn;
        while (wall.length) {
            turn = wall.shift();
            turn.parentNode !== null ? document.body.removeChild(turn) : null;
        }
        wall = [].concat(turns[1]);
        while (wall.length) {
            turn = wall.shift();
            turn.parentNode !== null ? document.body.removeChild(turn) : null;
        }
    }, gui = function(root) {
        update();
        saved = saved.length === 0 ? derive(root) : saved;
        document.body.appendChild(turns[0][0]);
        document.body.appendChild(turns[0][1]);
        document.body.appendChild(turns[0][2]);
        document.body.appendChild(turns[0][3]);
        document.body.appendChild(turns[0][4]);
        document.body.appendChild(turns[1][0]);
        document.body.appendChild(turns[1][1]);
        document.body.appendChild(turns[1][2]);
        document.body.appendChild(turns[1][3]);
        document.body.appendChild(turns[1][4]);
    }, saved = [], turns = [[document.createElement('div'), document.createElement('div'), document.createElement('div'), document.createElement('div'), document.createElement('div')], [document.createElement('div'), document.createElement('div'), document.createElement('div'), document.createElement('div'), document.createElement('div')]];
    decorate(turns[0][0], parseInt(window.innerWidth * .15), 110);
    decorate(turns[0][1], parseInt(window.innerWidth * .3), 110);
    decorate(turns[0][2], parseInt(window.innerWidth * .45), 110);
    decorate(turns[0][3], parseInt(window.innerWidth * .6), 110);
    decorate(turns[0][4], parseInt(window.innerWidth * .75), 110);
    decorate(turns[1][0], parseInt(window.innerWidth * .15), 375);
    decorate(turns[1][1], parseInt(window.innerWidth * .3), 375);
    decorate(turns[1][2], parseInt(window.innerWidth * .45), 375);
    decorate(turns[1][3], parseInt(window.innerWidth * .6), 375);
    decorate(turns[1][4], parseInt(window.innerWidth * .75), 375);
    window.addEventListener('resize', function() {
        decorate(turns[0][0], parseInt(window.innerWidth * .15), 110);
        decorate(turns[0][1], parseInt(window.innerWidth * .3), 110);
        decorate(turns[0][2], parseInt(window.innerWidth * .45), 110);
        decorate(turns[0][3], parseInt(window.innerWidth * .6), 110);
        decorate(turns[0][4], parseInt(window.innerWidth * .75), 110);
        decorate(turns[1][0], parseInt(window.innerWidth * .15), 375);
        decorate(turns[1][1], parseInt(window.innerWidth * .3), 375);
        decorate(turns[1][2], parseInt(window.innerWidth * .45), 375);
        decorate(turns[1][3], parseInt(window.innerWidth * .6), 375);
        decorate(turns[1][4], parseInt(window.innerWidth * .75), 375);
    }, true);
    document.addEventListener("(n)", function() {
        update(), history = [], saved = [];
    }, true);
    document.addEventListener("abc-event", function(event) {
        gui(event.root);
    }, true);
})();