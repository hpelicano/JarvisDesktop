package com.fiserv.jarvis.libShellSSH;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelShell;
import com.jcraft.jsch.Session;

import java.io.*;
import java.util.function.Function;

/**
 * A class representing a shell session.
 * @author Displee
 */
public class ShellSession {

    /**
     * If this session is running.
     */
    private boolean running = true;

    private PipedOutputStream poutWrapper;

    private PipedInputStream pin = new PipedInputStream(4096);

    private PipedInputStream pinWrapper = new PipedInputStream(4096);

    private PipedOutputStream pout;

    private String lastCommand;

    /**
     * Constructs a new {@code ShellSession} {@code Object}.
     */
    public ShellSession() {
        try {
            pout = new PipedOutputStream(pinWrapper);
            poutWrapper = new PipedOutputStream(pin);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Start this shell session.
     * @param session The ssh session.
     */
    public void start(Session session, Function<String, Void> callback) {
        ChannelShell shellChannel = null;
        try {
            shellChannel = (ChannelShell) session.openChannel("shell");
            shellChannel.setInputStream(pin);
            shellChannel.setOutputStream(pout);
            shellChannel.connect();
        } catch(Exception e) {
            e.printStackTrace();
        }
        if (shellChannel == null) {
            return;
        }
        final Channel channel = shellChannel;
        Thread thread = new Thread(() -> {
            while (running) {
                try {
                    if (pinWrapper.available() != 0) {
                        String response = readResponse();
                        callback.apply(response);
                    }
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            channel.disconnect();
        });
        thread.setDaemon(true);
        thread.start();
    }

    /**
     * Stop this shell session.
     */
    public void stop() {
        running = false;
    }

    /**
     * Send a message to the shell.
     * @param message The message to send.
     */
    public void write(String message) {
        lastCommand = message;
        try {
            poutWrapper.write(message.getBytes());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read the response from {@code pinWrapper}.
     * @return The string.
     * @throws IOException If it could not read the piped stream.
     */
    private synchronized String readResponse() throws IOException {
        final StringBuilder s = new StringBuilder();
        while(pinWrapper.available() > 0) {
            s.append((char) pinWrapper.read());
        }
        return s.toString();
    }

}