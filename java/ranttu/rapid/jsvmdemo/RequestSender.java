package ranttu.rapid.jsvmdemo;

import ranttu.rapid.jsvm.runtime.async.FuturePromise;
import ranttu.rapid.jsvmnode.WorkingPool;

import java.io.IOException;
import java.net.Socket;

// send the request
public class RequestSender {
    public FuturePromise send(int a, int b) {
        return WorkingPool.submit(() -> {
            Logger logger = new Logger();
            try {
                Socket sock = new Socket("127.0.0.1", 8080);
                String s = "" + a + " + " + b + "\r\n";
                sock.getOutputStream().write(s.getBytes());
                sock.close();
            } catch (IOException e) {
                logger.err("connect failed: ", e);
            }

            // nothing to return
            return null;
        });
    }
}
