package com.fiserv.jarvis.libShellSSH;

import com.jcraft.jsch.*;

import java.util.function.Function;

public class SSHConnection {

    private static final JSch JSCH_INSTANCE = new JSch();

    private Session session;

    private ShellSession shellSession;

    public SSHConnection(String ip, String username, String password) {
        try {
            this.session = JSCH_INSTANCE.getSession(username, ip);
            this.session.setPassword(password);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            this.session.setConfig(config);
            
        } catch(Exception e) {
            e.printStackTrace();
            this.session = null;
        }
    }

    public boolean connect() {
        try {
            session.connect();
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            session.disconnect();
            return false;
        }
    }

    public boolean isConnected() {
        return session.isConnected();
    }

    public void disconnect() {
        session.disconnect();
    }

    public boolean startShellSession(Function<String, Void> callback) {
        try {
            shellSession = new ShellSession();
            shellSession.start(session, callback);
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void writeShellMessage(String message) {
        shellSession.write(message + "\n");
    }

}