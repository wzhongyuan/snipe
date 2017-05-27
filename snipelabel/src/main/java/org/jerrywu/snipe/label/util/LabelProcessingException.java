package org.jerrywu.snipe.label.util;

/**
 * Created by jerry on 17-5-27.
 */
public class LabelProcessingException extends RuntimeException{
    public LabelProcessingException() {
        super();
    }
    public LabelProcessingException(String msg) {
        super("Label processing Exception :" + msg);
    }
}
