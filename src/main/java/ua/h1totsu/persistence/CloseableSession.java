package ua.h1totsu.persistence;

import org.hibernate.Session;

public class CloseableSession implements AutoCloseable {
    private final Session session;

    public CloseableSession(Session session) {
        this.session = session;
    }

    public Session getSession() {
        return session;
    }

    public void close() throws Exception {
        session.close();
    }
}
