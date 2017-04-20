package cn.dev.youngsmith.stockanalysis.util;

import java.util.Arrays;

public class EMail {
    public enum MimeTypeEnum {
        PLANIN("text/plain;charset=UTF-8"),
        HTML("text/html;charset=UTF-8");
        
        private String mineType;
        MimeTypeEnum(String type) {
            this.mineType = type;
        }
        
        public String getTypeString() {
            return mineType;
        }
    }
    private String fromAddr;
    private String[] toAddr;
    private String[] ccAddr;
    private String[] attachPath;
    private String subject;
    private String content;
    private MimeTypeEnum mimeType;
    
    public EMail(String sender, String subject, String... receivers) {
        this.fromAddr = sender;
        if (receivers != null)
            this.toAddr = Arrays.copyOf(receivers, receivers.length);
        this.subject = subject;
        this.mimeType = MimeTypeEnum.PLANIN;
    }
    
    /**
     * get mail sender address
     * 
     * @return sender address
     */
    public String getFromAddr() {
        return fromAddr;
    }
    
    /**
     * get mail receiver address list
     * 
     * @return
     */
    public String[] getToAddr() {
        if (toAddr == null)
            return null;
        else
            return Arrays.copyOf(toAddr, toAddr.length);
    }
    
    /**
     * get mail CC address list
     * 
     * @return
     */
    public String[] getCcAddr() {
        if (ccAddr == null)
            return null;
        else
            return Arrays.copyOf(ccAddr, ccAddr.length);
    }
    
    /**
     * set mail CC address list
     * 
     * @param ccAddr
     */
    public void setCcAddr(String[] ccAddr) {
        if (ccAddr == null)
            return;
        
        this.ccAddr = Arrays.copyOf(ccAddr, ccAddr.length);
    }
    
    /**
     * get mail subject
     * 
     * @return
     */
    public String getSubject() {
        return subject;
    }
    
    /**
     * set mail subject, some mail server forbid empty subject
     * 
     * @param subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    /**
     * get mail attachment file path list
     * 
     * @return
     */
    public String[] getAttachPath() {
        if (attachPath == null)
            return null;
        else
            return Arrays.copyOf(attachPath, attachPath.length);
    }
    
    /**
     * set mail attachment, can be absolute path or relative path with current execution environment
     * 
     * @param attachPath
     */
    public void setAttachPath(String[] attachPath) {
        if (attachPath == null)
            return;
        
        this.attachPath = Arrays.copyOf(attachPath, attachPath.length);
    }

    /**
     * get mail main text, it can be plain text or HTML.
     * how to show depend on mime type.
     * 
     * @return
     */
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MimeTypeEnum getMimeType() {
        return mimeType;
    }

    public void setMimeType(MimeTypeEnum mimeType) {
        this.mimeType = mimeType;
    }
}
