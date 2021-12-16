package softuni.gira.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.BAD_REQUEST, reason = "Task invalid data input")
public class TaskIllegalArgumentException extends RuntimeException{
    public TaskIllegalArgumentException() {
    }

    public TaskIllegalArgumentException(String message) {
        super(message);
    }
}
