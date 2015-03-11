(function(require) {
    var debug = function(root) {
        console.groupCollapsed(root.n());
        console.group("n");
        console.table([root.square()]);
        console.groupEnd();
        console.group("1:2");
        console.table([root.gamma(), root.beta()]);
        console.groupEnd();
        console.group("abc:ABC");
        console.table([root.alpha(), root.delta()]);
        console.groupEnd();
        console.group("T1:T2:T3");
        var abc = root.alpha();
        var data = root.chaos(abc[0], abc[1], abc[2], abc[3], abc[4], abc[5]);
        console.table(data[0]);
        console.table(data[1]);
        console.table(data[2]);
        console.groupEnd();
        console.group("T1':T2':T3'");
        abc = root.delta();
        data = root.chaos(abc[0], abc[1], abc[2], abc[3], abc[4], abc[5]);
        console.table(data[0]);
        console.table(data[1]);
        console.table(data[2]);
        console.groupEnd();
        console.groupEnd();
        return root;
    };
    var limit = 30;
    while (limit--) {
        debug(require.space(limit));
    }
})(require);