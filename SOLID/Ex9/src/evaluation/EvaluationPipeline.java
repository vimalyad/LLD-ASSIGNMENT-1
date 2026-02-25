package evaluation;

import config.Rubric;
import entities.Submission;
import evaluation.contracts.ICodeGrader;
import evaluation.contracts.IPlagiarismChecker;
import evaluation.contracts.IReportWriter;
import printer.SimpleConsole;

public class EvaluationPipeline {
    private final ICodeGrader codeGrader;
    private final IPlagiarismChecker plagiarismChecker;
    private final IReportWriter reportWriter;
    private final Rubric rubric;
    private final SimpleConsole console;

    public EvaluationPipeline(ICodeGrader codeGrader,
                              IPlagiarismChecker plagiarismChecker,
                              IReportWriter reportWriter,
                              Rubric rubric,
                              SimpleConsole console) {
        this.codeGrader = codeGrader;
        this.plagiarismChecker = plagiarismChecker;
        this.reportWriter = reportWriter;
        this.rubric = rubric;
        this.console = console;
    }

    public void evaluate(Submission sub) {
        int plag = plagiarismChecker.check(sub);
        console.log("PlagiarismScore=" + plag);

        int code = codeGrader.grade(sub, rubric);
        console.log("CodeScore=" + code);

        String reportName = reportWriter.write(sub, plag, code);
        console.log("Report written: " + reportName);

        int total = plag + code;
        String result = (total >= 90) ? "PASS" : "FAIL";
        console.log("FINAL: " + result + " (total=" + total + ")");
    }
}