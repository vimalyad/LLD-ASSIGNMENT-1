package evaluation.contracts;

import entities.Submission;

public interface IPlagiarismChecker {
    int check(Submission submission);
}
