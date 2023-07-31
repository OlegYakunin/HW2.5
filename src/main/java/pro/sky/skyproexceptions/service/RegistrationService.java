package pro.sky.skyproexceptions.service;

import pro.sky.skyproexceptions.excaptions.WrongLoginException;
import pro.sky.skyproexceptions.excaptions.WrongPasswordException;

public interface RegistrationService {
    void checkAccount(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException;
}
