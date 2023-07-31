package pro.sky.skyproexceptions.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyproexceptions.excaptions.WrongLoginException;
import pro.sky.skyproexceptions.excaptions.WrongPasswordException;
import pro.sky.skyproexceptions.service.RegistrationService;

@RestController
public class AccountController {
    private final RegistrationService registrationService;

    public AccountController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping(path = "/exceptions")
    public void checkAccount(@RequestParam("login") String login, @RequestParam("password") String password, @RequestParam("confirmPassword") String confirmPassword) {
        try {
            registrationService.checkAccount(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            throw new RuntimeException(e);
        } catch (WrongPasswordException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Проверка учетной записи завершена");
        }
    }
}
