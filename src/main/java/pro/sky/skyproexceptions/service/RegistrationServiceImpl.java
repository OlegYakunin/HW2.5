package pro.sky.skyproexceptions.service;

import org.springframework.stereotype.Service;
import pro.sky.skyproexceptions.excaptions.WrongLoginException;
import pro.sky.skyproexceptions.excaptions.WrongPasswordException;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    public void checkAccount(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (login.length() > 20 || !login.matches("[a-zA-Z0-9_]{1,20}")) {
            throw new WrongLoginException("Введен некорректный login");
        }

        if (password.length() > 20 || !password.matches("[a-zA-Z0-9_]{1,20}")
                || !password.equals(confirmPassword)) {
            throw new WrongPasswordException("Введен некорректный password");
        }
    }
}
