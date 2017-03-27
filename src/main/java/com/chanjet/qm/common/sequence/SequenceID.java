package com.chanjet.qm.common.sequence;

/**
 */
public enum SequenceID {

    Noah_Foundation_Tree(103);


    private int intValue;
    private static java.util.HashMap<Integer, SequenceID> mappings;

    private synchronized static java.util.HashMap<Integer, SequenceID> getMappings() {
        if (mappings == null) {
            mappings = new java.util.HashMap<Integer, SequenceID>();
        }
        return mappings;
    }

    private SequenceID(int value) {
        intValue = value;
        SequenceID.getMappings().put(value, this);
    }

    public int getValue() {
        return intValue;
    }

    public static SequenceID forValue(int value) {
        return getMappings().get(value);
    }
}
