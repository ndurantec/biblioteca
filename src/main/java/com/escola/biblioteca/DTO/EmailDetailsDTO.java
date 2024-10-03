package com.escola.biblioteca.DTO;

public class EmailDetailsDTO {

    private String to;
    private String subject;
    private String body;
    private String attachment;

    @Deprecated
    public EmailDetailsDTO() {
    }

    public EmailDetailsDTO(String to, String subject, String body, String attachment) {
        this.to = to;
        this.subject = subject;
        this.body = body;
        this.attachment = attachment;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    @Override
    public String toString() {
        return "EmailDetailsDTO [to=" + to + ", subject=" + subject + ", body=" + body + ", attachment=" + attachment
                + "]";
    }

    
    
}
