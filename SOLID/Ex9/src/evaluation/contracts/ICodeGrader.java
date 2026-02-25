package evaluation.contracts;

import config.Rubric;
import entities.Submission;

public interface ICodeGrader {
    int grade(Submission submission, Rubric rubric);
}
