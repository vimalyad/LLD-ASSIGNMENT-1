package evaluation.impl;

import entities.Submission;
import evaluation.contracts.IPlagiarismChecker;

public class PlagiarismChecker implements IPlagiarismChecker {
    public int check(Submission s) {
        // fake score: lower is "better", but pipeline adds it anyway (smell)
        return (s.code.contains("class") ? 12 : 40);
    }
}
