package com.hau.huylong.graduation_proejct.common.constant;

import java.util.ArrayList;
import java.util.List;

public class Constants {
    public static final String ANONYMOUS = "Anonymous";
    public static final String ADMIN = "ADMIN";

    public static final String AES_SECRET = "MTIzcnVnaHRhbmtobW91dA==";

    public static class StatusCode {
        public static final String SUCCESS = "SUCCESS";
        public static final String FAILED = "FAILED";
    }

    public static class ImageExtension {
        public enum Type {
            jpg, png, jpeg, gif, xlsx, pptx, ppt, doc, docx, pdf
        }

        public static List<String> imageExtensions = new ArrayList<String>(4) {{
            add(Type.jpg.name());
            add(Type.png.name());
            add(Type.jpeg.name());
            add(Type.gif.name());
            add(Type.xlsx.name());
            add(Type.pptx.name());
            add(Type.ppt.name());
            add(Type.doc.name());
            add(Type.docx.name());
            add(Type.pdf.name());
        }};
    }

    public static class Notification {
        public enum Status {
            SENT, UNSENT
        }

        public enum Type {
            COMMENT
        }
    }

    public static class Comment {
        public enum Status {
            REMIND, REPLY
        }
    }


    public static class Post {
        public enum Status {
            APPROVED, WAITING_APPROVE, REJECT
        }
    }

    public static final List<String> EXTENTIONS = List.of("doc", "docx", "xls",
            "pdf", "png", "jpg", "jpeg", "pptx", "ppt", "xlsm", "xlsx");

    public static final String ATTRIBUTE_DELIMITER = "#_@_@_#";
    public static final String FORMAT_DATE = "dd/MM/YYYY";
}
