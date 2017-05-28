package ranttu.rapid.jsvmdemo;

import ranttu.rapid.jsvm.runtime.JsFunctionObject;
import ranttu.rapid.jsvmnode.MainLoop;
import ranttu.rapid.jsvmnode.WorkingPool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

// the server serverSocket
public class SimpleServerSocket implements Runnable {
    private ServerSocket serverSocket = null;
    private Logger logger = new Logger();
    private JsFunctionObject callback;

    public void listen(int port, JsFunctionObject callback) {
        this.callback = callback;

        try {
            serverSocket = new java.net.ServerSocket(port);
        } catch (IOException e) {
            logger.err("server start failed: ", e);
            return ;
        }
        logger.info("server started on port: ", port);

        WorkingPool.submitWithoutReturn(this);
    }

    @Override
    public void run() {
        while (true) {
            Socket socket;
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                logger.err("accept faield: ", e);
                return ;
            }
            logger.info("get new request");

            String r;
            try {
                InputStream s = socket.getInputStream();
                BufferedReader in =new BufferedReader(
                    new InputStreamReader(s));
                r = in.readLine();
                in.close();
            } catch (IOException e) {
                logger.err("read from socket failed: ", e);
                return ;
            }
            logger.info("request content: ", r);

            try {
                socket.close();
            } catch (IOException e) {
                logger.err("close socket failed: ", e);
                return ;
            }


            String[] tmp = r.split("\\+");
            String a = tmp[0].trim();
            String b = tmp[1].trim();
            MainLoop.get().submitEvent(callback, null, a, b);
        }
    }
}
