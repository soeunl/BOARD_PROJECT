package org.choongang.global.exceptions;

public class AlertBackException extends AlertException {
    private String target;
    
    public AlertBackException(String message, int status, String target) {
        super(message, status);
        this.target = target;
    } // target : 창에 대한 부분들을 명시
    
    public AlertBackException(String message, int status) {
        this(message, status, "self"); // 메세지를 던져주고 다시 백
    }

    public String getTarget() {
        return target;
    }
}
