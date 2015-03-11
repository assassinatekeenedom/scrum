(function(require) {
    var square = function(x) {
        var n = x;
        return {
            a: function() {
                return n * n;
            }, b: function() {
                return n * n + 1;
            }, c: function() {
                return n * n + 2 * n + 1;
            }
        };
    }, alpha = function(x) {
        var n = x;
        return {
            a: function() {
                return 2 * n + 1;
            },
            b: function() {
                return (2 * n * n) + (2 * n);
            },
            c: function() {
                return (2 * n * n) + (2 * n) + 1;
            }
        };
    }, gamma = function(x) {
        var n = x;
        return {
            a: function() {
                return 2 * n + 3;
            },
            b: function() {
                return 2 * n * n + 6 * n + 3;
            },
            c: function() {
                return 2 * n * n + 6 * n + 5;
            }
        };
    }, delta = function(x) {
        var n = x;
        return {
            a: function() {
                return 4 * n + 4;
            },
            b: function() {
                return 4 * n * n + 8 * n + 3;
            },
            c: function() {
                return 4 * n * n + 8 * n + 5;
            }
        };
    }, beta = function(x) {
        var n = x;
        return {
            a: function() {
                return 4 * n + 6;
            },
            b: function() {
                return 4 * n * n + 12 * n + 3;
            },
            c: function() {
                return 4 * n * n + 12 * n + 5;
            }
        };
    }, align = function(n, fn) {
        var plus = fn(n), minus = fn(-n);
        return [[minus.a(), minus.b(), minus.c()], [plus.a(), plus.b(), plus.c()]];
    }, space = function(x) {
        var key = cache[0].indexOf(x);
        if (key < 0) {
            var i = align(x, square), a = align(x, alpha), b = align(x, beta), d = align(x, delta), g = align(x, gamma), n = x;
            var root = {
                get: function(time) {
                    if (time !== null && time !== undefined && time !== n) {
                        return space(time);
                    }
                    return root;
                },
                square: function() {
                    return i;
                },
                alpha: function() {
                    return a;
                },
                beta: function() {
                    return b;
                },
                delta: function() {
                    return d;
                },
                gamma: function() {
                    return g;
                }
            };
            cache[0].unshift(x), cache[1].unshift(root), key = 0;
        }
        return cache[1][key];
    }, chaos = function(x, y, z) {
        var a = x, b = y, c = z;
        return [
            [[2, 1, 2], [2, 2, 3]],
            [[2, 2, 2], [2, 1, 3]],
            [[prime[0][0] * a + prime[0][1] * b + prime[0][2] * -1 * c, prime[1][0] * -1 * a + prime[1][1] * b + prime[1][2] * c, prime[2][0] * -1 * a + prime[2][1] * b + prime[2][2] * c], [time[0][0] * -1 * a + time[0][1] * b + time[0][2] * c, time[1][0] * -1 * a + time[1][1] * b + time[1][2] * c, time[2][0] * -1 * a + time[2][1] * b + time[2][2] * c]],
            [[prime[0][0] * a + prime[0][1] * b + prime[0][2] * c, prime[1][0] * a + prime[1][1] * -1 * b + prime[1][2] * c, prime[2][0] * a + prime[2][1] * -1 * b + prime[2][2] * c], [time[0][0] * a + time[0][1] * b + time[0][2] * c, time[1][0] * a + time[1][1] * b + time[1][2] * c, time[2][0] * a + time[2][1] * b + time[2][2] * c]],
            [[prime[0][0] * a + prime[0][1] * -1 * b + prime[0][2] * c, prime[1][0] * a + prime[1][1] * b + prime[1][2] * c, prime[2][0] * a + prime[2][1] * b + prime[2][2] * c], [time[0][0] * a + time[0][1] * -1 * b + time[0][2] * c, time[1][0] * a + time[1][1] * -1 * b + time[1][2] * c, time[2][0] * a + time[2][1] * -1 * b + time[2][2] * c]]
        ];
    },
            cache = [[], []],
            time = [[1, 2, 2], [2, 1, 2], [2, 2, 3]],
            prime = [[2, 1, 1], [2, 2, 2], [2, 1, 3]];

    require.space = function(x) {
        return space(x);
    };
    require.chaos = function(a, b, c) {
        return chaos(a, b, c);
    };
})(require);