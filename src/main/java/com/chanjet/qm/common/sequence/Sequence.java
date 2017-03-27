package com.chanjet.qm.common.sequence;

/**
 */
public class Sequence {
    private SequenceID iD = SequenceID.forValue(0);

    public final SequenceID getID() {
        return iD;
    }

    public final void setID(SequenceID value) {
        iD = value;
    }

    private int current;

    public final int getCurrent() {
        return current;
    }

    public final void setCurrent(int value) {
        current = value;
    }

    private int last;

    public final int getLast() {
        return last;
    }

    public final void setLast(int value) {
        last = value;
    }
}
