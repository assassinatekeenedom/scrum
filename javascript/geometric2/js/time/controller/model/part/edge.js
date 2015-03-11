(function() {
    var x = [
        [2, 1, 1],
        [2, 2, 2],
        [2, 1, 3]
    ], y = [
        [1, 2, 2],
        [2, 1, 2],
        [2, 2, 3]
    ], z = function(dx, dy, dz) {
        return {
            x: {
                y: {
                    x: x[0][0] * dx + x[0][1] * dy + x[0][2] * -1 * dz,
                    y: x[1][0] * -1 * dx + x[1][1] * dy + x[1][2] * dz,
                    z: x[2][0] * -1 * dx + x[2][1] * dy + x[2][2] * dz
                },
                x: {
                    x: y[0][0] * -1 * dx + y[0][1] * dy + y[0][2] * dz,
                    y: y[1][0] * -1 * dx + y[1][1] * dy + y[1][2] * dz,
                    z: y[2][0] * -1 * dx + y[2][1] * dy + y[2][2] * dz
                }
            },
            y: {
                y: {
                    x: x[0][0] * dx + x[0][1] * dy + x[0][2] * dz,
                    y: x[1][0] * dx + x[1][1] * -1 * dy + x[1][2] * dz,
                    z: x[2][0] * dx + x[2][1] * -1 * dy + x[2][2] * dz
                },
                x: {
                    x: y[0][0] * dx + y[0][1] * dy + y[0][2] * dz,
                    y: y[1][0] * dx + y[1][1] * dy + y[1][2] * dz,
                    z: y[2][0] * dx + y[2][1] * dy + y[2][2] * dz
                }
            },
            z: {
                y: {
                    x: x[0][0] * dx + x[0][1] * -1 * dy + x[0][2] * dz,
                    y: x[1][0] * dx + x[1][1] * dy + x[1][2] * dz,
                    z: x[2][0] * dx + x[2][1] * dy + x[2][2] * dz
                },
                x: {
                    x: y[0][0] * dx + y[0][1] * -1 * dy + y[0][2] * dz,
                    y: y[1][0] * dx + y[1][1] * -1 * dy + y[1][2] * dz,
                    z: y[2][0] * dx + y[2][1] * -1 * dy + y[2][2] * dz
                }
            }
        };
    }, chaos = function(dx, dy, dz) {
        return {
            x: z(dx, dy, dz),
            y: z(dy, dx, dz)
        };
    }, rest = function(dx, dy, dz, a, b, record) {
        var data = chaos(dx, dy, dz), event = script.rest(a, b, record);
        return function(named) {
            event.initEvent(named, true, true);
            event.data.unshift(data);
            document.dispatchEvent(event);
            return event;
        };
    };
    script.edge = function(dx, dy, dz, na, nb, record) {
        return rest(dx, dy, dz, na, nb, record);
    };
})();