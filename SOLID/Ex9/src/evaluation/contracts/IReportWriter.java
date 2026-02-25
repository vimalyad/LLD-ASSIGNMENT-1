package evaluation.contracts;

import entities.Submission;

public interface IReportWriter {
    String write(Submission s, int plag, int code);
}
