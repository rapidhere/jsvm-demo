import * as SsSocket from 'ranttu.rapid.jsvmdemo.SimpleServerSocket';
import * as Calculator from  'ranttu.rapid.jsvmdemo.AsyncCalculator';
import * as Logger from 'ranttu.rapid.jsvmdemo.Logger';

var s = new SsSocket();
var calculator = new Calculator();
var logger = new Logger();

async function calc(a, b) {
    var unused;
    unused = logger.info3('get calc request: ', a, b);
    var ret = await calculator.calc(a, b);
    unused = logger.info6('calc result: ', a, '+', b, '=', ret);
    return 0;
}

s.listen(8080, calc);