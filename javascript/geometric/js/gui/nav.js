(function(require) {
    var write = function(total) {
        if (document.body.contains(both)) {
            document.body.removeChild(both);
            both = document.createElement("table"), parallel = document.createElement("tr"), left = document.createElement("td"), right = document.createElement("td");
        }
        var plus = require.html.table(left);
        plus(total[0][0][0], total[0][0][1], total[0][0][2], true);
        plus(total[1][0][0], total[1][0][1], total[1][0][2], true);
        plus(total[2][0][0], total[2][0][1], total[2][0][2], true);
        plus(total[3][0][0], total[3][0][1], total[3][0][2], true);
        plus(total[4][0][0], total[4][0][1], total[4][0][2], true)();
        var minus = require.html.table(right);
        minus(total[0][1][0], total[0][1][1], total[0][1][2], true);
        minus(total[1][1][0], total[1][1][1], total[1][1][2], true);
        minus(total[2][1][0], total[2][1][1], total[2][1][2], true);
        minus(total[3][1][0], total[3][1][1], total[3][1][2], true);
        minus(total[4][1][0], total[4][1][1], total[4][1][2], true)();
        parallel.appendChild(left);
        parallel.appendChild(right);
        both.appendChild(parallel);
        document.body.appendChild(both);
    }, rightUp = function(mx, my, of) {
        ctx.beginPath();
        ctx.moveTo(mx, my);
        ctx.lineTo(mx - of[0], my);
        ctx.lineTo(mx - of[0], my - of[1]);
        ctx.closePath();
        ctx.stroke();
    }, rightUpSmooth = function(mx, my, of) {
        ctx.beginPath();
        ctx.moveTo(mx, my);
        ctx.bezierCurveTo(mx - of[0], my, mx - of[0], my - of[1], mx, my);
        ctx.stroke(); 
   }, rightDown = function(mx, my, of) {
        ctx.beginPath();
        ctx.moveTo(mx, my);
        ctx.lineTo(mx + of[0], my);
        ctx.lineTo(mx + of[0], my + of[1]);
        ctx.closePath();
        ctx.stroke();
    }, rightDownSmooth = function(mx, my, of) {
        ctx.beginPath();
        ctx.moveTo(mx, my);
        ctx.bezierCurveTo(mx + of[0], my, mx + of[0], my + of[1], mx, my);
        ctx.stroke(); 
   }, square = function(event) {
        rightUp(event.clientX, event.clientY, space[1][0]);
        rightUp(event.clientX, event.clientY, space[2][0]);
        rightUp(event.clientX, event.clientY, space[3][0]);
        rightUp(event.clientX, event.clientY, space[4][0]);
        rightUp(event.clientX, event.clientY, space[1][1]);
        rightUp(event.clientX, event.clientY, space[2][1]);
        rightUp(event.clientX, event.clientY, space[3][1]);
        rightUp(event.clientX, event.clientY, space[4][1]);
    }, round = function(event) {
        rightUpSmooth(event.clientX, event.clientY, space[1][0]);
        rightUpSmooth(event.clientX, event.clientY, space[2][0]);
        rightUpSmooth(event.clientX, event.clientY, space[3][0]);
        rightUpSmooth(event.clientX, event.clientY, space[4][0]);
        rightUpSmooth(event.clientX, event.clientY, space[1][1]);
        rightUpSmooth(event.clientX, event.clientY, space[2][1]);
        rightUpSmooth(event.clientX, event.clientY, space[3][1]);
        rightUpSmooth(event.clientX, event.clientY, space[4][1]);
    }, msquare = function(event) {
        rightDown(event.clientX, event.clientY, space[1][0]);
        rightDown(event.clientX, event.clientY, space[2][0]);
        rightDown(event.clientX, event.clientY, space[3][0]);
        rightDown(event.clientX, event.clientY, space[4][0]);
        rightDown(event.clientX, event.clientY, space[1][1]);
        rightDown(event.clientX, event.clientY, space[2][1]);
        rightDown(event.clientX, event.clientY, space[3][1]);
        rightDown(event.clientX, event.clientY, space[4][1]);
    }, mround = function(event) {
        rightDownSmooth(event.clientX, event.clientY, space[1][0]);
        rightDownSmooth(event.clientX, event.clientY, space[2][0]);
        rightDownSmooth(event.clientX, event.clientY, space[3][0]);
        rightDownSmooth(event.clientX, event.clientY, space[4][0]);
        rightDownSmooth(event.clientX, event.clientY, space[1][1]);
        rightDownSmooth(event.clientX, event.clientY, space[2][1]);
        rightDownSmooth(event.clientX, event.clientY, space[3][1]);
        rightDownSmooth(event.clientX, event.clientY, space[4][1]);
    }, clear = function() {
        hide();
        canvas = document.createElement("canvas");
        canvas.style.position = 'absolute';
        canvas.style.top = '0px';
        canvas.style.left = '0px';
        canvas.style.zIndex = -1;
        canvas.width = maxX;
        canvas.height = maxY;
        ctx = canvas.getContext("2d");
        time.value = -1;
        baseOption.value = 10;
        write(acceptance);
        timeline = require.space(time.value);
        space = [timeline.square(), timeline.alpha(), timeline.gamma(), timeline.delta(), timeline.beta()];
        show();
        root.checked = true;
    }, hide = function() {
        document.body.removeChild(canvas);
        document.body.removeChild(nEquals);
        document.body.removeChild(time);
        document.body.removeChild(reset);
        document.body.removeChild(br);
        document.body.removeChild(root);
        document.body.removeChild(rootLabel);
        document.body.removeChild(base10);
        document.body.removeChild(base10Label);
        document.body.removeChild(baseOption);
        document.body.removeChild(baseOptionLabel);
        document.body.removeChild(br2);
        document.body.removeChild(turn1);
        document.body.removeChild(turn1Label);
        document.body.removeChild(turn2);
        document.body.removeChild(turn2Label);
        document.body.removeChild(turn3);
        document.body.removeChild(turn3Label);
        document.body.removeChild(turn4);
        document.body.removeChild(turn4Label);
        document.body.removeChild(br3);
        document.body.removeChild(checkRound);
        document.body.removeChild(roundLabel);
        document.body.removeChild(checkSquare);
        document.body.removeChild(squareLabel);
    }, show = function() {
        document.body.appendChild(canvas);
        document.body.appendChild(nEquals);
        document.body.appendChild(time);
        document.body.appendChild(reset);
        document.body.appendChild(br);
        document.body.appendChild(root);
        document.body.appendChild(rootLabel);
        document.body.appendChild(baseOptionLabel);
        document.body.appendChild(baseOption);
        document.body.appendChild(base10);
        document.body.appendChild(base10Label);
        document.body.appendChild(br2);
        document.body.appendChild(turn1);
        document.body.appendChild(turn1Label);
        document.body.appendChild(turn2);
        document.body.appendChild(turn2Label);
        document.body.appendChild(turn3);
        document.body.appendChild(turn3Label);
        document.body.appendChild(turn4);
        document.body.appendChild(turn4Label);
        document.body.appendChild(br3);
        document.body.appendChild(checkRound);
        document.body.appendChild(checkRound);
        document.body.appendChild(roundLabel);
        document.body.appendChild(checkSquare);
        document.body.appendChild(squareLabel);
    }, rootCheck = function() {
        hide();
        write(acceptance);
        show();
    }, baseCheck = function(origin) {
        if (origin > 1 && origin < 37) {
            hide();
            var bsp = [], wall = [].concat(space), sub, info, local, subinfo;
            while (wall.length) {
                sub = [].concat(wall.shift()), info = [];
                while (sub.length) {
                    local = [].concat(sub.shift());
                    subinfo = [];
                    while (local.length) {
                        subinfo.push(local.shift().toString(origin + ''));
                    }
                    info.push(subinfo);
                }
                bsp.push(info);
            }
            write(bsp);
            show();
        }
    }, base10Check = function() {
        hide();
        baseOption.value = 10;
        write(space);
        show();
    }, face1Check = function() {
        hide();
        write(require.chaos(space[1][0][0], space[1][0][1], space[1][0][2]));
        show();
    }, face2Check = function() {
        hide();
        write(require.chaos(space[1][1][0], space[1][1][1], space[1][1][2]));
        show();
    }, face3Check = function() {
        hide();
        write(require.chaos(space[3][0][0], space[3][0][1], space[3][0][2]));
        show();
    }, face4Check = function() {
        hide();
        write(require.chaos(space[3][1][0], space[3][1][1], space[3][1][2]));
        show();
    }, init = function() {
        window.addEventListener('resize', resize, true);
//        document.body.style.position = 'static';
//        document.body.style.overflow = 'hidden';
        document.body.width = maxX, document.body.height = maxY;
        time.type = 'text';
        baseOption.type = "text";
        time.size = 15;
        baseOption.size = 3;
        time.value = -1;
        baseOption.value = 10;
        reset.type = 'button';
        reset.value = 'Reset';
        timeline = require.space(time.value);
        space = [timeline.square(), timeline.gamma(), timeline.alpha(), timeline.beta(), timeline.delta()];
        write(acceptance);
        time.addEventListener("mouseover", off, true);
        time.addEventListener("change", apply, true);
        reset.addEventListener('mouseup', clear, true);
        reset.addEventListener("mouseover", off, true);
        reset.addEventListener("mouseout", on, true);
        canvas.width = maxX;
        canvas.height = maxY;
        canvas.style.position = 'absolute';
        canvas.style.top = '0px';
        canvas.style.left = '0px';
        canvas.style.zIndex = -1;
        ctx = canvas.getContext("2d");
        ctx.lineWidth = .25;
        checkRound.type = "checkbox";
        checkSquare.type = "checkbox";
        root.type = "radio";
        root.checked = true;
        base10.type = "radio";
        turn1.type = "radio";
        turn2.type = "radio";
        turn3.type = "radio";
        turn4.type = "radio";
        root.name = "turn";
        base10.name = "turn";
        turn1.name = "turn";
        turn2.name = "turn";
        turn3.name = "turn";
        turn4.name = "turn";
        baseOption.addEventListener("change", function() {
            baseCheck(baseOption.value);
        }, true);
        base10.addEventListener("change", base10Check, true);
        root.addEventListener("change", rootCheck, true);
        turn1.addEventListener("change", face1Check, true);
        turn1.addEventListener("mouseover", off, true);
        turn1.addEventListener("mouseout", on, true);
        turn2.addEventListener("change", face2Check, true);
        turn2.addEventListener("mouseover", off, true);
        turn2.addEventListener("mouseout", on, true);
        turn3.addEventListener("change", face3Check, true);
        turn3.addEventListener("mouseover", off, true);
        turn3.addEventListener("mouseout", on, true);
        turn4.addEventListener("change", face4Check, true);
        turn4.addEventListener("mouseover", off, true);
        turn4.addEventListener("mouseout", on, true);
        baseOption.addEventListener("mouseover", off, true);
        baseOption.addEventListener("mouseout", on, true);
        base10.addEventListener("mouseover", off, true);
        base10.addEventListener("mouseout", on, true);
        root.addEventListener("mouseover", off, true);
        root.addEventListener("mouseout", on, true);
        checkRound.addEventListener("mouseover", off, true);
        checkRound.addEventListener("mouseout", on, true);
        checkSquare.addEventListener("mouseover", off, true);
        checkSquare.addEventListener("mouseout", on, true);
        window.addEventListener("mousedown", draw, true);
        show();
    }, apply = function() {
        saved = time.value;
        timeline = require.space(time.value);
        space = [timeline.square(), timeline.alpha(), timeline.gamma(), timeline.delta(), timeline.beta()];
        base10Check();
        on();
        base10.checked = true;
    }, draw = function(event) {
        if (checkSquare.checked) {
            square(event);
            msquare(event);
        }
        if (checkRound.checked) {
            round(event);
            mround(event);
        }
    }, on = function() {
        window.addEventListener("mousedown", draw, true);
    }, off = function() {
        window.removeEventListener("mousedown", draw, true);
    }, resize = function() {
        window.removeEventListener('resize', resize, true);
        maxX = window.innerWidth, maxY = window.innerHeight;
        document.body.width = maxX, document.body.height = maxY;
        canvas.width = maxX, canvas.height = maxY;
        clear();
        window.addEventListener('resize', resize, true);
    }, acceptance = [
        [["-n&sup2;", "-n&sup2;+1", "(n-1)&sup2;"], ["n&sup2;", "n&sup2;+1", "(n+1)&sup2;"]],
        [["-2n+1", "-2n&sup2;+2n", "-2n&sup2;+2n+1"], ["2n+1", "2n&sup2;+2n", "2n&sup2;+2n+1"]],
        [["-2n+3", "-2n&sup2;+6n+3", "-2n&sup2;+6n+5"], ["2n+3", "2n&sup2;+6n+3", "2n&sup2;+6n+5"]],
        [["-4n+4", "-4n&sup2;+8n+3", "-4n&sup2;+8n+5"], ["4n+4", "4n&sup2;+8n+3", "4n&sup2;+8n+5"]],
        [["-4n+6", "-4n&sup2;+12n+3", "-4n&sup2;+12n+5"], ["4n+6", "4n&sup2;+12n+3", "4n&sup2;+12n+5"]]
    ],
            both = document.createElement("table"),
            parallel = document.createElement("tr"),
            left = document.createElement("td"),
            right = document.createElement("td"),
            br = document.createElement("br"),
            br2 = document.createElement("br"),
            br3 = document.createElement("br"),
            roundLabel = document.createTextNode("Round"),
            squareLabel = document.createTextNode("Square"),
            rootLabel = document.createTextNode("Root"),
            baseOptionLabel = document.createTextNode(" @Base:"),
            nEquals = document.createTextNode("n==="),
            base10Label = document.createTextNode("Base 10"),
            turn1Label = document.createTextNode("Fractal #1"),
            turn2Label = document.createTextNode("Fractal #2"),
            turn3Label = document.createTextNode("Fractal #3"),
            turn4Label = document.createTextNode("Fractal #4"),
            time = document.createElement("input"),
            reset = document.createElement("input"),
            checkSquare = document.createElement("input"),
            checkRound = document.createElement("input"),
            root = document.createElement("input"),
            base10 = document.createElement("input"),
            baseOption = document.createElement("input"),
            turn1 = document.createElement("input"),
            turn2 = document.createElement("input"),
            turn3 = document.createElement("input"),
            turn4 = document.createElement("input"),
            canvas = document.createElement("canvas"),
            maxX = window.innerWidth,
            maxY = window.innerHeight,
            ctx = null, timeline = null, space = [], saved = null;
    init();
})(require);