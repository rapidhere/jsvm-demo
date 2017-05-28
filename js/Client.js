import * as Sender from 'ranttu.rapid.jsvmdemo.RequestSender';

var sender = new Sender();
var unused;

async function send() {
    var i = 10;
    var unused;
    while(i) {
        unused = await sender.send(i, i - 1);
        i = i - 1;
    }
    return unused;
}

var i = 10;
while(i) {
    unused = send();
    i = i - 1;
}