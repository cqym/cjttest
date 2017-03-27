package com.chanjet.qm.mapper;

import com.chanjet.qm.common.sequence.SequenceID;

public interface SequenceMapper {
    int SequenceNext(SequenceID seq, int step);

    void AddSequence(SequenceID seq, int initValue);

    int GetSequenceValue(final SequenceID seq);
}
