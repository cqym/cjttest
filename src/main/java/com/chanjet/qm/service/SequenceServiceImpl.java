package com.chanjet.qm.service;

import org.springframework.stereotype.Service;


/**
 */
@Service("sequenceService")
public class SequenceServiceImpl implements SequenceService {

//    @Resource
//    private SequenceMapper sequenceRepository;
//
//    private static Object _lockObj = new Object();
//    private static java.util.ArrayList<Sequence> cachedSequences = new java.util.ArrayList<Sequence>();
//    private static int STEP = 100;
//    private static int MAX_STEP = 1000;
//
//    public int next(SequenceID seq) {
//        return next(seq, STEP);
//    }
//
//    public int next(SequenceID seq, int step) {
//        if (step <= 0 || step > MAX_STEP) {
//            throw new RuntimeException("参数异常");
//        }
//        synchronized (_lockObj) {
//            Sequence found = null;
//            for (Sequence item : cachedSequences) {
//                if (item.getID() == seq) {
//                    found = item;
//                    break;
//                }
//            }
//            if (found == null) {
//                Sequence tempVar = new Sequence();
//                tempVar.setID(seq);
//                tempVar.setCurrent(0);
//                tempVar.setLast(0);
//                found = tempVar;
//                cachedSequences.add(found);
//            }
//            if (found.getCurrent() >= found.getLast()) {
//                found.setLast(sequenceRepository.SequenceNext(seq, step));
//                if (found.getLast() == -1) {
//                    found.setLast(step);
//                    sequenceRepository.AddSequence(seq, found.getLast());
//                }
//                found.setCurrent(found.getLast() - step);
//            }
//            found.setCurrent(found.getCurrent() + 1);
//            return found.getCurrent();
//        }
//    }
//
//    public int getSequenceValue(SequenceID seq) {
//
//        return sequenceRepository.GetSequenceValue(seq);
//    }

}
