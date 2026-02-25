package exporters;

import dto.ExportRequest;
import dto.ExportResult;

public abstract class Exporter {
    public final ExportResult export(ExportRequest req) {
        ExportRequest request = process(req);
        return doExport(request);
    }

    protected abstract ExportResult doExport(ExportRequest req);

    private ExportRequest process(ExportRequest req) {
        if (req == null) {
            throw new IllegalArgumentException("Request must not be null");
        } else {
            if (req.title == null || req.body == null) {
                String title = req.title != null ? req.title : "";
                String body = req.body != null ? req.body : "";
                return new ExportRequest(title, body);
            }
        }
        return req;
    }
}