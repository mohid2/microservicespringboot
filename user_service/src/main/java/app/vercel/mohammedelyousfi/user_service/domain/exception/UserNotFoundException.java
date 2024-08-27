package app.vercel.mohammedelyousfi.user_service.domain.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserNotFoundException extends RuntimeException {
  private final String message;
}
