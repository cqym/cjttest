package com.chanjet.qm.common.sequence;

public interface SequenceRepository {
    int SequenceNext(SequenceID seq, int step);

    void AddSequence(SequenceID seq, int initValue);

    int GetSequenceValue(final SequenceID seq);
}
