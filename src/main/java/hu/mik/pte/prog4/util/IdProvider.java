package hu.mik.pte.prog4.util;

import java.util.concurrent.atomic.AtomicLong;

@Deprecated
public class IdProvider {

    private static final IdProvider INSTANCE = new IdProvider();

    private AtomicLong id = new AtomicLong(1);

    private IdProvider() {

    }

    public static IdProvider getInstance() {
        return INSTANCE;
    }

    public long nextId() {
        return this.id.getAndIncrement();
    }
}
